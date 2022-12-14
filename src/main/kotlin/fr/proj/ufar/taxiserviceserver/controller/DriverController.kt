package fr.proj.ufar.taxiserviceserver.controller

import fr.proj.ufar.taxiserviceserver.constant.rest.EMPLOYEE_BASE_URL
import fr.proj.ufar.taxiserviceserver.dto.request.DriverCreateRequest
import fr.proj.ufar.taxiserviceserver.dto.response.DriversPageResponse
import fr.proj.ufar.taxiserviceserver.dto.response.SuccessResponse
import fr.proj.ufar.taxiserviceserver.service.DriverService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(EMPLOYEE_BASE_URL)
class DriverController(private val driverService: DriverService) {

    @PostMapping
    fun addDriver(@RequestBody body: DriverCreateRequest): SuccessResponse {
        driverService.addDriver(body)
        return SuccessResponse()
    }

    @GetMapping("/{fieldName}")
    fun getAllDriversPageSortedByDate(
        @PathVariable fieldName: String,
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "3") size: Int,
    ): DriversPageResponse = driverService.getAllDriversPage(page, size, fieldName)

    @DeleteMapping
    fun deleteDriverByPassportNumber(@RequestParam passportNumber: String): SuccessResponse {
        driverService.deleteDriverByPassportNumber(passportNumber)
        return SuccessResponse()
    }
}
