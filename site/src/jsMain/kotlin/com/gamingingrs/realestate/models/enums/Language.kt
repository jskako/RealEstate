package com.gamingingrs.realestate.models.enums

enum class Language {

    ENGLISH {
        override fun code() = "en"
    };

    abstract fun code(): String
}