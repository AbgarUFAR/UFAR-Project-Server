package fr.proj.ufar.taxiserviceserver.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("admin")
data class Admin(
    @Id
    val id: String,
    val username: String,
    val password: String, // WGqbdlAcY4
    val key: String
)
