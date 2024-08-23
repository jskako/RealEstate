package com.gamingingrs.realestate.models

import com.gamingingrs.realestate.utils.Regex.RGB_REGEX
import org.jetbrains.compose.web.css.CSSColorValue

data class ColorValue(val color: CSSColorValue) {
    val r: Float
    val g: Float
    val b: Float

    init {
        val matchResult = Regex(RGB_REGEX).find(color.toString())
        if (matchResult != null) {
            r = matchResult.groupValues.getOrNull(1)?.toFloat() ?: 0f
            g = matchResult.groupValues.getOrNull(2)?.toFloat() ?: 0f
            b = matchResult.groupValues.getOrNull(3)?.toFloat() ?: 0f
        } else {
            r = 0f
            g = 0f
            b = 0f
        }
    }
}