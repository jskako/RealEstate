package com.gamingingrs.realestate.pages.admin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.gamingingrs.realestate.components.CustomButton
import com.gamingingrs.realestate.components.OutlinedInput
import com.gamingingrs.realestate.models.Theme
import com.gamingingrs.realestate.utils.Res
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.px

@Page
@Composable
fun LoginScreen() {

    var errorText by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(leftRight = 50.px, top = 20.px, bottom = 24.px)
                .backgroundColor(Theme.LightGray.rgb),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .margin(bottom = 20.px)
                    .width(100.px),
                src = Res.Image.LOGIN,
                description = "Login Image"
            )

            OutlinedInput(
                type = InputType.Text,
                placeholder = "Username"
            )

            OutlinedInput(
                type = InputType.Password,
                placeholder = "Password"
            )

            CustomButton(
                text = "Sign in"
            )

            if (errorText.isNotEmpty()) {
                SpanText(
                    modifier = Modifier
                        .margin(top = 24.px)
                        .width(350.px)
                        .color(Colors.Red)
                        .textAlign(TextAlign.Center),
                    text = errorText
                )
            }
        }
    }
}