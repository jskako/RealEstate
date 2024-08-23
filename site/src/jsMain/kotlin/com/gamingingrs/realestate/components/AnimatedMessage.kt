package com.gamingingrs.realestate.components

class AnimatedMessage {

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