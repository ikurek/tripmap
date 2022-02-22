package com.tripmap.usecase.locations

import com.tripmap.dtos.LocationResponseDTO
import com.tripmap.mappers.LocationMapper
import com.tripmap.models.Location
import com.tripmap.repositories.LocationRepository
import com.tripmap.usecase.ApiUseCase
import com.tripmap.usecase.ApiUseCaseRequest
import com.tripmap.usecase.ApiUseCaseResponse
import io.ktor.http.HttpStatusCode
import java.util.UUID

object CreateLocation : ApiUseCase<CreateLocation.Request, LocationResponseDTO> {

    override fun handleRequest(request: Request): ApiUseCaseResponse<LocationResponseDTO> =
        LocationRepository.saveLocation(
            Location(
                uuid = UUID.randomUUID(),
                name = request.name,
                latitude = request.latitude.toBigDecimal(),
                longitude = request.longitude.toBigDecimal()
            )
        ).let { location: Location ->
            ApiUseCaseResponse(
                responseCode = HttpStatusCode.Created,
                content = LocationMapper.mapToDTO(location)
            )
        }

    data class Request(
        val name: String?,
        val latitude: Float,
        val longitude: Float
    ) : ApiUseCaseRequest
}