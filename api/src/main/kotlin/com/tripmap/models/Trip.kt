package com.tripmap.models

import java.util.UUID

data class Trip(
    val uuid: UUID,
    val name: String?,
    val locations: List<Location>
)