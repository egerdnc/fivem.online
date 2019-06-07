package online.fivem.client.modules.vehicle

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import online.fivem.client.common.AbstractClientModule
import online.fivem.client.events.AccelerationThresholdAchievedEvent
import online.fivem.client.events.PlayerSpawnProcess
import online.fivem.client.events.PlayersPedHealthChangedEvent
import online.fivem.client.extensions.play
import online.fivem.client.extensions.prefetch
import online.fivem.client.gtav.Client
import online.fivem.client.modules.basics.BufferedActionsModule
import online.fivem.common.GlobalConfig.BlackOut.ACCELERATION_THRESHOLD
import online.fivem.common.GlobalConfig.BlackOut.BLACKOUT_TIME_FROM_COMMAS
import online.fivem.common.GlobalConfig.BlackOut.EXTRA_BLACKOUT_TIME
import online.fivem.common.GlobalConfig.BlackOut.WAKING_UP_TIME
import online.fivem.common.Sounds
import online.fivem.common.common.Console
import online.fivem.common.common.Event

class BlackOutModule(
	private val bufferedActionsModule: BufferedActionsModule
) : AbstractClientModule() {

	private var timeLeft: Long = 0
	private var isAllowed = false

	override suspend fun onInit() {
		Event.apply {
			on<PlayerSpawnProcess> {
				launch {
					isAllowed = false
					it.join()
					isAllowed = true
				}
			}
			on<PlayersPedHealthChangedEvent.Zero> {
				if (!isAllowed) return@on
				Console.debug("blackout from death (${it.diff})")
				blackOut(BLACKOUT_TIME_FROM_COMMAS * 1_000)
			}
			on<AccelerationThresholdAchievedEvent> {
				if (!isAllowed || it.accelerationModule < ACCELERATION_THRESHOLD) return@on

				val playerPed = Client.getPlayerPedId()
				val currentHealth = Client.getEntityHealth(playerPed)

				Client.setEntityHealth(playerPed, currentHealth - it.accelerationModule.toInt() / 50)
				Console.debug("blackout from ${it.accelerationModule} m/s^2")
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

		launch {
			Sounds.SHOCK_EFFECT.prefetch()
		}
	}

	override fun onStart() = launch {
		bufferedActionsModule.waitForStart()
	}

	override fun onStop(): Job? {
		timeLeft = 0

		return null
	}

	private fun addBlackOut(timeMillis: Long) {
		timeLeft += timeMillis
	}

	private fun blackOut(timeMillis: Long): Job = launch {
		if (timeLeft > 0) return@launch addBlackOut(timeMillis)
		timeLeft += EXTRA_BLACKOUT_TIME * 1_000 + timeMillis

		val blackOutHandle = bufferedActionsModule.setBlackScreen()

		val muteHandle = bufferedActionsModule.muteSound()
		val lockHandle = bufferedActionsModule.lockControl()
		val ragdollHandle = bufferedActionsModule.setRagdollEffect()

		var time: Long

		while (timeLeft > 0) {
			time = timeLeft
			delay(time)
			timeLeft -= time
		}

		launch { Sounds.SHOCK_EFFECT.play() }
		delay(2_000)
		bufferedActionsModule.unMuteSound(muteHandle)
		bufferedActionsModule.unLockControl(lockHandle)
		bufferedActionsModule.unSetBlackScreen(blackOutHandle.await(), WAKING_UP_TIME * 1_000).join()
		bufferedActionsModule.removeRagdollEffect(ragdollHandle)
	}
}