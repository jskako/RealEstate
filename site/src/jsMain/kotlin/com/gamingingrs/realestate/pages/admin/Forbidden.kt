package com.gamingingrs.realestate.pages.admin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.gamingingrs.realestate.utils.Delay.SHORT
import com.gamingingrs.realestate.utils.Fonts.FONT_ROBOTO
import com.gamingingrs.realestate.utils.Image.SMILE_IMG
import com.gamingingrs.realestate.utils.Routes.LOGIN_ROUTE
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Text

@Page
@Composable
fun ForbiddenScreen() {

    val context = rememberPageContext()

    LaunchedEffect(Unit) {
        launch {
            delay(SHORT)
            context.router.navigateTo(LOGIN_ROUTE)
        }
    }
    Column(
        modifier = Modifier
            .padding(leftRight = 50.px, top = 20.px, bottom = 24.px)
            .backgroundColor(Colors.AntiqueWhite)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        H2(
            attrs = Modifier
                .fontFamily(FONT_ROBOTO)
                .fontWeight(FontWeight.ExtraLight)
                .toAttrs()
        ) {
            Text("403 Forbidden:")
        }
        H3(
            attrs = Modifier
                .fontFamily(FONT_ROBOTO)
                .fontWeight(FontWeight.ExtraLight)
                .toAttrs()
        ) {
            Text("Sorry, you've stumbled into the Forbidden Zone")
        }

        Img(
            src = SMILE_IMG
        )
    }
}