package online.fivem.client.modules.basics

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import online.fivem.client.gtav.Client
import online.fivem.common.common.AbstractModule
import online.fivem.common.common.Stack
import kotlin.coroutines.CoroutineContext

class JoinTransitionModule(override val coroutineContext: CoroutineContext) : AbstractModule(), CoroutineScope {

	private var switchingPlayerJob: Job? = null
	private val tickExecutor by moduleLoader.onReady<TickExecutorModule>()
	private val api by moduleLoader.onReady<API>()

	private var muteHandle = Stack.UNDEFINED_INDEX

	override fun onInit() {
		moduleLoader.on<API> {
			Client.setManualShutdownLoadingScreenNui(true)
			startTransition()

			launch {
				switchingPlayerJob?.join()

				Client.shutdownLoadingScreen()
				val fadeHandle = api.doScreenFadeOut(0).await()
				Client.shutdownLoadingScreenNui()
				api.doScreenFadeIn(fadeHandle, 500).join()
			}
		}
	}

	fun startTransition(): Job {
		api.unMuteSound(muteHandle)
		muteHandle = api.muteSound()

		return launch {
			if (!Client.isPlayerSwitchInProgress()) {
				switchingPlayerJob = Client.switchOutPlayer(Client.getPlayerPed())
				switchingPlayerJob?.join()
			}
		}
	}

	fun endTransition(): Job {
		return launch {
			val execId = tickExecutor.add { clearScreen() }

			switchingPlayerJob?.join()
			api.unMuteSound(muteHandle)

			Client.switchInPlayer(Client.getPlayerPed()).join()
			tickExecutor.remove(execId)
			Client.clearDrawOrigin()
		}
	}

	private fun clearScreen() {
		Client.setCloudHatOpacity(CLOUD_OPACITY)
		Client.hideHudAndRadarThisFrame()
		Client.setDrawOrigin(0, 0, 0, 0)
	}

	companion object {
		const val CLOUD_OPACITY = 0.01
	}
}