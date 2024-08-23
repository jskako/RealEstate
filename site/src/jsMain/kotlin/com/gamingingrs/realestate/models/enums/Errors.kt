package com.gamingingrs.realestate.models.enums

enum class Errors {

    INPUT_EMPTY {
        override fun code() = "ERR001"
        override fun message() = "USER DOESN'T EXIST"
    },

    USER_DOESNT_EXIST {
        override fun code() = "ERR002"
        override fun message() = "INPUT FIELDS MUST NOT BE EMPTY"
    };

    abstract fun code(): String
    abstract fun message(): String
}