package com.tripmap.plugins.routing

import com.tripmap.dtos.ErrorResponseDTO
import com.tripmap.exceptions.AuthenticationException
import com.tripmap.exceptions.AuthorizationException
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.BadRequestException
import io.ktor.server.plugins.NotFoundException
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
            exception<NotFoundException> { call, cause ->
                call.respond(HttpStatusCode.NotFound, ErrorResponseDTO.fromException(cause))
            }
            exception<BadRequestException> { call, cause ->
                call.respond(HttpStatusCode.BadRequest, ErrorResponseDTO.fromException(cause))
            }
        }
    }
}