package com.tripmap.plugins.routing

import com.tripmap.routes.locations.getAllLocations
import com.tripmap.routes.trips.getAllTrips
import io.ktor.server.application.Application
import io.ktor.server.routing.routing

fun Application.configureRouting() {
    routing {
        getAllTrips()
        getAllLocations()
    }
}
