package com.gamingingrs.realestate.components.composables

import androidx.compose.runtime.Composable
import com.gamingingrs.realestate.styles.LoginInputStyle
import com.gamingingrs.realestate.utils.Fonts.FONT_ROBOTO
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.left
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.right
import org.jetbrains.compose.web.css.top
import org.jetbrains.compose.web.css.transform
import org.jetbrains.compose.web.dom.Input

@OptIn(ExperimentalComposeWebApi::class)
@Composable
fun <T> OutlinedInput(
    type: InputType<T>,
    placeholder: String,
    id: String,
    leadingIconPath: String? = null,
    onLeadingIconClicked: (() -> Unit)? = null,
    trailingIconPath: String? = null,
    onTrailingIconClicked: (() -> Unit)? = null,
) {
    Box(
        modifier = Modifier
            .styleModifier {
                position(Position.Relative)
            }
    ) {

        leadingIconPath?.let {
            ImageBox(
                modifier = Modifier
                    .styleModifier {
                        position(Position.Absolute)
                        left(10.px)
                        top(40.percent)
                        transform {
                            translateY((-50).percent)
                        }
                    },
                iconPath = it,
                onClick = onLeadingIconClicked
            )
        }

        Input(
            type = type,
            attrs = LoginInputStyle.toModifier()
                .id(id)
                .margin(bottom = 12.px)
                .width(350.px)
                .height(54.px)
                .padding(
                    left = if (leadingIconPath != null) 50.px else 20.px,
                    right = if (leadingIconPath != null) 40.px else 20.px
                )
                .backgroundColor(Colors.White)
                .fontFamily(FONT_ROBOTO)
                .fontSize(14.px)
                .toAttrs {
                    attr(PLACEHOLDER_ATTRIBUTE, value = placeholder)
                }
        )

        trailingIconPath?.let {
            ImageBox(
                modifier = Modifier
                    .styleModifier {
                        position(Position.Absolute)
                        right(10.px)
                        top(40.percent)
                        transform {
                            translateY((-50).percent)
                        }
                    },
                iconPath = it,
                onClick = onTrailingIconClicked
            )
        }
    }
}

private const val PLACEHOLDER_ATTRIBUTE = "placeholder"