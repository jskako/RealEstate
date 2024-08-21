package com.gamingingrs.realestate.models

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb

enum class Theme(
    val hex: String,
    val rgb: CSSColorValue
) {
    Primary(
        hex = "#00A2FF",
        rgb = rgb(r = 0, g = 162, b = 255)
    ),
    LightGray(
        hex = "#FAFAFA",
        rgb = rgb(r = 250, g = 250, b = 250)
    ),
    DarkGray(
        hex = "#e1e1e1",
        rgb = rgb(r = 225, g = 225, b = 225)
    ),
    DarkBlue(
    hex = "#0d152f",
    rgb = rgb(r = 13, g = 21, b = 47)
    ),
    DarkRed(
        hex = "#d42474",
        rgb = rgb(r = 212, g = 36, b = 116)
    )
}