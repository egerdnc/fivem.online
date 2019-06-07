package online.fivem.client.modules.basics

import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import online.fivem.client.common.AbstractClientModule
import online.fivem.client.extensions.disableControlAction
import online.fivem.client.extensions.isControlPressed
import online.fivem.common.extensions.orZero
import online.fivem.common.gtav.NativeControls
import kotlin.js.Date

class ControlHandlerModule(
	private val tickExecutorModule: TickExecutorModule
) : AbstractClientModule() {

	private val handlers = mutableListOf<Listener>()

	private val pressedKeys = mutableMapOf<NativeControls.Keys, Double>()

	override fun onStart() = launch {
		tickExecutorModule.waitForStart()

		tickExecutorModule.add(this@ControlHandlerModule, ::checkPressedKeys)
	}

	override fun onStop(): Job? {
		tickExecutorModule.remove(this)

		return super.onStop()
	}

	fun addListener(listener: Listener) {
		handlers.lastOrNull()?.onFocusLost()
		handlers.add(listener)
	}

	fun removeListener(listener: Listener) {
		handlers.remove(listener)
		handlers.lastOrNull()?.onFocus()
	}

	private fun checkPressedKeys() {

		getRegisteredKeys().forEach { control ->
			val isControlPressed = control.isControlPressed()

			if (isControlPressed) {

				if (pressedKeys[control] == 0.0) {
					pressedKeys[control] = Date.now()

					if (onJustPressed(control)) return disableAllKeys()
				} else if (pressedKeys[control].orZero() > 0 && Date.now() - pressedKeys[control].orZero() > KEY_HOLD_TIME) {
					pressedKeys[control] = -1.0

					if (onLongPressed(control)) return disableAllKeys()
				}

			} else {

				if (pressedKeys[control] != 0.0) {
					pressedKeys[control] = 0.0

					if (pressedKeys[control] != -1.0) {
						if (onShortPressed(control)) return disableAllKeys()
					} else {
						if (onJustReleased(control)) return disableAllKeys()
					}
				}
			}
		}
	}

	private fun getRegisteredKeys(): Set<NativeControls.Keys> {
		val set = mutableSetOf<NativeControls.Keys>()
		handlers.forEach { set.addAll(it.registeredKeys) }
		return set
	}

	private fun onShortPressed(control: NativeControls.Keys): Boolean {
		return handlers.asReversed().any { it.onShortPressed(control) }
	}

	private fun onLongPressed(control: NativeControls.Keys): Boolean {
		return handlers.asReversed().any { it.onLongPressed(control) }
	}

	private fun onJustReleased(control: NativeControls.Keys): Boolean {
		return handlers.asReversed().any { it.onJustReleased(control) }
	}

	private fun onJustPressed(control: NativeControls.Keys): Boolean {
		return handlers.asReversed().any { it.onJustPressed(control) }
	}

	private fun disableAllKeys() {
		NativeControls.Keys.values().forEach {
			it.disableControlAction()
		}
	}

	companion object {

//		private val flashKeys = arrayListOf(
//			NativeControls.Keys.CELLPHONE_SCROLL_BACKWARD,
//			NativeControls.Keys.CURSOR_SCROLL_UP,
//			NativeControls.Keys.CELLPHONE_SCROLL_FORWARD,
//			NativeControls.Keys.CURSOR_SCROLL_DOWN,
//			NativeControls.Keys.PREV_WEAPON,
//			NativeControls.Keys.NEXT_WEAPON,
//			NativeControls.Keys.VEH_SLOWMO_UD,
//			NativeControls.Keys.VEH_SLOWMO_UP_ONLY,
//			NativeControls.Keys.VEH_SLOWMO_DOWN_ONLY
//		)

		private const val KEY_HOLD_TIME = 250
	}

	interface Listener {
		val registeredKeys: List<NativeControls.Keys>

		fun onFocus() {}

		fun onFocusLost() {}

		fun onJustPressed(control: NativeControls.Keys): Boolean = false

		fun onShortPressed(control: NativeControls.Keys): Boolean = false

		fun onLongPressed(control: NativeControls.Keys): Boolean = false

		fun onJustReleased(control: NativeControls.Keys): Boolean = false
	}

//	interface ExtraListener : Listener {
//
//		override val registeredKeys: MutableList<NativeControls.Keys>
//
//		val justHandlers: MutableMap<NativeControls.Keys, () -> Boolean>
//		val shortHandlers: MutableMap<NativeControls.Keys, () -> Boolean>
//		val longHandlers: MutableMap<NativeControls.Keys, () -> Boolean>
//		val releaseHandlers: MutableMap<NativeControls.Keys, () -> Boolean>
//
//		override fun onShortPressed(control: NativeControls.Keys): Boolean = shortHandlers[control]?.invoke() ?: false
//
//		override fun onJustPressed(control: NativeControls.Keys): Boolean = justHandlers[control]?.invoke() ?: false
//
//		override fun onLongPressed(control: NativeControls.Keys): Boolean = longHandlers[control]?.invoke() ?: false
//
//		override fun onJustReleased(control: NativeControls.Keys): Boolean = releaseHandlers[control]?.invoke() ?: false
//
//		fun onShortPressed(control: NativeControls.Keys, callback: () -> Boolean) {
//			if (!registeredKeys.contains(control)) {
//				registeredKeys.add(control)
//			}
//			shortHandlers[control] = callback
//		}
//
//		fun onJustPressed(control: NativeControls.Keys, callback: () -> Boolean) {
//			if (!registeredKeys.contains(control)) {
//				registeredKeys.add(control)
//			}
//			justHandlers[control] = callback
//		}
//
//		fun onLongPressed(control: NativeControls.Keys, callback: () -> Boolean) {
//			if (!registeredKeys.contains(control)) {
//				registeredKeys.add(control)
//			}
//			longHandlers[control] = callback
//		}
//
//		fun onJustReleased(control: NativeControls.Keys, callback: () -> Boolean) {
//			if (!registeredKeys.contains(control)) {
//				registeredKeys.add(control)
//			}
//			releaseHandlers[control] = callback
//		}
//	}
}