package fr.proj.ufar.taxiserviceserver.dto.response

import com.fasterxml.jackson.annotation.JsonProperty
import fr.proj.ufar.taxiserviceserver.constant.enumeration.ResponseStatus
import fr.proj.ufar.taxiserviceserver.constant.enumeration.ResponseStatus.ERROR

private const val UNKNOWN_ERROR_CODE = "unknown_error"

open class ErrorResponse(
    val status: ResponseStatus = ERROR,
    @JsonProperty("error_code")
    val errorCode: String = UNKNOWN_ERROR_CODE,
    @JsonProperty("error_message")
    val errorMessage: String? = null
)
