@file:Suppress("PackageDirectoryMismatch")

package fr.proj.ufar.taxiserviceserver.service.helper.driver

import fr.proj.ufar.taxiserviceserver.domain.Driver
import fr.proj.ufar.taxiserviceserver.dto.DriverDto

fun Driver.toDriverDto(): DriverDto =
    DriverDto(
        name = this.name,
        surname = this.surname,
        email = this.email,
        carId = this.carId!!,
        birthDate = this.birthDate,
        gender = this.gender,
        address = this.address,
        passportNumber = this.passportNumber,
        ratingOne = this.ratingOne,
        ratingTwo = this.ratingTwo,
        ratingThree = this.ratingThree,
        ratingFour = this.ratingFour,
        ratingFive = this.ratingFive,
        averageRating = this.averageRating,
        location = this.location,
        created = this.created!!,
        updated = this.updated!!,
        numberOfTrips = this.numberOfTrips,
        trips = this.trips
    )

fun List<Driver>.toListOfDriversDto(): List<DriverDto> =
    map { it.toDriverDto() }
