package com.tripmap.usecase.trips

import com.tripmap.dtos.TripResponseDTO
import com.tripmap.mappers.TripMapper
import com.tripmap.models.Trip
import com.tripmap.repositories.TripRepository
import com.tripmap.usecase.ApiUseCase
import com.tripmap.usecase.ApiUseCaseRequest
import com.tripmap.usecase.ApiUseCaseResponse
import io.ktor.http.HttpStatusCode
import io.ktor.server.plugins.NotFoundException
import java.util.UUID

object GetTripByID : ApiUseCase<GetTripByID.Request, TripResponseDTO> {

    @Throws(NotFoundException::class)
    override fun handleRequest(request: Request): ApiUseCaseResponse<TripResponseDTO> =
        TripRepository.getTripByID(request.id)?.let { trip: Trip ->
            ApiUseCaseResponse(
                responseCode = HttpStatusCode.OK,
                content = TripMapper.mapToDTO(trip)
            )
        } ?: throw NotFoundException("Trip with ID ${request.id} doesn't exist")

    data class Request(
        val id: UUID
    ) : ApiUseCaseRequest
}