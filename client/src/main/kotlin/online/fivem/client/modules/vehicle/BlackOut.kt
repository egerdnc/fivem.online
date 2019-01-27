package online.fivem.client.modules.vehicle

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import online.fivem.client.extensions.play
import online.fivem.client.modules.basics.API
import online.fivem.common.GlobalConfig.BlackOut.ACCELERATION_THRESHOLD
import online.fivem.common.GlobalConfig.BlackOut.BLACKOUT_TIME_FROM_COMMAS
import online.fivem.common.GlobalConfig.BlackOut.EXTRA_BLACKOUT_TIME
import online.fivem.common.GlobalConfig.BlackOut.WAKING_UP_TIME
import online.fivem.common.Sounds
import online.fivem.common.common.AbstractModule
import online.fivem.common.common.Console
import online.fivem.common.common.UEvent
import online.fivem.common.events.AccelerationThresholdAchievedEvent
import online.fivem.common.events.PlayerPedHealthZeroEvent
import online.fivem.common.events.PlayersPedTeleportedEvent
import online.fivem.common.events.PlayersPedTeleportingEvent
import kotlin.coroutines.CoroutineContext

class BlackOut(override val coroutineContext: CoroutineContext) : AbstractModule(), CoroutineScope {

	private val api by moduleLoader.onReady<API>()
	private var timeLeft: Long = 0
	private var isAllowed = true

	override fun onInit() {
		UEvent.on<PlayersPedTeleportingEvent> { isAllowed = false }
		UEvent.on<PlayersPedTeleportedEvent> { isAllowed = true }

		UEvent.on<PlayerPedHealthZeroEvent> {
			if (!isAllowed) return@on
			blackOut(BLACKOUT_TIME_FROM_COMMAS * 1_000)
		}

		UEvent.on<AccelerationThresholdAchievedEvent> {
			if (!isAllowed || it.accelerationModule < ACCELERATION_THRESHOLD) return@on

			Console.debug("blackout from ${it.accelerationModule.toInt()} m/s^2")//todo удалить
			blackOut(
				(
						if (timeLeft > 0)
							it.accelerationModule - ACCELERATION_THRESHOLD
						else
							it.accelerationModule
						).toLong() * 100
			)
		}
	}

	private fun addBlackOut(timeMillis: Long) {
		timeLeft += timeMillis
	}

	private fun blackOut(timeMillis: Long): Job = launch {
		if (timeLeft > 0) return@launch addBlackOut(timeMillis)
		timeLeft += EXTRA_BLACKOUT_TIME * 1_000 + timeMillis

		val blackOutHandle = api.doNuiBlackOut().await()

		val muteHandle = api.muteSound()
		val lockHandle = api.lockControl()
		val ragdollHandle = api.setRagdollEffect()

		var time: Long

		while (timeLeft > 0) {
			time = timeLeft
			delay(time)
			timeLeft -= time
		}

		Sounds.NOISE.play()
		delay(2_000)
		api.unMuteSound(muteHandle)
		api.unLockControl(lockHandle)
		api.undoNuiBlackOut(blackOutHandle, WAKING_UP_TIME * 1_000).join()
		api.removeRagdollEffect(ragdollHandle)
	}
}