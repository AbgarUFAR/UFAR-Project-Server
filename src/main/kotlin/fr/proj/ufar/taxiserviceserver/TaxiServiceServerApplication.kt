package fr.proj.ufar.taxiserviceserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TaxiServiceServerApplication

fun main(args: Array<String>) {
    runApplication<TaxiServiceServerApplication>(*args)
}
