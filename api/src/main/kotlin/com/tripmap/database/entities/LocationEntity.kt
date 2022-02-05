package com.tripmap.database.entities

import com.tripmap.database.tables.Locations
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.math.BigDecimal
import java.util.UUID

class LocationEntity(id: EntityID<UUID>) : UUIDEntity(id = id) {
    companion object : UUIDEntityClass<LocationEntity>(Locations)

    var name: String? by Locations.name
    var latitude: BigDecimal by Locations.latitude
    var longitude: BigDecimal by Locations.longitude
}