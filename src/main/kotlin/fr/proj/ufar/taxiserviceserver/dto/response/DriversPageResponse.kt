package fr.proj.ufar.taxiserviceserver.dto.response

import fr.proj.ufar.taxiserviceserver.dto.DriverDto

data class DriversPageResponse(
    val drivers: List<DriverDto>,
    val isFirst: Boolean,
    val isLast: Boolean
)
