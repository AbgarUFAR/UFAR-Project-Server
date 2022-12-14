package fr.proj.ufar.taxiserviceserver.data.mongodb

import fr.proj.ufar.taxiserviceserver.domain.Driver
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface DriverTemplateRepository {

    fun findAllDriversByPage(paging: Pageable, sortFieldName: String): Page<Driver>
}
