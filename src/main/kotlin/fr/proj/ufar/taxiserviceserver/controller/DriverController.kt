package fr.proj.ufar.taxiserviceserver.controller

import fr.proj.ufar.taxiserviceserver.constant.rest.EMPLOYEE_BASE_URL
import fr.proj.ufar.taxiserviceserver.dto.request.DriverCreateRequest
import fr.proj.ufar.taxiserviceserver.dto.response.SuccessResponse
import fr.proj.ufar.taxiserviceserver.service.DriverService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(EMPLOYEE_BASE_URL)
class DriverController(private val driverService: DriverService) {

    @PostMapping
    fun addDriver(@RequestBody body: DriverCreateRequest): SuccessResponse {
        driverService.addDriver(body)
        return SuccessResponse()
    }
}
