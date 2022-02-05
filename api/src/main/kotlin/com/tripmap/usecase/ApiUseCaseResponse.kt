package com.tripmap.usecase

import io.ktor.http.HttpStatusCode

data class ApiUseCaseResponse<T>(
    val responseCode: HttpStatusCode,
    val content: T
)