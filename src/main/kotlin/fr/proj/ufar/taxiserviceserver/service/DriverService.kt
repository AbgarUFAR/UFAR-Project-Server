package fr.proj.ufar.taxiserviceserver.service

import fr.proj.ufar.taxiserviceserver.data.mongodb.DriverRepository
import fr.proj.ufar.taxiserviceserver.domain.Driver
import fr.proj.ufar.taxiserviceserver.dto.request.DriverCreateRequest
import fr.proj.ufar.taxiserviceserver.exception.CarAlreadyExistsException
import fr.proj.ufar.taxiserviceserver.exception.DriverAlreadyExistsException
import org.springframework.stereotype.Service

@Service
class DriverService(
    private val repository: DriverRepository,
    private val carService: CarService
) {

    fun addDriver(request: DriverCreateRequest) {
        if (repository.existsByPassportNumber(request.passportNumber)) {
            throw DriverAlreadyExistsException("passport number")
        }
        if (carService.existsByPlateNumber(request.car.plateNumber)) {
            throw CarAlreadyExistsException("plate number")
        }

        val driver = Driver(
            name = request.name,
            surname = request.surname,
            email = request.email,
            birthDate = request.birthDate,
            gender = request.gender,
            address = Driver.Address(
                country = request.address.country,
                city = request.address.city,
                postalCode = request.address.postalCode
            ),
            passportNumber = request.passportNumber,
        )
        val insertedDriver = repository.save(driver)
        val insertedCar = carService.addCar(request.car, insertedDriver.id!!)
        repository.updateCarId(insertedDriver.id, insertedCar.id!!)
    }
}
