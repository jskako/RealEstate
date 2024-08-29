package com.gamingingrs.realestate.components.sections

import androidx.compose.runtime.Composable
import com.gamingingrs.realestate.components.composables.navigation.NavigationItem
import com.gamingingrs.realestate.components.composables.navigation.NavigationItemData
import com.gamingingrs.realestate.utils.Fonts.FONT_ROBOTO
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Text

@Composable
fun SidePanel(
    title: String,
    navigationItemsData: List<NavigationItemData>
) {
    Column(
        modifier = Modifier
            .backgroundColor(Colors.DarkOliveGreen)
            .fillMaxHeight()
            .fillMaxWidth(30.percent),
    ) {

        H2(
            attrs = Modifier
                .fontFamily(FONT_ROBOTO)
                .fontWeight(FontWeight.ExtraLight)
                .toAttrs()
        ) {
            Text(title)
        }

        navigationItemsData.forEach {
            NavigationItem(
                iconPath = it.iconPath,
                title = it.text,
                onNavigate = it.onNavigate
            )
        }
    }
}