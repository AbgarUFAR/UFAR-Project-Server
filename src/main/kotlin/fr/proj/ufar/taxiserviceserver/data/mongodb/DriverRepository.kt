package fr.proj.ufar.taxiserviceserver.data.mongodb

import fr.proj.ufar.taxiserviceserver.domain.Driver
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.repository.Update

interface DriverRepository : MongoRepository<Driver, String>, DriverTemplateRepository {

    fun existsByPassportNumber(passportNumber: String): Boolean

    fun findByPassportNumber(passportNumber: String): Driver?

    @Query("{'_id': ?0}")
    @Update("{ \$set: { 'car_id': ?1, 'updated': new Date() } }")
    fun updateCarId(driverId: String, carId: String)
}
