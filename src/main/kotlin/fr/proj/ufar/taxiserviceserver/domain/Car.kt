package fr.proj.ufar.taxiserviceserver.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.Date

@Document("cars")
data class Car(
    @Id
    val id: String? = null,
    val mark: String,
    @Field("driver_id")
    val driverId: String,
    val model: String,
    @Field("plate_number")
    @Indexed(unique = true)
    val plateNumber: String,
    @CreatedDate
    val created: Date? = null,
    @LastModifiedDate
    val updated: Date? = null
)
