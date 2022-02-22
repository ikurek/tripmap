package com.tripmap.routes

import com.tripmap.dtos.TripRequestDTO
import com.tripmap.usecase.trips.CreateTrip
import com.tripmap.usecase.trips.GetAllTrips
import com.tripmap.usecase.trips.GetTripByID
import com.tripmap.usecase.trips.UpdateTrip
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.put
import io.ktor.server.routing.route
import java.util.UUID

fun Route.trips() {
    route("/trips") {
        get {
            GetAllTrips.handleRequest(request = null).let { useCaseResponse ->
                call.respond(
                    status = useCaseResponse.responseCode,
                    message = useCaseResponse.content
                )
            }
        }

        post<TripRequestDTO> { tripRequestDTO ->
            CreateTrip.handleRequest(
                CreateTrip.Request(
                    name = tripRequestDTO.name
                )
            ).let { useCaseResponse ->
                call.respond(
                    status = useCaseResponse.responseCode,
                    message = useCaseResponse.content
                )
            }
        }

        put<TripRequestDTO>("{id}") { tripRequestDTO ->
            UpdateTrip.handleRequest(
                UpdateTrip.Request(
                    id = UUID.fromString(call.parameters["id"]),
                    name = tripRequestDTO.name
                )
            ).let { useCaseResponse ->
                call.respond(
                    status = useCaseResponse.responseCode,
                    message = useCaseResponse.content
                )
            }
        }

        get("{id}") {
            GetTripByID.handleRequest(
                GetTripByID.Request(
                    id = UUID.fromString(call.parameters["id"])
                )
            ).let { useCaseResponse ->
                call.respond(
                    status = useCaseResponse.responseCode,
                    message = useCaseResponse.content
                )
            }
        }
    }
}