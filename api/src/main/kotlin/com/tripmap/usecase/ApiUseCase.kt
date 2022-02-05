package com.tripmap.usecase

interface ApiUseCase<RequestType, ResponseType> {

    fun handleRequest(request: RequestType): ApiUseCaseResponse<ResponseType>
}