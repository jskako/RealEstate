package com.gamingingrs.realestate.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Img

@Composable
fun ImageBox(
    modifier: Modifier = Modifier,
    iconPath: String,
    alt: String = "",
    onClick: (() -> Unit)? = null
) {
    Box(
        modifier = modifier
    ) {
        Img(
            src = iconPath,
            alt = alt,
            attrs = Modifier
                .size(20.px)
                .let {
                    if (onClick != null) {
                        it.onClick {
                            onClick()
                        }
                    } else it
                }
                .toAttrs()
        )
    }
}