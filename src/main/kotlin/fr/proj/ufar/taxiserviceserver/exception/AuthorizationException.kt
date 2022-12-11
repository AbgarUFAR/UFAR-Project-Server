package fr.proj.ufar.taxiserviceserver.exception

/**
 * Actually it is not a real authorization in the project because of some reasons
 * but there is done a tricky way to simulate it (there are no tokens and roles)
 */
class AuthorizationException : RuntimeException("Unauthorized")
