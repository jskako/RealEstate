package com.gamingingrs.realestate.pages.admin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.gamingingrs.realestate.components.composables.navigation.NavigationItemData
import com.gamingingrs.realestate.components.sections.SidePanel
import com.gamingingrs.realestate.utils.Image.PASSWORD_IMG
import com.gamingingrs.realestate.utils.Routes.FORBIDDEN_ROUTE
import com.gamingingrs.realestate.utils.userAuthenticated
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.text.SpanText

@Page
@Composable
fun HomeScreen() {

    val context = rememberPageContext()
    var isUserAuthenticated by remember { mutableStateOf<Boolean?>(null) }

    userAuthenticated(
        isUserAuthenticated = {
            isUserAuthenticated = it
        }
    )

    when (isUserAuthenticated) {
        true -> {
            HomeLayout()
        }

        false -> {
            context.router.navigateTo(FORBIDDEN_ROUTE)
        }

        else -> Unit
    }
}

@Composable
private fun HomeLayout() {
    Row(
        modifier = Modifier
            .backgroundColor(Colors.AntiqueWhite)
            .fillMaxSize()
    ) {
        SidePanel(
            listOf(
                NavigationItemData(
                    iconPath = PASSWORD_IMG,
                    title = "Just Test",
                    onNavigate = {
                        println("Clicked")
                    }
                )
            )
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            SpanText(
                "fwdsfdfsdMgf"
            )
        }
    }
}