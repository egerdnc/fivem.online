package online.fivem.nui.modules.basics.test

import js.externals.jquery.JQuery
import js.externals.jquery.jQuery
import online.fivem.nui.common.View
import org.w3c.dom.HTMLElement

class MainView : View() {
	override val view: JQuery<HTMLElement> = jQuery("#content")
}