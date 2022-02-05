package com.tripmap.plugins.database

import com.tripmap.database.tables.Locations
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun configureDatabase() {
    val environment: DatabaseEnvironment = DatabaseEnvironment.readEnvironment()

    Database.connect(
        url = environment.url,
        driver = environment.driver,
        user = environment.username,
        password = environment.password
    )

    transaction {
        SchemaUtils.create(Locations)
    }
}