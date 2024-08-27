package com.gamingingrs.realestate.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.gamingingrs.realestate.utils.LocalStorage.IS_USER_STORED_KEY
import com.gamingingrs.realestate.utils.LocalStorage.USER_ID_KEY
import kotlinx.browser.localStorage
import org.w3c.dom.get

@Composable
fun userAuthenticated(
    isUserAuthenticated: (Boolean) -> Unit
) {
    val isUserStored = remember { localStorage[IS_USER_STORED_KEY].toBoolean() }
    val userId = remember { localStorage[USER_ID_KEY] }
    var userIdExists by remember { mutableStateOf(false) }

    LaunchedEffect(isUserStored, userId) {
        userIdExists = userId?.let { isUserAuthenticated(it) } ?: false

        if (!isUserStored || !userIdExists) {
            isUserAuthenticated(false)
        }
    }

    if (isUserStored && userIdExists) {
        isUserAuthenticated(true)
    }
}