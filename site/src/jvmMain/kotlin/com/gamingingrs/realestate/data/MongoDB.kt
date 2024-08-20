package com.gamingingrs.realestate.data

import com.gamingingrs.realestate.models.User
import com.gamingingrs.realestate.util.Constants.DATABASE_NAME
import com.varabyte.kobweb.api.data.add
import com.varabyte.kobweb.api.init.InitApi
import com.varabyte.kobweb.api.init.InitApiContext
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.litote.kmongo.and
import org.litote.kmongo.eq
import org.litote.kmongo.reactivestreams.KMongo
import org.litote.kmongo.reactivestreams.getCollection

@InitApi
fun initMongoDB(context: InitApiContext) {
    System.setProperty(
        MONGO_MAPPING_SERVICE,
        MONGO_SERIALIZATION
    )
    context.data.add(
        MongoDB(context = context)
    )
}

class MongoDB(val context: InitApiContext) : MongoRepository {

    private val client = KMongo.createClient()
    private val database = client.getDatabase(DATABASE_NAME)

    override suspend fun getUser(user: User): User? = runCatching {
        database.getCollection<User>()
            .find(
                and(
                    User::username eq user.username,
                    User::password eq user.password
                )
            )
            .awaitFirstOrNull()
    }.onFailure { e ->
        context.logger.error(e.message ?: "An unknown error occurred")
    }.getOrNull()
}

private const val MONGO_MAPPING_SERVICE = "org.litote.mongo.test.mapping.service"
private const val MONGO_SERIALIZATION =
    "org.litote.kmongo.serialization.SerializationClassMappingTypeService"