package com.kompkit.core

import kotlinx.coroutines.*

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
