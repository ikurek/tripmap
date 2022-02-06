package com.tripmap.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TripResponseDTO(
    @SerialName("id")
    val uuid: String,
    @SerialName("name")
    val name: String?,
    @SerialName("locations")
    val locations: List<LocationResponseDTO>
)