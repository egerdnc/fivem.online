package online.fivem.client.modules.vehicle

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import online.fivem.client.gtav.Client
import online.fivem.common.GlobalConfig
import online.fivem.common.common.AbstractModule
import online.fivem.common.common.UEvent
import online.fivem.common.events.PlayersVehicleHealthChangedEvent

class BlackOut : AbstractModule() {

	private var isBlackedOut = false

	override fun init() {
		UEvent.on<PlayersVehicleHealthChangedEvent> {
			if (GlobalConfig.BlackOut.blackOutFromDamage && -it.bodyDiff >= GlobalConfig.BlackOut.blackoutDamageRequired) {
				GlobalScope.launch {
					blackOut(
						GlobalConfig.BlackOut.blackOutTime + 1_000 * (-it.bodyDiff - GlobalConfig.BlackOut.blackoutDamageRequired)
					)
				}
			}
		}
	}

	private suspend fun blackOut(timeMillis: Long) {
		if (isBlackedOut) return

		Client.doScreenFadeOut(100)

		while (!Client.isScreenFadedOut()) {
			delay(100)
		}

		delay(timeMillis)

		Client.doScreenFadeIn(timeMillis.toInt() / 10)
	}
}