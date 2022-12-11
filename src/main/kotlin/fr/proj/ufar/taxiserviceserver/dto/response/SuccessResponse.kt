package fr.proj.ufar.taxiserviceserver.dto.response

import fr.proj.ufar.taxiserviceserver.constant.enumeration.ResponseStatus
import fr.proj.ufar.taxiserviceserver.constant.enumeration.ResponseStatus.SUCCESS

class SuccessResponse(
    val status: ResponseStatus = SUCCESS
)
