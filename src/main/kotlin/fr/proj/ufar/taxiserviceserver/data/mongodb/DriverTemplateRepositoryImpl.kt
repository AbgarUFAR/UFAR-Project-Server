package fr.proj.ufar.taxiserviceserver.data.mongodb

import fr.proj.ufar.taxiserviceserver.domain.Driver
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.support.PageableExecutionUtils
import org.springframework.stereotype.Repository
import org.springframework.data.domain.Sort

@Repository
class DriverTemplateRepositoryImpl(private val mongoTemplate: MongoTemplate) : DriverTemplateRepository {

    override fun findAllDriversByPage(paging: Pageable, sortFieldName: String): Page<Driver> {
        val query = Query().with(paging)
                .with(Sort.by(Sort.Direction.DESC, sortFieldName))
        return PageableExecutionUtils.getPage(
            mongoTemplate.find(query, Driver::class.java),
            paging
        ) { mongoTemplate.count(query.skip(0).limit(0), Driver::class.java) }
    }
}
