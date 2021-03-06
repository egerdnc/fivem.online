package online.fivem.server.gtav

import external.exports.http_handler.Request
import external.exports.http_handler.Response
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import online.fivem.common.GlobalConfig
import online.fivem.common.common.Html
import online.fivem.server.entities.PlayerSrc

private external val exports: dynamic

object Exports {
	private val external = online.fivem.server.gtav.exports
	private val exports = external[GlobalConfig.MODULE_NAME]

	fun executeCommand(command: String, delay: Int = 1_000) {
		external["resourceManager"].executeCommand(command, delay)
	}

	fun restartResource(resource: String) {
		external["resourceManager"].restartResource(resource)
	}

	fun performHttpRequest(
		coroutineScope: CoroutineScope,
		url: String,
		httpRequestType: String = "GET",
		data: Map<String, String>? = null,
		headers: Any = object {}
	): Deferred<String> {

		val postData =
			data?.map { Html.urlEncode(it.key) + "=" + Html.urlEncode(it.value) }?.joinToString("&").orEmpty()

		val channel = Channel<String>()

		exports.performHttpRequest(url, { _: Int, response: String, _: Any ->
			coroutineScope.launch {
				channel.send(response)
			}
			Unit
		}, httpRequestType, postData, headers)

		return coroutineScope.async {
			val result = channel.receive()
			channel.close()
			return@async result
		}
	}

	fun onNet(eventName: String, callback: (PlayerSrc, Any) -> Unit) {
		exports.onNet(eventName) { playerId: Int, data: Any ->
			callback(PlayerSrc(playerId), data)
		}
	}

	fun on(eventName: String, callback: Any) {
		exports.on(eventName, callback)
	}

	fun setHttpHandler(handler: (Request, Response) -> Unit) {
		exports.setHttpHandler(handler)
	}
}