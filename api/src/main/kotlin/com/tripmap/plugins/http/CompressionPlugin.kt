package com.tripmap.plugins.http

import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.Compression
import io.ktor.server.plugins.deflate
import io.ktor.server.plugins.gzip
import io.ktor.server.plugins.minimumSize

fun Application.configureHttpCompression() = install(Compression) {
    gzip {
        priority = 1.0
    }
    deflate {
        priority = 10.0
        minimumSize(1024)
    }
}