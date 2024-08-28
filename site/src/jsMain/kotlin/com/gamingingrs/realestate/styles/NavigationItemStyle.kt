package com.gamingingrs.realestate.styles

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover

val NavigationItemStyle = CssStyle {
    base {
        Modifier.color(
            Colors.White
        )
    }
    hover {
        Modifier.color(
            Colors.Red
        )
    }
}