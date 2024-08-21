package com.gamingingrs.realestate.api

import com.gamingingrs.realestate.data.MongoDB
import com.gamingingrs.realestate.models.User
import com.gamingingrs.realestate.models.UserWithoutPassword
import com.gamingingrs.realestate.utils.EndPointConstants.USER_CHECK_ENDPOINT
import com.varabyte.kobweb.api.Api
import com.varabyte.kobweb.api.ApiContext
import com.varabyte.kobweb.api.data.getValue
import com.varabyte.kobweb.api.http.setBodyText
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.nio.charset.StandardCharsets
import java.security.MessageDigest

@Api(routeOverride = USER_CHECK_ENDPOINT)
suspend fun userCheck(context: ApiContext) {
    runCatching {
        val userRequest = context.req.body?.decodeToString()?.let { json ->
            Json.decodeFromString<User>(json)
        }

        val user = userRequest?.let {
            context.data.getValue<MongoDB>().getUser(
                User(
                    username = it.username,
                    password = hashPassword(password = it.password)
                )
            )
        }

        user?.let {
            UserWithoutPassword(
                id = it.id,
                username = it.username
            )
        } ?: throw Exception("User doesn't exist.")
    }.onSuccess { userWithoutPassword ->
        context.res.setBodyText(Json.encodeToString(userWithoutPassword))
    }.onFailure { e ->
        context.res.setBodyText(Json.encodeToString(mapOf("error" to e.message)))
    }
}

private fun hashPassword(password: String): String {
    val messageDigest = MessageDigest.getInstance("SHA-256")
    val hashBytes = messageDigest.digest(password.toByteArray(StandardCharsets.UTF_8))
    return hashBytes.joinToString("") { "%02x".format(it) }
}