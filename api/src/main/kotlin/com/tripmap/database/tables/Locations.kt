package com.tripmap.database.tables

import org.jetbrains.exposed.dao.id.UUIDTable

object Locations : UUIDTable(name = "locations", columnName = "uuid") {
    val name = text(name = "name").nullable()
    val latitude = decimal(name = "latitude", precision = 8, scale = 6)
    val longitude = decimal(name = "longitude", precision = 9, scale = 6)
}
