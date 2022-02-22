package com.tripmap.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TripRequestDTO(
    @SerialName("name")
    val name: String
)