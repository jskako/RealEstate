package com.gamingingrs.realestate.components

class Message {

    var message: String = ""
        private set

    fun set(
        text: String
    ) {
        message = text
    }

    fun reset() {
        message = ""
    }
}