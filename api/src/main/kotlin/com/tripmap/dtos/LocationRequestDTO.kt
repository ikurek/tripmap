package com.tripmap.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationRequestDTO(
    @SerialName("name")
    val name: String?,
    @SerialName("latitude")
    val latitude: Float,
    @SerialName("longitude")
    val longitude: Float
)