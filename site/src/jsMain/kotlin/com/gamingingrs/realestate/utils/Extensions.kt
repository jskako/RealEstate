package com.gamingingrs.realestate.utils

fun Map<String, String>.getOrDefault(key: String, default: String = ""): String {
    return this[key] ?: default
}