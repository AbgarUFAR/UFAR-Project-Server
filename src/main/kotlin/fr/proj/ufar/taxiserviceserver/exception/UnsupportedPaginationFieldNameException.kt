package fr.proj.ufar.taxiserviceserver.exception

class UnsupportedPaginationFieldNameException(fieldName: String) :
        RuntimeException("Unsupported field name: \"$fieldName\" is not supported")