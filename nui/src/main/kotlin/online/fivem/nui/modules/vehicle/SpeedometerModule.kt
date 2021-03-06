package online.fivem.nui.modules.vehicle

import js.externals.jquery.JQuery
import js.externals.jquery.jQuery
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import online.fivem.common.common.Html
import online.fivem.common.common.Utils
import online.fivem.common.events.nui.SpeedometerModuleEvent
import online.fivem.nui.common.AbstractNuiModule
import online.fivem.nui.extensions.nuiResourcesLink
import online.fivem.nui.extensions.toHTMLImageElement
import online.fivem.nui.modules.basics.GUIModule
import online.fivem.nui.modules.client_event_exchanger.ClientEvent
import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLCanvasElement
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLImageElement
import kotlin.browser.document
import kotlin.js.Date

class SpeedometerModule(
	private val guiModule: GUIModule
) : AbstractNuiModule() {

	private val speedometerArrow: HTMLImageElement by lazy {
		jQuery("<img src=\"$RESOURCES_DIR/arrow-speedometer.svg\"/>").toHTMLImageElement()
	}

	private val tachometerArrow: HTMLImageElement by lazy {
		jQuery("<img src=\"$RESOURCES_DIR/arrow-tachometer.svg\"/>").toHTMLImageElement()
	}

	private var speedometerContainer: JQuery<HTMLElement>? = null

	private var speedometerBlock: JQuery<HTMLElement>? = null

	private val speedometerInterpolatorChannel = Channel<SpeedometerData>(1)

	private var drawInterpolatorJob: Job? = null

	private val canvas: HTMLCanvasElement = document.createElement("canvas") as HTMLCanvasElement
	private val context2D: CanvasRenderingContext2D = canvas.getContext("2d") as CanvasRenderingContext2D

	init {
		context2D.canvas.width = 440
		context2D.canvas.height = 212
	}

	override suspend fun onInit() {
		ClientEvent.apply {
			on<SpeedometerModuleEvent.Update> {
				launch {
					speedometerInterpolatorChannel.send(
						SpeedometerData(
							speed = it.dashboardSpeed,
							rpm = it.currentRpm
						)
					)
				}
			}
			on<SpeedometerModuleEvent.Enable> {
				runSpeedometer()
				speedometerContainer?.fadeIn()
			}
			on<SpeedometerModuleEvent.Disable> {
				speedometerContainer?.fadeOut()
				drawInterpolatorJob?.cancel()
			}
		}
	}

	override fun onStartAsync() = async {
		guiModule.waitForStart()

		speedometerContainer = guiModule.mainView.view.find("#speedometer_container")
		speedometerBlock = speedometerContainer?.find("#speedometer")
		speedometerContainer?.hide()
		speedometerBlock?.append(canvas)
	}

	override fun onStop(): Job? {
		drawInterpolatorJob?.cancel()
		speedometerInterpolatorChannel.close()

		return super.onStop()
	}

	private fun runSpeedometer() = launch {

		var lastSpeed = 0.0
		var lastRpm = 0.0
		var lastUpdate = Date.now()

		var stepRPM: Double
		var stepSpeed: Double

		var del: Long = 0
		var drawingTime: Double

		for (data in speedometerInterpolatorChannel) {
			stepRPM = (data.rpm * 180 - lastRpm) / INTERPOLATION_STEPS
			stepSpeed = (data.speed * Utils.MPS_TO_MILES_PER_HOUR * 180 / 150 - lastSpeed) / INTERPOLATION_STEPS

			for (i in 1..INTERPOLATION_STEPS) {
				drawingTime = Date.now()
				context2D.clearRect(0.0, 0.0, context2D.canvas.width.toDouble(), context2D.canvas.height.toDouble())
				drawRotatedImage(
					tachometerArrow,
					105.0,
					102.0,
					lastRpm,
					tachometerArrow.width.toDouble() / 2,
					17.02
				)
				drawRotatedImage(
					speedometerArrow,
					291.0,
					182.0,
					lastSpeed,
					148.0,
					speedometerArrow.height.toDouble() / 2
				)

				lastRpm += stepRPM
				lastSpeed += stepSpeed

				if (i != INTERPOLATION_STEPS) {
					delay(del - (Date.now() - drawingTime).toLong())
				}
			}

			del = (Date.now() - lastUpdate).toLong() / INTERPOLATION_STEPS
			lastUpdate = Date.now()
		}
	}.also {
		drawInterpolatorJob?.cancel()
		drawInterpolatorJob = it
	}

	private fun drawRotatedImage(
		image: HTMLImageElement,
		x: Double,
		y: Double,
		angle: Double,
		rotatePointX: Double,
		rotatePointY: Double
	) {

		context2D.save()
		context2D.translate(x, y)
		context2D.rotate(angle * TO_RADIANS)
		context2D.drawImage(image, -rotatePointX, -rotatePointY)
		context2D.restore()
	}

	private class SpeedometerData(
		val speed: Double,
		val rpm: Double
	)

	companion object {

		private val RESOURCES_DIR = Html.nuiResourcesLink("modules/speedometer/v1")

		private const val TO_RADIANS = kotlin.math.PI / 180
		private const val INTERPOLATION_STEPS = 10
	}
}