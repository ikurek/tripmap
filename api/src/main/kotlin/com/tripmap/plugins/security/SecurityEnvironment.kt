package com.tripmap.plugins.security

data class SecurityEnvironment(
    val jwtAudience: String,
    val jwtRealm: String,
    val jwtSecret: String,
    val jwtIssuer: String
) {
    companion object {
        private const val JWT_AUDIENCE = "JWT_AUDIENCE"
        private const val JWT_REALM = "JWT_REALM"
        private const val JWT_SECRET = "JWT_SECRET"
        private const val JWT_ISSUER = "JWT_ISSUER"

        fun readEnvironment() = SecurityEnvironment(
            jwtAudience = System.getenv(JWT_AUDIENCE),
            jwtRealm = System.getenv(JWT_REALM),
            jwtSecret = System.getenv(JWT_SECRET),
            jwtIssuer = System.getenv(JWT_ISSUER)
        )
    }
}