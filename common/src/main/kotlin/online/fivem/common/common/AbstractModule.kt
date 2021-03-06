package online.fivem.common.common

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import online.fivem.common.extensions.forEach
import kotlin.coroutines.CoroutineContext

abstract class AbstractModule : CoroutineScope {

	override val coroutineContext: CoroutineContext =
		createSupervisorJob() + CoroutineExceptionHandler { coroutineContext, throwable ->
			ExceptionsStorage.add(
				Exception("fatal error in module ${this::class.simpleName}: ${throwable.message}", throwable)
			)
		}

	lateinit var moduleLoader: ModuleLoader

	open suspend fun onInit() {}

	open fun onStartAsync(): Deferred<*>? = null

	open fun onStop(): Job? {

		coroutineContext.cancel()

		return null
	}

	suspend fun waitForStart() {
		moduleLoader.getModule(this::class)
	}

	protected inline fun <reified T : Any> Event.on(noinline action: suspend (T) -> Unit): ReceiveChannel<T> {
		val channel = openSubscription(T::class)

		this@AbstractModule.launch {
			channel.forEach {
				action(it)
			}
		}

		return channel
	}

	protected fun Event.emitAsync(data: Any) = launch {
		emit(data)
	}
}