package fr.proj.ufar.taxiserviceserver.helper.jackson.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer

class LowercaseToStringEnumSerializer : StdSerializer<Enum<*>>(Enum::class.java) {

    override fun serialize(value: Enum<*>?, json: JsonGenerator, provider: SerializerProvider) {
        json.writeString(value?.toString()?.lowercase())
    }
}
