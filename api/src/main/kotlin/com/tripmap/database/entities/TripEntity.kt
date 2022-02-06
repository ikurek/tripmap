package com.tripmap.database.entities

import com.tripmap.database.tables.TripLocations
import com.tripmap.database.tables.Trips
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.SizedIterable
import java.util.UUID

class TripEntity(id: EntityID<UUID>) : UUIDEntity(id = id) {
    companion object : UUIDEntityClass<TripEntity>(Trips)

    var name: String? by Trips.name
    var locations: SizedIterable<LocationEntity> by LocationEntity via TripLocations
}