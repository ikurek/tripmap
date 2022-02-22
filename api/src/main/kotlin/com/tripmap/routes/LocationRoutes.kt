package com.tripmap.routes

import com.tripmap.dtos.LocationRequestDTO
import com.tripmap.usecase.locations.CreateLocation
import com.tripmap.usecase.locations.GetAllLocations
import com.tripmap.usecase.locations.GetLocationByID
import com.tripmap.usecase.locations.UpdateLocation
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.put
import io.ktor.server.routing.route
import java.util.UUID

fun Route.locations() {
    route("/locations") {
        get {
            GetAllLocations.handleRequest(request = null).let { useCaseResponse ->
                call.respond(
                    status = useCaseResponse.responseCode,
                    message = useCaseResponse.content
                )
            }
        }

        post<LocationRequestDTO> { locationRequestDTO ->
            CreateLocation.handleRequest(
                CreateLocation.Request(
                    name = locationRequestDTO.name,
                    latitude = locationRequestDTO.latitude,
                    longitude = locationRequestDTO.longitude
                )
            ).let { useCaseResponse ->
                call.respond(
                    status = useCaseResponse.responseCode,
                    message = useCaseResponse.content
                )
            }
        }

        put<LocationRequestDTO>("{id}") { locationRequestDTO ->
            UpdateLocation.handleRequest(
                UpdateLocation.Request(
                    id = UUID.fromString(call.parameters["id"]),
                    name = locationRequestDTO.name,
                    latitude = locationRequestDTO.latitude,
                    longitude = locationRequestDTO.longitude
                )
            ).let { useCaseResponse ->
                call.respond(
                    status = useCaseResponse.responseCode,
                    message = useCaseResponse.content
                )
            }
        }

        get("{id}") {
            GetLocationByID.handleRequest(
                GetLocationByID.Request(
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