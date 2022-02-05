package com.tripmap.models

import java.math.BigDecimal
import java.util.UUID

data class Location(
    val uuid: UUID,
    val name: String?,
    val latitude: BigDecimal,
    val longitude: BigDecimal
)