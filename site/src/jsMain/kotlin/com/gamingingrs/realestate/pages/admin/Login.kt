package com.gamingingrs.realestate.pages.admin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.gamingingrs.realestate.components.CustomButton
import com.gamingingrs.realestate.components.OutlinedInput
import com.gamingingrs.realestate.models.Theme
import com.gamingingrs.realestate.models.User
import com.gamingingrs.realestate.models.UserWithoutPassword
import com.gamingingrs.realestate.utils.Id.PASSWORD_INPUT
import com.gamingingrs.realestate.utils.Id.USERNAME_INPUT
import com.gamingingrs.realestate.utils.Res
import com.gamingingrs.realestate.utils.setError
import com.gamingingrs.realestate.utils.userExist
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
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import kotlinx.browser.document
import kotlinx.browser.localStorage
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.px
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.set

@Page
@Composable
fun LoginScreen() {

    val scope = rememberCoroutineScope()
    val context = rememberPageContext()
    var errorText by remember { mutableStateOf<String?>(null) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(leftRight = 50.px, top = 20.px, bottom = 24.px)
                .backgroundColor(Theme.DarkGray.rgb),
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
                placeholder = "Username",
                id = USERNAME_INPUT
            )

            OutlinedInput(
                type = InputType.Password,
                placeholder = "Password",
                id = PASSWORD_INPUT
            )

            CustomButton(
                text = "Sign in",
                onClick = {
                    scope.launch {
                        errorText = null
                        val username =
                            (document.getElementById(USERNAME_INPUT) as? HTMLInputElement)?.value.orEmpty()
                        val password =
                            (document.getElementById(PASSWORD_INPUT) as? HTMLInputElement)?.value.orEmpty()

                        if (username.isNotEmpty() && password.isNotEmpty()) {
                            userExist(User(username = username, password = password))?.let { user ->
                                rememberLoggedIn(remember = true, user = user)
                                context.router.navigateTo("admin/home")
                            } ?: run {
                                setError(
                                    error = "The user doesn't exist."
                                ) { errorText = it }
                            }
                        } else {
                            setError("Input fields are empty.") { errorText = it }
                        }
                    }
                }
            )

            errorText?.let {
                SpanText(
                    modifier = Modifier
                        .margin(top = 24.px)
                        .width(350.px)
                        .color(Colors.Red)
                        .textAlign(TextAlign.Center),
                    text = it
                )
            }
        }
    }
}

private fun rememberLoggedIn(
    remember: Boolean,
    user: UserWithoutPassword? = null
) {
    localStorage["remember"] = remember.toString()
    if (user != null) {
        localStorage["userId"] = user.id
        localStorage["username"] = user.username
    }
}