package com.gamingingrs.realestate.utils

import com.gamingingrs.realestate.models.UserWithoutPassword
import com.gamingingrs.realestate.utils.LocalStorage.IS_USER_STORED_KEY
import com.gamingingrs.realestate.utils.LocalStorage.USERNAME_KEY
import com.gamingingrs.realestate.utils.LocalStorage.USER_ID_KEY
import kotlinx.browser.localStorage
import org.w3c.dom.set

fun rememberLoggedIn(
    remember: Boolean,
    user: UserWithoutPassword? = null
) {
    localStorage[IS_USER_STORED_KEY] = remember.toString()
    if (user != null) {
        localStorage[USER_ID_KEY] = user.id
        localStorage[USERNAME_KEY] = user.username
    }
}