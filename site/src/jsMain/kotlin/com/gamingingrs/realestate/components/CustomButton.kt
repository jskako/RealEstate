package com.gamingingrs.realestate.components

import androidx.compose.runtime.Composable
import com.gamingingrs.realestate.models.Theme
import com.gamingingrs.realestate.utils.Constants.Fonts.FONT_ROBOTO
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.outline
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button

@Composable
fun CustomButton(
    text: String
) {
    Button(
        attrs = Modifier
            .width(350.px)
            .height(54.px)
            .backgroundColor(Theme.Primary.rgb)
            .color(Colors.White)
            .borderRadius(r = 4.px)
            .fontFamily(FONT_ROBOTO)
            .fontWeight(FontWeight.Medium)
            .fontSize(16.px)
            .border(
                width = 0.px,
                style = LineStyle.None,
                color = Colors.Transparent
            )
            .outline(
                width = 0.px,
                style = LineStyle.None,
                color = Colors.Transparent
            )
            .toAttrs()
    ) {
        SpanText(
            text = text
        )
    }
}