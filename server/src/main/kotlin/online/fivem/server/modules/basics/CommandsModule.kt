package online.fivem.server.modules.basics

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import online.fivem.common.common.AbstractModule
import online.fivem.server.entities.Player
import kotlin.coroutines.CoroutineContext

class CommandsModule(override val coroutineContext: CoroutineContext) : AbstractModule(), CoroutineScope {

	private val sessionModule by moduleLoader.onReady<SessionModule>()

	override fun onStart(): Job? {
		launch {
			for (command in executionQueue) {
				val player = sessionModule.getPlayer(command.playerSrc) ?: continue

				CommandEvent.handle(
					Command(
						player = player,
						command = command.command,
						args = command.args,
						raw = command.raw
					)
				)
			}
		}

		return super.onStart()
	}

	override fun onStop(): Job? {
		executionQueue.close()

		return super.onStop()
	}

	class RawCommand(
		val playerSrc: Int,
		val command: String,
		val args: Array<String>,
		val raw: String
	)

	class Command(
		val player: Player,
		val command: String,
		val args: Array<String>,
		val raw: String
	)

	companion object {
		val executionQueue = Channel<RawCommand>(32)
	}
}