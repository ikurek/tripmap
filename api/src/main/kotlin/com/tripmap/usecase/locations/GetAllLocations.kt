package com.tripmap.usecase.locations

import com.tripmap.dtos.LocationResponseDTO
import com.tripmap.mappers.LocationMapper
import com.tripmap.repositories.LocationRepository
import com.tripmap.usecase.ApiUseCase
import com.tripmap.usecase.ApiUseCaseResponse
import io.ktor.http.HttpStatusCode

object GetAllLocations : ApiUseCase<Nothing?, List<LocationResponseDTO>> {
    override fun handleRequest(request: Nothing?): ApiUseCaseResponse<List<LocationResponseDTO>> =
        LocationRepository.getAllLocations()
            .map { location -> LocationMapper.mapToDTO(location) }
            .let { locationResponseDTOList: List<LocationResponseDTO> ->
                ApiUseCaseResponse(
                    responseCode = HttpStatusCode.OK,
                    content = locationResponseDTOList
                )
            }
}