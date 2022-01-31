package com.tripmap.plugins.security

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.JWTVerifier
import io.ktor.server.application.Application
import io.ktor.server.auth.Principal
import io.ktor.server.auth.authentication
import io.ktor.server.auth.jwt.JWTCredential
import io.ktor.server.auth.jwt.JWTPrincipal
import io.ktor.server.auth.jwt.jwt

fun Application.configureSecurity() {
    val environment: SecurityEnvironment = SecurityEnvironment.readEnvironment()

    authentication {
        jwt {
            realm = environment.jwtRealm
            verifier(jwtVerifier(environment))
            validate { credential -> jwtValidator(environment, credential) }
        }
    }
}

private fun jwtVerifier(environment: SecurityEnvironment): JWTVerifier = JWT
    .require(Algorithm.HMAC256(environment.jwtSecret))
    .withAudience(environment.jwtAudience)
    .withIssuer(environment.jwtIssuer)
    .build()

private fun jwtValidator(environment: SecurityEnvironment, credential: JWTCredential): Principal? =
    if (credential.payload.audience.contains(environment.jwtAudience)) JWTPrincipal(credential.payload) else null
