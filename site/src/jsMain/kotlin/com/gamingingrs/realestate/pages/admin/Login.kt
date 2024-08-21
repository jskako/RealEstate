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
import com.gamingingrs.realestate.utils.Image.LOCK
import com.gamingingrs.realestate.utils.LocalStorage.REMEMBER_KEY
import com.gamingingrs.realestate.utils.LocalStorage.USERNAME_KEY
import com.gamingingrs.realestate.utils.LocalStorage.USER_ID_KEY
import com.gamingingrs.realestate.utils.Routes.HOME_ROUTE
import com.gamingingrs.realestate.utils.setDelay
import com.gamingingrs.realestate.utils.userExist
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
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
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Progress
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.set

@Page
@Composable
fun LoginScreen() {

    val scope = rememberCoroutineScope()
    val context = rememberPageContext()
    var errorText by remember { mutableStateOf("") }
    var progress by remember { mutableStateOf(Progress.NOT_ACTIVE) }

    fun resetProgress() {
        errorText = ""
        progress = Progress.NOT_ACTIVE
    }

    suspend fun setProgressError(error: String) {
        progress = Progress.ERROR
        errorText = error
        setDelay {
            resetProgress()
        }
    }

    Box(
        modifier = Modifier
            .backgroundColor(Theme.DarkBlue.rgb)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(leftRight = 50.px, top = 20.px, bottom = 24.px)
                .border(
                    width = 4.px,
                    style = LineStyle.Solid,
                    color = Theme.Primary.rgb
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .margin(bottom = 20.px)
                    .width(100.px),
                src = LOCK,
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
                visibility = when (progress) {
                    Progress.NOT_ACTIVE, Progress.ERROR -> Visibility.Visible
                    Progress.ACTIVE -> Visibility.Hidden
                },
                onClick = {
                    scope.launch {
                        val username =
                            (document.getElementById(USERNAME_INPUT) as? HTMLInputElement)?.value.orEmpty()
                        val password =
                            (document.getElementById(PASSWORD_INPUT) as? HTMLInputElement)?.value.orEmpty()

                        if (username.isNotEmpty() && password.isNotEmpty()) {
                            progress = Progress.ACTIVE
                            userExist(User(username = username, password = password))?.let { user ->
                                rememberLoggedIn(remember = true, user = user)
                                context.router.navigateTo(HOME_ROUTE)
                            } ?: run {
                                setProgressError(error = "The user doesn't exist.")
                            }
                        } else {
                            setProgressError(error = "Input fields are empty.")
                        }
                    }
                }
            )

            if (progress == Progress.ACTIVE) {
                Progress()
            }

            if (progress == Progress.ERROR) {
                SpanText(
                    modifier = Modifier
                        .margin(top = 24.px)
                        .width(350.px)
                        .color(Theme.DarkRed.rgb)
                        .textAlign(TextAlign.Center),
                    text = errorText
                )
            }
        }
    }
}

private fun rememberLoggedIn(
    remember: Boolean,
    user: UserWithoutPassword? = null
) {
    localStorage[REMEMBER_KEY] = remember.toString()
    if (user != null) {
        localStorage[USER_ID_KEY] = user.id
        localStorage[USERNAME_KEY] = user.username
    }
}

enum class Progress {
    ACTIVE, NOT_ACTIVE, ERROR
}