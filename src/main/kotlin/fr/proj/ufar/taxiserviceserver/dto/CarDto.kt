package fr.proj.ufar.taxiserviceserver.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class CarDto(
    val mark: String,
    val model: String,
    @JsonProperty("plate_number")
    val plateNumber: String
)
