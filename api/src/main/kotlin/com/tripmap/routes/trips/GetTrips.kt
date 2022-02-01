package com.tripmap.routes.trips

import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.route

fun Route.getAllTrips() {
    route("/trips") {

        get {

        }
    }
}