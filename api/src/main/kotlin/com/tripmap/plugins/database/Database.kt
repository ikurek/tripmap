package com.tripmap.plugins.database

import org.jetbrains.exposed.sql.Database

fun configureDatabase() {
    val environment: DatabaseEnvironment = DatabaseEnvironment.readEnvironment()

    Database.connect(
        url = environment.url,
        driver = environment.driver,
        user = environment.username,
        password = environment.password
    )
}