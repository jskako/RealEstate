package com.gamingingrs.realestate.util

import java.nio.charset.StandardCharsets
import java.security.MessageDigest

fun hashPassword(password: String): String {
    val messageDigest = MessageDigest.getInstance("SHA-256")
    val hashBytes = messageDigest.digest(password.toByteArray(StandardCharsets.UTF_8))
    return hashBytes.joinToString("") { "%02x".format(it) }
}