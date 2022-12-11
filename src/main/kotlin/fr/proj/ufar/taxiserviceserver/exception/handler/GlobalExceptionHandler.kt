package fr.proj.ufar.taxiserviceserver.exception.handler

import fr.proj.ufar.taxiserviceserver.constant.error.CONFLICT
import fr.proj.ufar.taxiserviceserver.constant.error.NOT_FOUND
import fr.proj.ufar.taxiserviceserver.constant.error.UNAUTHORIZED
import fr.proj.ufar.taxiserviceserver.dto.response.ErrorResponse
import fr.proj.ufar.taxiserviceserver.exception.AdminLoginException
import fr.proj.ufar.taxiserviceserver.exception.AuthorizationException
import fr.proj.ufar.taxiserviceserver.exception.CarAlreadyExistsException
import fr.proj.ufar.taxiserviceserver.exception.DriverAlreadyExistsException
import org.apache.logging.log4j.kotlin.Logging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    companion object : Logging

    @ExceptionHandler
    fun adminLoginExceptionHandler(e: AdminLoginException): ResponseEntity<ErrorResponse> {
        errorLog(e)
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(
                ErrorResponse(
                    errorCode = NOT_FOUND,
                    errorMessage = e.message
                )
            )
    }

    @ExceptionHandler
    fun authorizationExceptionHandler(e: AuthorizationException): ResponseEntity<ErrorResponse> {
        errorLog(e)
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .body(
                ErrorResponse(
                    errorCode = UNAUTHORIZED,
                    errorMessage = e.message
                )
            )
    }

    @ExceptionHandler
    fun driverAlreadyExistsExceptionHandler(e: DriverAlreadyExistsException): ResponseEntity<ErrorResponse> {
        errorLog(e)
        return ResponseEntity.status(HttpStatus.CONFLICT)
            .body(
                ErrorResponse(
                    errorCode = CONFLICT,
                    errorMessage = e.message
                )
            )
    }

    @ExceptionHandler
    fun carAlreadyExistsExceptionHandler(e: CarAlreadyExistsException): ResponseEntity<ErrorResponse> {
        errorLog(e)
        return ResponseEntity.status(HttpStatus.CONFLICT)
            .body(
                ErrorResponse(
                    errorCode = CONFLICT,
                    errorMessage = e.message
                )
            )
    }

    @ExceptionHandler
    fun defaultExceptionHandler(e: Exception): ResponseEntity<ErrorResponse> {
        errorLog(e)
        return ResponseEntity.internalServerError()
            .body(ErrorResponse(errorMessage = e.message))
    }

    private fun errorLog(e: Exception) {
        logger.error(e.message.orEmpty(), e)
    }
}
