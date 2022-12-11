package fr.proj.ufar.taxiserviceserver.domain

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document("trips")
data class Trip(
    val checkpoints: List<Double>,
    @Field("passenger_id")
    val passengerId: String,
    @Field("driver_id")
    val driverId: String,
    val cost: Double
)
