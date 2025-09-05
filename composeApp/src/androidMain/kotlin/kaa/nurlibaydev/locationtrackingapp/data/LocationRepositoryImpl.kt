package kaa.nurlibaydev.locationtrackingapp.data

import kaa.nurlibaydev.locationtrackingapp.data.LocationRepository
import kaa.nurlibaydev.locationtrackingapp.database.dao.LocationDao
import kaa.nurlibaydev.locationtrackingapp.database.model.LocationEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

class LocationRepositoryImpl(
    private val dao: LocationDao,
): LocationRepository {

    override suspend fun saveLocation(lat: Double, lon: Double) {
        val entity = LocationEntity(
            latitude = lat,
            longitude = lon,
            timestamp = System.currentTimeMillis()
        )
        dao.insertCache(entity)
    }

    override fun getAllList(): Flow<List<LocationEntity>> {
        return dao.getAllList()
            .catch { emit(emptyList()) }
            .flowOn(Dispatchers.IO)
    }
}