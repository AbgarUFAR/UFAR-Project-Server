package fr.proj.ufar.taxiserviceserver.constant.enumeration

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import fr.proj.ufar.taxiserviceserver.helper.jackson.serializer.LowercaseToStringEnumSerializer

@JsonSerialize(using = LowercaseToStringEnumSerializer::class)
enum class ResponseStatus(private val value: String) {
    SUCCESS("success"),
    ERROR("error");

    override fun toString(): String = value
}
