package com.gamingingrs.realestate.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.litote.kmongo.id.ObjectIdGenerator

@Serializable
actual class User(
    @SerialName(value = "_id")
    actual val id: String = ObjectIdGenerator.newObjectId<String>().id.toHexString(),
    actual val username: String = "",
    actual val password: String = ""
)

@Serializable
actual class UserWithoutPassword(
    @SerialName(value = "_id")
    actual val id: String = ObjectIdGenerator.newObjectId<String>().id.toHexString(),
    actual val username: String = ""
)

