package fr.proj.ufar.taxiserviceserver.controller

import fr.proj.ufar.taxiserviceserver.constant.rest.BASE_URL
import fr.proj.ufar.taxiserviceserver.dto.request.LoginRequest
import fr.proj.ufar.taxiserviceserver.dto.response.LoginResponse
import fr.proj.ufar.taxiserviceserver.service.AdminService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(BASE_URL)
class AdminController(private val adminService: AdminService) {

    @PostMapping
    fun login(@RequestBody body: LoginRequest): LoginResponse = adminService.login(body)
}
