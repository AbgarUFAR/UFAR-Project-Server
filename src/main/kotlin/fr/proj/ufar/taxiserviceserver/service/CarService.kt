package fr.proj.ufar.taxiserviceserver.service

import fr.proj.ufar.taxiserviceserver.data.mongodb.CarRepository
import fr.proj.ufar.taxiserviceserver.domain.Car
import fr.proj.ufar.taxiserviceserver.dto.CarDto
import org.springframework.stereotype.Service

@Service
class CarService(private val repository: CarRepository) {

    fun existsByPlateNumber(plateNumber: String): Boolean = repository.existsByPlateNumber(plateNumber)

    fun addCar(car: CarDto, driverId: String): Car =
        repository.save(
            Car(
                mark = car.mark,
                driverId = driverId,
                plateNumber = car.plateNumber,
                model = car.model
            )
        )

    fun deleteCarById(id: String) = repository.deleteById(id)
}
