package com.tripmap.mappers

import com.tripmap.database.entities.TripEntity
import com.tripmap.dtos.TripResponseDTO
import com.tripmap.models.Trip

object TripMapper {

    fun mapFromEntity(tripEntity: TripEntity) = Trip(
        uuid = tripEntity.id.value,
        name = tripEntity.name,
        locations = tripEntity.locations.map { locationEntity ->
            LocationMapper.mapFromEntity(locationEntity)
        }
    )

    fun mapToDTO(trip: Trip) = TripResponseDTO(
        uuid = trip.uuid.toString(),
        name = trip.name,
        locations = trip.locations.map { location ->
            LocationMapper.mapToDTO(location)
        }
    )
}