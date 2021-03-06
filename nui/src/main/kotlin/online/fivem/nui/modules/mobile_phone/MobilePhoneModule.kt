package online.fivem.nui.modules.mobile_phone

import js.externals.jquery.JQuery
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import online.fivem.common.extensions.repeatJob
import online.fivem.nui.common.AbstractNuiModule
import online.fivem.nui.modules.basics.GUIModule
import online.fivem.nui.modules.mobile_phone.apps.BrowserAppModule
import online.fivem.nui.modules.mobile_phone.apps.SmsAppModule
import org.w3c.dom.HTMLElement

class MobilePhoneModule(
	private val guiModule: GUIModule
) : AbstractNuiModule() {

	var signal = 1f
		set(value) {
			val left = signalBarOverlayView.css("border-left")
				.replace(Regex("[^ ]+( .*)"), "${(signalBarMaxWidth * value).toInt()}px$1")

			val right = signalBarOverlayView.css("border-bottom")
				.replace(Regex("[^ ]+( .*)"), "${(signalBarMaxWidth * value).toInt()}px$1")

			signalBarOverlayView.css("border-left", left)
			signalBarOverlayView.css("border-bottom", right)

			field = value
		}

	var battery = 1f
		set(value) {
			field = value
			batteryLevelView.text("${100 * value}%")
			batteryOverlayView.css("width", "${value * batteryMaxWidth}")
		}

	private lateinit var signalBarOverlayView: JQuery<HTMLElement>
	private lateinit var batteryOverlayView: JQuery<HTMLElement>
	private lateinit var batteryLevelView: JQuery<HTMLElement>

	private lateinit var phoneContainerView: JQuery<HTMLElement>
	private lateinit var phoneView: JQuery<HTMLElement>

	lateinit var browserFrame: JQuery<HTMLElement>

	private val signalBarMaxWidth by lazy {
		signalBarOverlayView.css("border-left").replace(Regex("([0-9 ]+).*"), "$1").toInt()
	}

	private val batteryMaxWidth by lazy {
		batteryOverlayView.css("width").replace(Regex("([0-9]+)px"), "$1").toInt()
	}

	override suspend fun onInit() {
		moduleLoader.add(MobilePhoneBrowserModule(this))
	}

	override fun onStartAsync() = async {
		guiModule.waitForStart()

		val mainView = guiModule.mainView

		browserFrame = mainView.view.find("#browser_frame")

		phoneContainerView = mainView.view.find("#phone_container")
		phoneView = phoneContainerView.find("#phone_screen").contents()

		signalBarOverlayView = phoneView.find("#signal_bar_overlay")
		batteryOverlayView = phoneView.find("#battery_overlay")
		batteryLevelView = phoneView.find("#battery_level")

		this@MobilePhoneModule.repeatJob(2_000) {
			signal = 0.2f
			battery = 0.2f
			delay(1_000)
			signal = 0.8f
			battery = 0.8f
		}
	}
}