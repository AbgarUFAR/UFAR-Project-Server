package fr.proj.ufar.taxiserviceserver.integration

import fr.proj.ufar.taxiserviceserver.domain.Admin
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

const val ADMIN_ID = "randomId123"
const val ADMIN_USERNAME = "admin"
const val ADMIN_PASSWORD = "password"
const val ADMIN_ENCRYPTED_PASSWORD = "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8"
const val ADMIN_KEY = "key-1"

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract class AbstractApiTest {

    companion object {
        @Container
        var mongoDbContainer = MongoDBContainer("mongo:5.0.5")

        @DynamicPropertySource
        @JvmStatic
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.data.mongodb.uri", mongoDbContainer::getReplicaSetUrl)
        }
    }

    @Autowired
    protected lateinit var mongoTemplate: MongoTemplate

    @Autowired
    protected lateinit var restTemplate: TestRestTemplate

    @BeforeEach
    internal fun setup() {
        mongoTemplate.insert(
            Admin(
                id = ADMIN_ID,
                username = ADMIN_USERNAME,
                password = ADMIN_ENCRYPTED_PASSWORD,
                key = ADMIN_KEY
            )
        )
    }
}
