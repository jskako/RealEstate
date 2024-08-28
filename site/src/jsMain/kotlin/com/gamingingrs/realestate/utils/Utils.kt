package com.gamingingrs.realestate.utils

import com.gamingingrs.realestate.models.ColorValue
import com.gamingingrs.realestate.models.enums.Language
import com.gamingingrs.realestate.utils.Delay.SHORT
import com.gamingingrs.realestate.utils.Settings.LANGUAGE_SETTING
import kotlinx.browser.window
import kotlinx.coroutines.await
import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb

suspend inline fun setDelay(
    delay: Long = SHORT,
    onDone: () -> Unit,
) {
    delay(delay)
    onDone()
}

fun interpolateColor(
    startColor: CSSColorValue,
    endColor: CSSColorValue,
    fraction: Float
): CSSColorValue {
    val start = ColorValue(startColor)
    val end = ColorValue(endColor)

    val r = ((1 - fraction) * start.r + fraction * end.r).toInt()
    val g = ((1 - fraction) * start.g + fraction * end.g).toInt()
    val b = ((1 - fraction) * start.b + fraction * end.b).toInt()

    return rgb(r, g, b)
}

suspend fun loadStrings(language: Language): Map<String, String> {
    val response = window.fetch("$LANGUAGE_SETTING/strings_${language.code()}.json").await()
    val json = response.text().await()
    return Json.decodeFromString<Map<String, String>>(json)
}