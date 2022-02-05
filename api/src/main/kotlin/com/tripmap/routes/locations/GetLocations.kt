package com.tripmap.routes.locations

import com.tripmap.usecase.locations.GetAllLocations
import com.tripmap.usecase.locations.GetLocationByID
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.route
import java.util.UUID

fun Route.getAllLocations() {
    route("/locations") {
        get {
            GetAllLocations.handleRequest(request = null).let { useCaseResponse ->
                call.respond(useCaseResponse.responseCode, useCaseResponse.content)
            }
        }

        get("{id}") {
            GetLocationByID.handleRequest(
                GetLocationByID.Request(
                    id = UUID.fromString(call.parameters["id"])
                )
            ).let { useCaseResponse ->
                call.respond(useCaseResponse.responseCode, useCaseResponse.content)
            }
        }

    }
}