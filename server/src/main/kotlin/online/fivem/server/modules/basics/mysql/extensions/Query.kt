package online.fivem.server.modules.basics.mysql.extensions

import external.nodejs.mysql.Connection
import external.nodejs.requireNodeJSModule
import external.nodejs.stream.Stream
import external.nodejs.stream.TransformParams
import kotlinx.coroutines.channels.Channel
import online.fivem.common.extensions.forEach

suspend fun <T> Connection.Query.forEach(function: (T) -> Unit) {
	val stream = requireNodeJSModule("stream").unsafeCast<Stream>()
	val pauseChannel = Channel<Unit>()

	stream()
		.pipe(stream.Transform(TransformParams(transform = { data: T, encoding, callback ->
			function(data)

			callback()
		})))
		.on("finish") {
			pauseChannel.close()
		}

	pauseChannel.forEach { }
}