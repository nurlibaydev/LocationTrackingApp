package kaa.nurlibaydev.locationtrackingapp.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import kaa.nurlibaydev.locationtrackingapp.database.AppDatabase

fun getLocationDatabase(context: Context): RoomDatabase.Builder<AppDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath("location.db")
    return Room.databaseBuilder<AppDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}