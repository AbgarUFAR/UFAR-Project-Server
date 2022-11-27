package fr.proj.ufar.taxiserviceserver.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document("admin")
class Admin(
    @Id
    val id: String,
    @Field("username")
    val username: String,
    @Field("password")
    val password: String, // WGqbdlAcY4
    @Field("key")
    val key: String
)
