package com.gamingingrs.realestate.utils

import kotlinx.coroutines.delay

suspend fun setDelay(
    delay: Long = SHORT_DELAY,
    onDone: () -> Unit,
) {
    delay(delay)
    onDone()
}

const val SHORT_DELAY = 3000L