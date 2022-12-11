package fr.proj.ufar.taxiserviceserver.constant.enumeration

enum class Gender(private val value: String) {
    MALE("male"),
    FEMALE("female");

    override fun toString(): String = value
}
