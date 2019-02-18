package online.fivem.client.extensions

import online.fivem.client.modules.nui_event_exchanger.NuiEvent
import online.fivem.common.Sounds
import online.fivem.common.events.nui.PlaySoundEvent
import online.fivem.common.events.nui.PrefetchFileEvent

suspend fun Sounds.play(volume: Double = 1.0) {
	NuiEvent.emit(
		PlaySoundEvent(
			sound = file,
			volume = volume
		)
	)
}

fun Sounds.prefetch() {
	NuiEvent.emitAsync(PrefetchFileEvent(Sounds.PATH + file))
}