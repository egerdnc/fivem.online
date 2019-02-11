package online.fivem.common.events.local

import online.fivem.common.gtav.RadioStation

sealed class PlayerVehicleRadioToggledEvent(val isEnabled: Boolean) {

	class Disabled : PlayerVehicleRadioToggledEvent(false)

	class Enabled(val radioStation: RadioStation) : PlayerVehicleRadioToggledEvent(true)
}