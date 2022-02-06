package com.tripmap.routes

import com.tripmap.usecase.trips.GetAllTrips
import com.tripmap.usecase.trips.GetTripByID
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.route
import java.util.UUID

fun Route.trips() {
    route("/trips") {
        get {
            GetAllTrips.handleRequest(request = null).let { useCaseResponse ->
                call.respond(useCaseResponse.responseCode, useCaseResponse.content)
            }
        }

        get("{id}") {
            GetTripByID.handleRequest(
                GetTripByID.Request(
                    id = UUID.fromString(call.parameters["id"])
                )
            ).let { useCaseResponse ->
                call.respond(useCaseResponse.responseCode, useCaseResponse.content)
            }
        }
    }
}