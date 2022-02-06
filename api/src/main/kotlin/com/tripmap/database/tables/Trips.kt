package com.tripmap.database.tables

import org.jetbrains.exposed.dao.id.UUIDTable

object Trips : UUIDTable(name = "trips", columnName = "uuid") {
    val name = text(name = "name").nullable()
}
