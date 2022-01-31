package com.tripmap

import com.tripmap.plugins.configureHTTP
import com.tripmap.plugins.configureMonitoring
import com.tripmap.plugins.configureRouting
import com.tripmap.plugins.configureSecurity
import com.tripmap.plugins.configureSerialization
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureSerialization()
        configureMonitoring()
        configureHTTP()
        configureSecurity()
    }.start(wait = true)
}
