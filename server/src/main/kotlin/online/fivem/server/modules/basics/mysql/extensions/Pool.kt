package online.fivem.server.modules.basics.mysql.extensions

import external.nodejs.mysql.Connection
import external.nodejs.mysql.Pool
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import online.fivem.common.common.CustomScope

suspend fun Pool.getConnection(): Connection {

	class Result(
		val connection: Connection?,
		val error: Connection.Error? = null
	)

	val resultChannel = Channel<Result>()

	getConnection { error, connection ->
		CustomScope.launch {
			resultChannel.send(Result(connection, error))
		}
	}

	val result = resultChannel.receive()

	result.error?.let {
		throw Exception("Pool.getConnection(): ${it.code} " + JSON.stringify(it))
	}

	return result.connection!!
}