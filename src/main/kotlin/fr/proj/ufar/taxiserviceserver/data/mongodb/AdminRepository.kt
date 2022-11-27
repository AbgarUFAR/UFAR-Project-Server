package fr.proj.ufar.taxiserviceserver.data.mongodb

import fr.proj.ufar.taxiserviceserver.domain.Admin
import org.springframework.data.mongodb.repository.MongoRepository

interface AdminRepository : MongoRepository<Admin, String> {

    fun findByUsername(username: String): Admin?
}
