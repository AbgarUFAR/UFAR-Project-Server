package fr.proj.ufar.taxiserviceserver.exception

class DriverAlreadyExistsException(fieldName: String) :
    RuntimeException("Driver with that $fieldName already exists")
