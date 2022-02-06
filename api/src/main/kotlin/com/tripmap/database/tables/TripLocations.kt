package com.tripmap.database.tables

import org.jetbrains.exposed.sql.Table

object TripLocations : Table(name = "trip_to_location") {
    val trip = reference("trip", Trips)
    val location = reference("location", Locations)

    override val primaryKey = PrimaryKey(trip, location, name = "pk_trip_to_location")
}