package com.tripmap.usecase.locations

import com.tripmap.dtos.LocationResponseDTO
import com.tripmap.mappers.LocationMapper
import com.tripmap.models.Location
import com.tripmap.repositories.LocationRepository
import com.tripmap.usecase.ApiUseCase
import com.tripmap.usecase.ApiUseCaseRequest
import com.tripmap.usecase.ApiUseCaseResponse
import io.ktor.http.HttpStatusCode
import io.ktor.server.plugins.NotFoundException
import java.util.UUID

object GetLocationByID : ApiUseCase<GetLocationByID.Request, LocationResponseDTO> {

    @Throws(NotFoundException::class)
    override fun handleRequest(request: Request): ApiUseCaseResponse<LocationResponseDTO> =
        LocationRepository.getLocationByID(request.id)?.let { location: Location ->
            ApiUseCaseResponse(
                responseCode = HttpStatusCode.OK,
                content = LocationMapper.mapToDTO(location)
            )
        } ?: throw NotFoundException("Location with ID ${request.id} doesn't exist")

    data class Request(
        val id: UUID
    ) : ApiUseCaseRequest
}