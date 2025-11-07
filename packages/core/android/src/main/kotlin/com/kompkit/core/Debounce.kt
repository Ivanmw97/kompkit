package com.kompkit.core

import kotlinx.coroutines.*

/**
 * Debounces consecutive calls and emits only the last one after [waitMs] milliseconds.
 * Subsequent calls within the wait period cancel the previous scheduled execution.
 *
 * @param T The type of parameter accepted by the debounced function.
 * @param waitMs Milliseconds to wait before invoking the destination callback. Defaults to 250ms.
 * @param scope Coroutine scope used to schedule the delayed execution.
 * @param dest Destination callback invoked after the debounce period elapses.
 * @return A debounced function that accepts a parameter of type [T].
 *
 * @sample
 * ```kotlin
 * val scope = CoroutineScope(Dispatchers.Main)
 * val search = debounce<String>(300L, scope) { query ->
 *     println("Searching: $query")
 * }
 * search("hello") // Will execute after 300ms if no other calls are made
 * ```
 */
fun <T> debounce(waitMs: Long = 250L, scope: CoroutineScope, dest: (T) -> Unit): (T) -> Unit {
    var job: Job? = null
    return { param: T ->
        job?.cancel()
        job = scope.launch {
            delay(waitMs)
            dest(param)
        }
    }
}
