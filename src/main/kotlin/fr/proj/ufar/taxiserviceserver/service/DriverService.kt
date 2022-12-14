package fr.proj.ufar.taxiserviceserver.service

import fr.proj.ufar.taxiserviceserver.data.mongodb.DriverRepository
import fr.proj.ufar.taxiserviceserver.domain.Driver
import fr.proj.ufar.taxiserviceserver.dto.request.DriverCreateRequest
import fr.proj.ufar.taxiserviceserver.dto.response.DriversPageResponse
import fr.proj.ufar.taxiserviceserver.exception.CarAlreadyExistsException
import fr.proj.ufar.taxiserviceserver.exception.DriverAlreadyExistsException
import fr.proj.ufar.taxiserviceserver.exception.UnsupportedPaginationFieldNameException
import fr.proj.ufar.taxiserviceserver.service.helper.driver.toListOfDriversDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

private val supportedPaginationFields = arrayOf("created", "average_rating", "number_of_trips")

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

    fun getAllDriversPage(page: Int, size: Int, sortFieldName: String): DriversPageResponse {
        if (!supportedPaginationFields.contains(sortFieldName)) {
            throw UnsupportedPaginationFieldNameException(sortFieldName)
        }

        val paging = PageRequest.of(page, size)
        val pageDrivers: Page<Driver> = repository.findAllDriversByPage(paging, sortFieldName)
        val drivers = pageDrivers.content
        return DriversPageResponse(
            drivers = drivers.toListOfDriversDto(),
            isFirst = pageDrivers.isFirst,
            isLast = pageDrivers.isLast
        )
    }

    fun deleteDriverByPassportNumber(passportNumber: String) {
        val driver = repository.findByPassportNumber(passportNumber) ?: return
        carService.deleteCarById(driver.carId!!)
        repository.delete(driver)
    }
}
