package fr.proj.ufar.taxiserviceserver.exception

class CarAlreadyExistsException(fieldName: String) :
    RuntimeException("Car with that $fieldName already exists")
