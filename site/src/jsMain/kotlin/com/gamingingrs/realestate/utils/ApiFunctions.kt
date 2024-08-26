package com.gamingingrs.realestate.utils

import com.gamingingrs.realestate.models.User
import com.gamingingrs.realestate.models.UserWithoutPassword
import com.gamingingrs.realestate.utils.EndPointConstants.IS_USER_AUTHENTICATED
import com.gamingingrs.realestate.utils.EndPointConstants.USER_CHECK_ENDPOINT
import com.varabyte.kobweb.browser.api
import kotlinx.browser.window
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

suspend fun userExist(user: User) = runCatching {
    val result = window.api.tryPost(
        apiPath = USER_CHECK_ENDPOINT,
        body = Json.encodeToString(user).encodeToByteArray()
    )
    result?.decodeToString()?.let { Json.decodeFromString<UserWithoutPassword>(it) }
}.onFailure { e ->
    println(e.message)
}.getOrNull()

suspend fun isUserAuthenticated(id: String): Boolean = runCatching {
    window.api.tryPost(
        apiPath = IS_USER_AUTHENTICATED,
        body = Json.encodeToString(id).encodeToByteArray()
    )?.decodeToString()?.let { Json.decodeFromString<Boolean>(it) } ?: false
}.onFailure { e ->
    println(e.message)
}.getOrNull() ?: false