package com.tripmap.repositories

import com.tripmap.database.entities.TripEntity
import com.tripmap.mappers.TripMapper
import com.tripmap.models.Trip
import org.jetbrains.exposed.sql.SizedCollection
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.UUID

object TripRepository {

    fun getTripByID(id: UUID): Trip? = transaction {
        TripEntity.findById(id)?.let { entity -> TripMapper.mapFromEntity(entity) }
    }

    fun getAllTrips(): List<Trip> = transaction {
        TripEntity.all().map { entity -> TripMapper.mapFromEntity(entity) }
    }

    // FIXME: Attach this
    fun saveTrip(trip: Trip): Trip = transaction {
        val entity = TripEntity.findById(trip.uuid)?.let { existingEntity ->
            updateTrip(existingEntity, trip)
        } ?: createTrip(trip)

        TripMapper.mapFromEntity(entity)
    }

    private fun updateTrip(tripEntity: TripEntity, trip: Trip): TripEntity = transaction {
        tripEntity.name = trip.name

        trip.locations.map { location ->
            LocationRepository.saveLocationAsEntity(location)
        }.let { locationEntities ->
            tripEntity.locations = SizedCollection(locationEntities)
        }

        return@transaction tripEntity
    }

    private fun createTrip(trip: Trip): TripEntity = transaction {
        TripEntity.new {
            name = trip.name

            trip.locations.map { location ->
                LocationRepository.saveLocationAsEntity(location)
            }.let { locationEntities ->
                locations = SizedCollection(locationEntities)
            }
        }
    }
}