package kaa.nurlibaydev.locationtrackingapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import kaa.nurlibaydev.locationtrackingapp.database.dao.LocationDao
import kaa.nurlibaydev.locationtrackingapp.database.model.LocationEntity

@Database(
    entities = [LocationEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun locationDao(): LocationDao

    companion object {
        const val DATABASE_NAME = "LocationDB"
    }
}