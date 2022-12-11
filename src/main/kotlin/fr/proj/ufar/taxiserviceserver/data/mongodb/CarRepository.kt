package fr.proj.ufar.taxiserviceserver.data.mongodb

import fr.proj.ufar.taxiserviceserver.domain.Car
import org.springframework.data.mongodb.repository.MongoRepository

interface CarRepository : MongoRepository<Car, String> {

    fun existsByPlateNumber(plateNumber: String): Boolean
}
