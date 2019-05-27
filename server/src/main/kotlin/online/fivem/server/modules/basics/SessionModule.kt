package online.fivem.server.modules.basics

import external.nodejs.mysql.Pool
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import online.fivem.common.common.Console
import online.fivem.common.common.Event
import online.fivem.common.entities.PlayerSrc
import online.fivem.common.events.net.ImReadyEvent
import online.fivem.common.gtav.NativeEvents
import online.fivem.server.Strings
import online.fivem.server.common.AbstractServerModule
import online.fivem.server.entities.Player
import online.fivem.server.entities.mysqlEntities.BlackListTable
import online.fivem.server.entities.mysqlEntities.UserEntity
import online.fivem.server.events.PlayerConnectedEvent
import online.fivem.server.gtav.Exports
import online.fivem.server.gtav.Natives
import online.fivem.server.modules.basics.mysql.MySQLModule
import online.fivem.server.modules.basics.mysql.extensions.getConnection
import online.fivem.server.modules.basics.mysql.extensions.row
import online.fivem.server.modules.basics.mysql.extensions.send
import online.fivem.server.modules.client_event_exchanger.ClientEvent
import kotlin.collections.set
import kotlin.coroutines.CoroutineContext

class SessionModule(override val coroutineContext: CoroutineContext) : AbstractServerModule() {


	private val players = mutableMapOf<PlayerSrc, Player>()

	private lateinit var mySQL: Pool

	override suspend fun onInit() {
		Exports.on(NativeEvents.Server.PLAYER_CONNECTING, ::onClientConnecting)
		Exports.on(NativeEvents.Server.PLAYER_DROPPED, ::onPlayerDropped)

		ClientEvent.onGuest<ImReadyEvent> { playerSrc: PlayerSrc, _ -> onClientReady(playerSrc) }

	}

	override fun onStart() = launch {
		mySQL = moduleLoader.getModule(MySQLModule::class).pool
	}

	fun getConnectedPlayers(): List<PlayerSrc> {
		return players.map { it.key }
	}

	fun getPlayer(playerSrc: Int): Player? {
		players.forEach {
			if (it.key.value == playerSrc) {
				return it.value
			}
		}

		return null
	}

	private fun onClientReady(playerSrc: PlayerSrc) = launch {

		val identifiers = Natives.getPlayerIdentifiers(playerSrc)

		val user = mySQL.getConnection().row<UserEntity>(
			"""SELECT id
					|FROM users
					|WHERE
					|   steam=? AND
					|   license=?
					|""".trimMargin(),
			arrayOf(
				identifiers.steam,
				identifiers.license
			)
		) ?: return@launch Natives.dropPlayer(playerSrc, Strings.NO_SUCH_USER)

		val sessionId = mySQL.getConnection().send(
			"""INSERT INTO sessions
					|SET
					|  user_id=?,
					|  steam=?,
					|  discord=?,
					|  license=?,
					|  ip=?
					|""".trimMargin(),
			arrayOf(
				user.id,
				identifiers.steam,
				identifiers.discord,
				identifiers.license,
				identifiers.ip
			)
		).insertId ?: return@launch Natives.dropPlayer(playerSrc, Strings.SESSION_HAVE_NOT_BEEN_CREATED)

		val player = Player(
			playerSrc = playerSrc,
			name = identifiers.name.orEmpty(),
			sessionId = sessionId,
			userId = user.id
		)

		players[playerSrc] = player

		Event.emit(PlayerConnectedEvent(player))
	}

	private fun onPlayerDropped(playerId: Int, reason: String) {

		launch {
			players.forEach {
				if (it.key.value == playerId) {
					val player = it.value
					players.remove(it.key)

					mySQL.getConnection().send(
						"""UPDATE sessions
						|SET
						|   left_reason=?,
						|   logout_date=NOW()
						|WHERE id=?
						|LIMIT 1""".trimMargin(),
						arrayOf(
							reason,
							player.sessionId
						)
					)

					return@launch Console.log("disconnected ${player.name}: $reason")
				}
			}

			Console.log("disconnected $playerId: $reason")
		}
	}

	private fun onClientConnecting(source: Int, playerName: String, setKickReason: (reason: String) -> Unit) {

		launch {
			val identifiers = Natives.getPlayerIdentifiers(source)

			val blackList = async {
				mySQL.getConnection().row<BlackListTable>(
					"""SELECT reason
				|FROM `black_list`
				|WHERE
				|   ip=? OR
				|   steam=? OR
				|   license=?
				|""".trimMargin(),
					arrayOf(
						identifiers.ip,
						identifiers.steam,
						identifiers.license
					)
				)
			}

			Console.log("connecting $playerName ${identifiers.ip} ${identifiers.license} ${identifiers.steam}")


			blackList.await()?.let {
				val reason = Strings.YOU_ARE_BANNED_FROM_THIS_SERVER.replace("%s", it.reason.orEmpty())
				Natives.mainThread {
					setKickReason(reason)
				}
			}
		}
	}
}