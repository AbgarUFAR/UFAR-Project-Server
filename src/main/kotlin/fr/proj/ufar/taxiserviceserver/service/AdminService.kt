package fr.proj.ufar.taxiserviceserver.service

import fr.proj.ufar.taxiserviceserver.data.mongodb.AdminRepository
import fr.proj.ufar.taxiserviceserver.dto.request.LoginRequest
import fr.proj.ufar.taxiserviceserver.dto.response.LoginResponse
import fr.proj.ufar.taxiserviceserver.exception.AdminLoginException
import org.apache.commons.codec.digest.DigestUtils
import org.apache.logging.log4j.kotlin.Logging
import org.springframework.stereotype.Service

@Service
class AdminService(private val repository: AdminRepository) {

    companion object : Logging

    fun login(request: LoginRequest): LoginResponse {
        logger.debug { "username = ${request.username} password = ${request.password}" }
        println(request.username)
        println(request.password)
        val admin = repository.findByUsername(request.username) ?: throw AdminLoginException()
        if (admin.password != DigestUtils.sha256Hex(request.password)) {
            throw AdminLoginException()
        }
        return LoginResponse(admin.key)
    }
}
