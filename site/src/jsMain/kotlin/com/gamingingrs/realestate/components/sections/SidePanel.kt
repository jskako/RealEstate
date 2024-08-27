package com.gamingingrs.realestate.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.percent

@Composable
fun SidePanel() {
    Column(
        modifier = Modifier
            .backgroundColor(Colors.DarkOliveGreen)
            .fillMaxHeight()
            .fillMaxWidth(30.percent),
    ) {
        SpanText(
            "assaasasas"
        )
    }
}