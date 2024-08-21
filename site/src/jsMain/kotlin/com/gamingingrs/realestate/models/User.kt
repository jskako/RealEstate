package com.gamingingrs.realestate.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName(value = "_id")
    val id: String = "",
    val username: String = "",
    val password: String = ""
)

@Serializable
data class UserWithoutPassword(
    @SerialName(value = "_id")
    val id: String = "",
    val username: String = ""
)

