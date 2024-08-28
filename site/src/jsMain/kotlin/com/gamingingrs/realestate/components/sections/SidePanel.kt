package com.gamingingrs.realestate.components.sections

import androidx.compose.runtime.Composable
import com.gamingingrs.realestate.components.composables.navigation.NavigationItem
import com.gamingingrs.realestate.components.composables.navigation.NavigationItemData
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import org.jetbrains.compose.web.css.percent

@Composable
fun SidePanel(
    navigationItemsData: List<NavigationItemData>
) {
    Column(
        modifier = Modifier
            .backgroundColor(Colors.DarkOliveGreen)
            .fillMaxHeight()
            .fillMaxWidth(30.percent),
    ) {

        navigationItemsData.forEach {
            NavigationItem(
                iconPath = it.iconPath,
                title = it.title,
                onNavigate = it.onNavigate
            )
        }
    }
}