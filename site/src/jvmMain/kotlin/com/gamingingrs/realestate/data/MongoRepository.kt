package com.gamingingrs.realestate.data

import com.gamingingrs.realestate.models.User

interface MongoRepository {
    suspend fun getUser(user: User): User?
    suspend fun isUserAuthenticated(id: String): Boolean
}