package com.gamingingrs.realestate.pages.admin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.gamingingrs.realestate.components.Message
import com.gamingingrs.realestate.components.composables.CustomButton
import com.gamingingrs.realestate.components.composables.OutlinedInput
import com.gamingingrs.realestate.models.User
import com.gamingingrs.realestate.models.UserWithoutPassword
import com.gamingingrs.realestate.models.enums.Errors
import com.gamingingrs.realestate.models.enums.Progress.ACTIVE
import com.gamingingrs.realestate.models.enums.Progress.ERROR
import com.gamingingrs.realestate.models.enums.Progress.NOT_ACTIVE
import com.gamingingrs.realestate.utils.Fonts.FONT_ROBOTO
import com.gamingingrs.realestate.utils.Id.PASSWORD_INPUT
import com.gamingingrs.realestate.utils.Id.USERNAME_INPUT
import com.gamingingrs.realestate.utils.Image.HIDDEN_IMG
import com.gamingingrs.realestate.utils.Image.PASSWORD_IMG
import com.gamingingrs.realestate.utils.Image.USERNAME_IMG
import com.gamingingrs.realestate.utils.Image.VISIBLE_IMG
import com.gamingingrs.realestate.utils.LocalStorage.REMEMBER_KEY
import com.gamingingrs.realestate.utils.LocalStorage.USERNAME_KEY
import com.gamingingrs.realestate.utils.LocalStorage.USER_ID_KEY
import com.gamingingrs.realestate.utils.Routes.HOME_ROUTE
import com.gamingingrs.realestate.utils.interpolateColor
import com.gamingingrs.realestate.utils.setDelay
import com.gamingingrs.realestate.utils.userExist
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.text.SpanText
import kotlinx.browser.document
import kotlinx.browser.localStorage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.set

@Page
@Composable
fun LoginScreen() {

    val scope = rememberCoroutineScope()
    val context = rememberPageContext()
    val message by remember { mutableStateOf(Message()) }
    var progress by remember { mutableStateOf(NOT_ACTIVE) }
    var passwordVisible by remember { mutableStateOf(false) }
    var borderColor by remember { mutableStateOf<CSSColorValue>(Colors.DimGray) }

    LaunchedEffect(progress) {
        launch {

            val delayTime = ANIMATION_DURATION / ANIMATION_STEPS

            suspend fun animateColor(fromColor: Color, toColor: Color) {
                for (i in 0..ANIMATION_STEPS) {
                    val fraction = i / ANIMATION_STEPS.toFloat()
                    borderColor = interpolateColor(fromColor, toColor, fraction)
                    delay(delayTime)
                }
            }

            while (progress == ACTIVE) {
                animateColor(Colors.DimGray, Colors.LightGoldenRodYellow)
                animateColor(Colors.LightGoldenRodYellow, Colors.DimGray)
            }
        }
    }

    fun resetProgress() {
        message.reset()
        progress = NOT_ACTIVE
    }

    suspend fun setProgressError(
        error: Errors
    ) {
        progress = ERROR
        message.set("${error.code()}: ${error.message()}")
        setDelay {
            resetProgress()
        }
    }

    Box(
        modifier = Modifier
            .backgroundColor(Colors.AntiqueWhite)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .padding(leftRight = 50.px, top = 20.px, bottom = 24.px)
                .border(
                    width = 1.px,
                    style = LineStyle.Dashed,
                    color = if (progress == ACTIVE) borderColor else Colors.DimGray
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            H1(
                attrs = Modifier
                    .fontFamily(FONT_ROBOTO)
                    .fontWeight(FontWeight.ExtraBold)
                    .margin(topBottom = 50.px)
                    .toAttrs()
            ) {
                Text("REAL ESTATE")
            }

            H4(
                attrs = Modifier
                    .fontFamily(FONT_ROBOTO)
                    .fontWeight(FontWeight.ExtraLight)
                    .margin(bottom = 40.px)
                    .toAttrs()
            ) {
                Text("YOUR WAY TO NEW HOME")
            }

            OutlinedInput(
                type = InputType.Text,
                placeholder = "Username",
                id = USERNAME_INPUT,
                leadingIconPath = USERNAME_IMG,
                isDisabled = progress == ACTIVE
            )

            OutlinedInput(
                type = if (passwordVisible) InputType.Text else InputType.Password,
                placeholder = "Password",
                id = PASSWORD_INPUT,
                leadingIconPath = PASSWORD_IMG,
                trailingIconPath = if (passwordVisible) {
                    VISIBLE_IMG
                } else {
                    HIDDEN_IMG
                },
                isDisabled = progress == ACTIVE,
                onTrailingIconClicked = {
                    passwordVisible = !passwordVisible
                }
            )

            if (progress != ACTIVE) {
                CustomButton(
                    text = "Sign in",
                    onClick = {
                        scope.launch {
                            val username =
                                (document.getElementById(USERNAME_INPUT) as? HTMLInputElement)?.value.orEmpty()
                            val password =
                                (document.getElementById(PASSWORD_INPUT) as? HTMLInputElement)?.value.orEmpty()

                            if (username.isNotEmpty() && password.isNotEmpty()) {
                                progress = ACTIVE
                                message.set("PLEASE HOLD ON WHILE I CHECK IF THE USER IS IN THE SYSTEM")
                                userExist(
                                    User(
                                        username = username,
                                        password = password
                                    )
                                )?.let { user ->
                                    rememberLoggedIn(remember = true, user = user)
                                    context.router.navigateTo(HOME_ROUTE)
                                } ?: run {
                                    setProgressError(
                                        error = Errors.USER_DOESNT_EXIST
                                    )
                                }
                            } else {
                                setProgressError(
                                    error = Errors.INPUT_EMPTY
                                )
                            }
                        }
                    }
                )
            }

            if (progress == ERROR || progress == ACTIVE) {
                SpanText(
                    modifier = Modifier
                        .margin(top = 24.px)
                        .width(350.px)
                        .color(
                            when (progress) {
                                ERROR -> Colors.DarkRed
                                else -> Colors.Black
                            }
                        )
                        .textAlign(TextAlign.Center),
                    text = message.message
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

private const val ANIMATION_DURATION = 2000L
private const val ANIMATION_STEPS = 100