package com.tripmap.plugins.routing

import com.tripmap.dto.ErrorResponseDTO
import com.tripmap.exceptions.AuthenticationException
import com.tripmap.exceptions.AuthorizationException
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.StatusPages
import io.ktor.server.response.respond
import io.ktor.server.routing.routing

fun Application.configureStatusPages() {

    routing {
        install(StatusPages) {
            exception<AuthenticationException> { call, cause ->
                call.respond(HttpStatusCode.Unauthorized, ErrorResponseDTO.fromException(cause))
            }
            exception<AuthorizationException> { call, cause ->
                call.respond(HttpStatusCode.Forbidden, ErrorResponseDTO.fromException(cause))
            }
            exception<Exception> { call, cause ->
                call.respond(HttpStatusCode.InternalServerError, ErrorResponseDTO.fromException(cause))
            }
        }
    }
}