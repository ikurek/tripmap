package com.tripmap.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponseDTO(
    @SerialName("type")
    val exceptionType: String,
    @SerialName("message")
    val message: String?
) {

    companion object {
        fun fromException(exception: Exception) = ErrorResponseDTO(
            exceptionType = exception.javaClass.simpleName,
            message = exception.cause?.message ?: exception.message
        )
    }
}
