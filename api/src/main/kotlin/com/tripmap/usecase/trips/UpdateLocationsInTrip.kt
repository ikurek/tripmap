package com.tripmap.usecase.trips

import com.tripmap.dtos.LocationResponseDTO
import com.tripmap.mappers.LocationMapper
import com.tripmap.models.Trip
import com.tripmap.repositories.LocationRepository
import com.tripmap.repositories.TripRepository
import com.tripmap.usecase.ApiUseCase
import com.tripmap.usecase.ApiUseCaseRequest
import com.tripmap.usecase.ApiUseCaseResponse
import io.ktor.http.HttpStatusCode
import io.ktor.server.plugins.NotFoundException
import java.util.UUID

object UpdateLocationsInTrip : ApiUseCase<UpdateLocationsInTrip.Request, List<LocationResponseDTO>> {

    override fun handleRequest(request: Request): ApiUseCaseResponse<List<LocationResponseDTO>> =
        TripRepository.getTripByID(request.tripId)?.let { existingTrip: Trip ->
            request.locationIds.map { locationId ->
                LocationRepository.getLocationByID(locationId)
                    ?: throw NotFoundException("Location with ID $locationId doesn't exist")
            }.let { locations ->
                TripRepository.saveTrip(
                    existingTrip.copy(
                        locations = locations
                    )
                ).let { updatedTrip ->
                    ApiUseCaseResponse(
                        responseCode = HttpStatusCode.OK,
                        content = LocationMapper.mapToDTO(updatedTrip.locations)
                    )
                }
            }
        } ?: throw NotFoundException("Trip with ID ${request.tripId} doesn't exist")

    data class Request(
        val tripId: UUID,
        val locationIds: List<UUID>
    ) : ApiUseCaseRequest
}