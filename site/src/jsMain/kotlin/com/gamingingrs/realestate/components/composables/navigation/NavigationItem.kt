package com.gamingingrs.realestate.components.composables.navigation

import androidx.compose.runtime.Composable
import com.gamingingrs.realestate.styles.NavigationItemStyle
import com.gamingingrs.realestate.utils.Fonts.FONT_ROBOTO
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Text

@Composable
fun NavigationItem(
    iconPath: String,
    title: String,
    onNavigate: () -> Unit
) {

    Row(
        modifier = NavigationItemStyle
            .toModifier()
            .fillMaxWidth()
            .onClick {
                onNavigate()
            },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Img(
            src = iconPath,
            attrs = Modifier
                .padding(right = 10.px)
                .size(40.px)
                .toAttrs()
        )

        H3(
            attrs = Modifier
                .fontFamily(FONT_ROBOTO)
                .fontWeight(FontWeight.ExtraLight)
                .toAttrs()
        ) {
            Text(title)
        }
    }
}