package com.tripmap.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationResponseDTO(
    @SerialName("id")
    val uuid: String,
    @SerialName("name")
    val name: String?,
    @SerialName("latitude")
    val latitude: Float,
    @SerialName("longitude")
    val longitude: Float
)