package com.tripmap.usecase.trips

import com.tripmap.dtos.TripResponseDTO
import com.tripmap.mappers.TripMapper
import com.tripmap.repositories.TripRepository
import com.tripmap.usecase.ApiUseCase
import com.tripmap.usecase.ApiUseCaseResponse
import io.ktor.http.HttpStatusCode

object GetAllTrips : ApiUseCase<Nothing?, List<TripResponseDTO>> {
    override fun handleRequest(request: Nothing?): ApiUseCaseResponse<List<TripResponseDTO>> =
        TripRepository.getAllTrips()
            .map { trip -> TripMapper.mapToDTO(trip) }
            .let { tripResponseDTOs: List<TripResponseDTO> ->
                ApiUseCaseResponse(
                    responseCode = HttpStatusCode.OK,
                    content = tripResponseDTOs
                )
            }
}