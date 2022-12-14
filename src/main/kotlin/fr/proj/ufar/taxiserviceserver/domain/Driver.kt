package fr.proj.ufar.taxiserviceserver.domain

import com.fasterxml.jackson.annotation.JsonProperty
import fr.proj.ufar.taxiserviceserver.constant.enumeration.Gender
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.Date

@Document("drivers")
data class Driver(
    @Id
    val id: String? = null,
    val name: String,
    val surname: String,
    val email: String,
    @Field("car_id")
    val carId: String? = null,
    @Field("birth_date")
    val birthDate: Date,
    val gender: Gender,
    val address: Address,
    @Field("passport_number")
    @Indexed(unique = true)
    val passportNumber: String,
    @Field("rating_one")
    val ratingOne: Int = 0,
    @Field("rating_two")
    val ratingTwo: Int = 0,
    @Field("rating_three")
    val ratingThree: Int = 0,
    @Field("rating_four")
    val ratingFour: Int = 0,
    @Field("rating_five")
    val ratingFive: Int = 0,
    @Field("average_rating")
    val averageRating: Double = 0.0,
    val location: Pair<Double, Double> = Pair(0.0, 0.0),
    @CreatedDate
    val created: Date? = null,
    @LastModifiedDate
    val updated: Date? = null,
    @Field("number_of_trips")
    val numberOfTrips: Long = 0,
    val trips: List<String> = emptyList()
) {

    data class Address(
        val country: String,
        val city: String,
        @Field("postal_code")
        @JsonProperty("postal_code")
        val postalCode: String
    )
}
