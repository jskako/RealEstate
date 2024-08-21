package com.gamingingrs.realestate.components

import androidx.compose.runtime.Composable
import com.gamingingrs.realestate.styles.LoginInputStyle
import com.gamingingrs.realestate.utils.Fonts.FONT_ROBOTO
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Input

@Composable
fun <T> OutlinedInput(
    type: InputType<T>,
    placeholder: String,
    id: String
) {
    Input(
        type = type,
        attrs = LoginInputStyle.toModifier()
            .id(id)
            .margin(bottom = 12.px)
            .width(350.px)
            .height(54.px)
            .padding(leftRight = 20.px)
            .backgroundColor(Colors.White)
            .fontFamily(FONT_ROBOTO)
            .fontSize(14.px)
            .toAttrs {
                attr(PLACEHOLDER_ATTRIBUTE, value = placeholder)
            }
    )
}

private const val PLACEHOLDER_ATTRIBUTE = "placeholder"