package kaa.nurlibaydev.locationtrackingapp.data

import kaa.nurlibaydev.locationtrackingapp.database.model.LocationEntity
import kotlinx.coroutines.flow.Flow

interface LocationRepository {
    suspend fun saveLocation(lat: Double, lon: Double)
    fun getAllList(): Flow<List<LocationEntity>>
}