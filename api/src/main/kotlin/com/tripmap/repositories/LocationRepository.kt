package com.tripmap.repositories

import com.tripmap.database.entities.LocationEntity
import com.tripmap.mappers.LocationMapper
import com.tripmap.models.Location
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.UUID

object LocationRepository {

    fun getLocationByID(id: UUID): Location? = transaction {
        LocationEntity.findById(id)?.let { entity -> LocationMapper.mapFromEntity(entity) }
    }

    fun getAllLocations(): List<Location> = transaction {
        LocationEntity.all().map { entity -> LocationMapper.mapFromEntity(entity) }
    }

    fun saveLocation(location: Location): Location = transaction {
        val entity = LocationEntity.findById(location.uuid)?.let { existingEntity ->
            updateLocation(existingEntity, location)
        } ?: createLocation(location)

        LocationMapper.mapFromEntity(entity)
    }

    fun saveLocationAsEntity(location: Location): LocationEntity = transaction {
        LocationEntity.findById(location.uuid)?.let { existingEntity ->
            updateLocation(existingEntity, location)
        } ?: createLocation(location)
    }

    private fun updateLocation(locationEntity: LocationEntity, location: Location): LocationEntity = transaction {
        locationEntity.name = location.name
        locationEntity.latitude = location.latitude
        locationEntity.longitude = location.longitude
        return@transaction locationEntity
    }

    private fun createLocation(location: Location): LocationEntity = transaction {
        LocationEntity.new {
            name = location.name
            latitude = location.latitude
            longitude = location.longitude
        }
    }
}