package fr.proj.ufar.taxiserviceserver.dto

import com.fasterxml.jackson.annotation.JsonProperty
import fr.proj.ufar.taxiserviceserver.constant.enumeration.Gender
import fr.proj.ufar.taxiserviceserver.domain.Driver
import java.util.Date

data class DriverDto(
    val name: String,
    val surname: String,
    val email: String,
    @JsonProperty("car_id")
    val carId: String,
    @JsonProperty("birth_date")
    val birthDate: Date,
    val gender: Gender,
    val address: Driver.Address,
    @JsonProperty("passport_number")
    val passportNumber: String,
    @JsonProperty("rating_one")
    val ratingOne: Int,
    @JsonProperty("rating_two")
    val ratingTwo: Int,
    @JsonProperty("rating_three")
    val ratingThree: Int,
    @JsonProperty("rating_four")
    val ratingFour: Int,
    @JsonProperty("rating_five")
    val ratingFive: Int,
    @JsonProperty("average_rating")
    val averageRating: Double,
    val location: Pair<Double, Double>,
    val created: Date,
    val updated: Date,
    @JsonProperty("number_of_trips")
    val numberOfTrips: Long,
    val trips: List<String>
)
