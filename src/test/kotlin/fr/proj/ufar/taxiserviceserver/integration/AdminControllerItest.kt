package fr.proj.ufar.taxiserviceserver.integration

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class AdminControllerItest : StringSpec({
    "should be able to add 3 and 4" {
        val totaller = Totaller()
        totaller.add(1) shouldBe 3
    }
})

class Totaller {
    fun add(x: Int): Int {
        return x + 1
    }
}
