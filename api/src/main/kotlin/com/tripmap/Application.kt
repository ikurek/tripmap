package com.tripmap

import com.tripmap.plugins.configureMonitoring
import com.tripmap.plugins.configureSerialization
import com.tripmap.plugins.database.configureDatabase
import com.tripmap.plugins.http.configureCors
import com.tripmap.plugins.http.configureHttpCompression
import com.tripmap.plugins.routing.configureRouting
import com.tripmap.plugins.routing.configureStatusPages
import com.tripmap.plugins.security.configureSecurity
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureDatabase()
        configureRouting()
        configureStatusPages()
        configureSerialization()
        configureMonitoring()
        configureCors()
        configureHttpCompression()
        configureSecurity()
    }.start(wait = true)
}
