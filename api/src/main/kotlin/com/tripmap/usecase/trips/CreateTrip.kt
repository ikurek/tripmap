package com.tripmap.usecase.trips

import com.tripmap.dtos.TripResponseDTO
import com.tripmap.mappers.TripMapper
import com.tripmap.models.Trip
import com.tripmap.repositories.TripRepository
import com.tripmap.usecase.ApiUseCase
import com.tripmap.usecase.ApiUseCaseRequest
import com.tripmap.usecase.ApiUseCaseResponse
import io.ktor.http.HttpStatusCode
import java.util.UUID

object CreateTrip : ApiUseCase<CreateTrip.Request, TripResponseDTO> {

    override fun handleRequest(request: Request): ApiUseCaseResponse<TripResponseDTO> =
        TripRepository.saveTrip(
            Trip(
                uuid = UUID.randomUUID(),
                name = request.name,
                locations = emptyList()
            )
        ).let { trip: Trip ->
            ApiUseCaseResponse(
                responseCode = HttpStatusCode.Created,
                content = TripMapper.mapToDTO(trip)
            )
        }

    data class Request(
        val name: String?
    ) : ApiUseCaseRequest
}