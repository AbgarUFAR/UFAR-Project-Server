package fr.proj.ufar.taxiserviceserver.integration

import fr.proj.ufar.taxiserviceserver.constant.rest.BASE_URL
import fr.proj.ufar.taxiserviceserver.dto.request.LoginRequest
import fr.proj.ufar.taxiserviceserver.dto.response.LoginResponse
import org.junit.jupiter.api.Test
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import kotlin.test.assertEquals

class AdminControllerItest : AbstractApiTest() {

    @Test
    internal fun shouldSignIn() {
        // Arrange
        val requestBody = LoginRequest(ADMIN_USERNAME, ADMIN_PASSWORD)
        val httpEntity = HttpEntity(requestBody)

        // Act
        val response = restTemplate.exchange(BASE_URL, HttpMethod.POST, httpEntity, LoginResponse::class.java)

        // Assert
        assertEquals(response.statusCode, HttpStatus.OK)
        assertEquals(response.body?.key, "key-1")
    }
}
