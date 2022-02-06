package com.tripmap.plugins.routing

import com.tripmap.routes.locations
import com.tripmap.routes.trips
import io.ktor.server.application.Application
import io.ktor.server.routing.routing

fun Application.configureRouting() = routing {
    trips()
    locations()
}
