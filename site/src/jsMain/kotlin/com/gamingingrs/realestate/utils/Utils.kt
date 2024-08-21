package com.gamingingrs.realestate.utils

import kotlinx.coroutines.delay

suspend fun setError(
    error: String,
    delay: Long = SHORT_DELAY,
    onError: (String?) -> Unit,
) {
    onError(error)
    delay(delay)
    onError(null)
}

const val SHORT_DELAY = 3000L