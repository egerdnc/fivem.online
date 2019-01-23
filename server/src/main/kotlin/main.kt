package online.fivem.server

import online.fivem.common.GlobalConfig
import online.fivem.common.common.Console
import online.fivem.common.common.ModuleLoader
import online.fivem.common.gtav.NativeEvents
import online.fivem.server.gtav.Natives
import online.fivem.server.modules.basics.BasicsModule
import online.fivem.server.modules.clientEventExchanger.ClientEventExchangerModule
import online.fivem.server.modules.rolePlaySystem.RolePlaySystemModule

internal fun main() {
	Natives.on(NativeEvents.Server.RESOURCE_START) { resourceName: String ->
		if (resourceName == GlobalConfig.MODULE_NAME) {
			start()
		}
	}
}

fun start() {
	Console.log("server side loading..")

	ModuleLoader().apply {

		add(BasicsModule())

		add(RolePlaySystemModule())

//		add(Test())

		add(ClientEventExchangerModule())//last

		finally {
			Console.log("server side loaded")
		}
	}.start()
}