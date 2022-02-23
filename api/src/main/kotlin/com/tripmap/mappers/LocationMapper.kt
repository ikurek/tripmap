package com.tripmap.mappers

import com.tripmap.database.entities.LocationEntity
import com.tripmap.dtos.LocationResponseDTO
import com.tripmap.models.Location

object LocationMapper {

    fun mapFromEntity(locationEntity: LocationEntity) = Location(
        uuid = locationEntity.id.value,
        name = locationEntity.name,
        latitude = locationEntity.latitude,
        longitude = locationEntity.longitude
    )

    fun mapToDTO(locations: List<Location>) = locations.map { location ->
        mapToDTO(location)
    }

    fun mapToDTO(location: Location) = LocationResponseDTO(
        uuid = location.uuid.toString(),
        name = location.name,
        latitude = location.latitude.toFloat(),
        longitude = location.longitude.toFloat()
    )
}