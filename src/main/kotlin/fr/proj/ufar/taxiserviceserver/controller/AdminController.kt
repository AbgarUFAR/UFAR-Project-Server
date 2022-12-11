package fr.proj.ufar.taxiserviceserver.controller

import fr.proj.ufar.taxiserviceserver.constant.rest.ADMIN_BASE_URL
import fr.proj.ufar.taxiserviceserver.dto.request.LoginRequest
import fr.proj.ufar.taxiserviceserver.dto.response.LoginResponse
import fr.proj.ufar.taxiserviceserver.service.AdminService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(ADMIN_BASE_URL)
class AdminController(private val adminService: AdminService) {

    @PostMapping("/login")
    fun login(@RequestBody body: LoginRequest): LoginResponse = adminService.login(body)

    @GetMapping
    fun f() {
        println("jbfbenfijnejifnjefkneioenfuineinfengniengneigneigneigbdjksjibd9")
    }
}
