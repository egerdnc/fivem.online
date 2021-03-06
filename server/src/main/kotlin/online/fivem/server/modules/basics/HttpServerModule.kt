package online.fivem.server.modules.basics


import external.nodejs.express.Express
import external.nodejs.express.Server
import external.nodejs.express.getInstance
import external.nodejs.requireNodeJSModule
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import online.fivem.common.GlobalConfig
import online.fivem.common.common.Console
import online.fivem.common.extensions.forEach
import online.fivem.server.ServerConfig.CURRENT_RESOURCE_PATH
import online.fivem.server.common.AbstractServerModule

class HttpServerModule : AbstractServerModule() {

	private val express = requireNodeJSModule("express").unsafeCast<Express>()
	private val app = express.getInstance()
	private var server: Server? = null

	override suspend fun onInit() {
		app.use("/common", express.static(ROOT_DIR + "common"))
		app.use("/nui", express.static(ROOT_DIR + "nui"))
		app.use("/loadingScreen", express.static(ROOT_DIR + "loadingScreen"))
	}

	override fun onStartAsync() = async {
		val pauseChannel = Channel<Throwable>()

		server = app.listen(HTTP_PORT) { error ->
			pauseChannel.close()

			error?.let {
				launch {
					pauseChannel.send(Exception(it))
				}
				return@listen
			}

			Console.info("http server is listening at port $HTTP_PORT")
		}

		pauseChannel.forEach {
			throw it
		}
	}

	override fun onStop(): Job? {
		server?.close()
		return super.onStop()
	}

	companion object {
		private const val HTTP_PORT = GlobalConfig.HTTP_PORT
		private val ROOT_DIR = CURRENT_RESOURCE_PATH
	}
}