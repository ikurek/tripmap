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

object UpdateTrip : ApiUseCase<UpdateTrip.Request, TripResponseDTO> {

    override fun handleRequest(request: Request): ApiUseCaseResponse<TripResponseDTO> =
        TripRepository.getTripByID(request.id)?.let { existingTrip: Trip ->
            TripRepository.saveTrip(
                Trip(
                    uuid = request.id,
                    name = request.name,
                    locations = existingTrip.locations
                )
            ).let { updatedTrip: Trip ->
                ApiUseCaseResponse(
                    responseCode = HttpStatusCode.OK,
                    content = TripMapper.mapToDTO(updatedTrip)
                )
            }
        } ?: throw NotFoundException("Trip with ID ${request.id} doesn't exist")

    data class Request(
        val id: UUID,
        val name: String?
    ) : ApiUseCaseRequest
}