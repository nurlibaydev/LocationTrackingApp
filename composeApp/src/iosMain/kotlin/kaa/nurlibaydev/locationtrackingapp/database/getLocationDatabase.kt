package kaa.nurlibaydev.locationtrackingapp.database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import platform.Foundation.NSHomeDirectory


//fun getLocationDatabase(): AppDatabase {
//    val dbFile = NSHomeDirectory() + "/location.db"
//    return Room.databaseBuilder<AppDatabase>(
//        name = dbFile,
//        factory = { AppDatabase::class.instantiateImpl() }
//    )
//        .setDriver(BundledSQLiteDriver())
//        .build()
//}