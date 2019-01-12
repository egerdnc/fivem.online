package online.fivem.common.common

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import online.fivem.common.events.ModuleLoadedEvent
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

class ModuleLoader {
	private val queue = Channel<AbstractModule>(128)
	private var finally: (() -> Unit)? = null

	private val modules = mutableListOf<AbstractModule>()

	private val events = Event()

	fun add(module: AbstractModule) {
		module.moduleLoader = this@ModuleLoader
		module.init()
		GlobalScope.launch {
			queue.send(module)
		}
	}

	fun finally(function: () -> Unit) {
		finally = function
	}

	@ExperimentalCoroutinesApi
	fun start() {
		GlobalScope.launch {

			while (!queue.isEmpty) {
				val module = queue.receive()
				Console.log("start module ${module::class.simpleName}")
				module.start()?.join()

				val event = ModuleLoadedEvent(module)

				UEvent.emit(event)
				events.emit(event)

				modules.add(module)
			}
			finally?.invoke()
		}
	}

	fun stop() {
		GlobalScope.launch {
			modules.asReversed().forEach {
				Console.log("stop module ${it::class.simpleName}")
				modules.remove(it)
				it.stop()?.join()
			}
		}
	}

	inline fun <reified T : AbstractModule> on(noinline function: (T) -> Unit) {
		on(T::class, function)
	}

	fun <T : AbstractModule> on(kClass: KClass<T>, function: (T) -> Unit) {
		events.on(kClass, function)
	}

	inline fun <reified ModuleType : AbstractModule> onReady(): OnLocalModuleLoaded<ModuleType> {
		return OnLocalModuleLoaded(ModuleType::class)
	}

//	companion object {
//		inline fun <reified ModuleType : AbstractModule> onReady(): OnGlobalModuleLoaded<ModuleType> {
//			return OnGlobalModuleLoaded(ModuleType::class)
//		}
//	}

	class OnLocalModuleLoaded<T : AbstractModule>(private val kClass: KClass<T>) {
		private var value: T? = null

		operator fun getValue(thisRef: AbstractModule, property: KProperty<*>): T {
			value?.let {
				return it
			}

			val module = thisRef.moduleLoader.modules.find { it::class == kClass }?.unsafeCast<T>()
				?: throw Exception("module ${kClass.simpleName} used in ${thisRef::class.simpleName}/${property.name} have not been loaded")

			value = module

			return module
		}
	}

//	class OnGlobalModuleLoaded<T : AbstractModule>(private val kClass: KClass<T>) {
//		private var value: T? = null
//
//		init {
//			UEvent.on<ModuleLoadedEvent> {
//				if (kClass.isInstance(it)) {
//					value = it.module.unsafeCast<T>()
//				}
//			}
//		}
//
//		operator fun getValue(thisRef: AbstractModule, property: KProperty<*>): T {
//			value?.let {
//				return it
//			}
//
//			throw Exception("module ${kClass.simpleName} used in ${property.name} have not been loaded")
//		}
//	}

	private class Event : UEvent() {
		fun <T : AbstractModule> on(kClass: KClass<T>, function: (T) -> Unit) {
			handlers.add(kClass to function.unsafeCast<(Any) -> Unit>())
		}
	}
}