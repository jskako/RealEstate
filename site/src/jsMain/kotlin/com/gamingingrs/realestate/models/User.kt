package com.gamingingrs.realestate.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
actual class User(
    @SerialName(value = "_id")
    actual val id: String = "",
    actual val username: String = "",
    actual val password: String = ""
)

@Serializable
actual class UserWithoutPassword(
    @SerialName(value = "_id")
    actual val id: String = "",
    actual val username: String = ""
)

