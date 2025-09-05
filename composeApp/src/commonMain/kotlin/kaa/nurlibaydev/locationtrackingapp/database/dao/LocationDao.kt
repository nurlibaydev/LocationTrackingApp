package kaa.nurlibaydev.locationtrackingapp.database.dao

import androidx.room.Dao
import androidx.room.Query
import kaa.nurlibaydev.locationtrackingapp.database.model.LocationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationDao:  BaseDao<LocationEntity> {

    @Query("SELECT * FROM locations ORDER BY timestamp DESC")
    fun getAllList(): Flow<List<LocationEntity>>

    @Query("DELETE FROM locations")
    suspend fun clear()
}