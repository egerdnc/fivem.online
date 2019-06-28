package online.fivem.client.modules.gui.menu

import kotlinx.coroutines.async
import online.fivem.client.common.AbstractClientModule
import online.fivem.client.modules.basics.ControlHandlerModule
import online.fivem.client.modules.gui.MainControlListenerModule
import online.fivem.common.gtav.NativeControls

class InteractionMenu(
	private val controlHandlerModule: ControlHandlerModule
) : AbstractClientModule() {

	override fun onStartAsync() = async {
		moduleLoader.getModule(MainControlListenerModule::class).onShortPressListener(
			NativeControls.Keys.INTERACTION_MENU,
			::onInteractionMenuButton
		)
	}

	private fun onInteractionMenuButton(): Boolean {

		return true
	}
}