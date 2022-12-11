package fr.proj.ufar.taxiserviceserver.dto.request

import com.fasterxml.jackson.annotation.JsonProperty
import fr.proj.ufar.taxiserviceserver.constant.enumeration.Gender
import fr.proj.ufar.taxiserviceserver.dto.CarDto
import org.springframework.format.annotation.DateTimeFormat
import java.util.Date

data class DriverCreateRequest(
    val name: String,
    val surname: String,
    val email: String,
    val car: CarDto,
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @JsonProperty("birth_date")
    val birthDate: Date,
    val gender: Gender,
    val address: Address,
    @JsonProperty("passport_number")
    val passportNumber: String,
) {

    data class Address(
        val country: String,
        val city: String,
        @JsonProperty("postal_code")
        val postalCode: String
    )
}
