package kaa.nurlibaydev.locationtrackingapp.data.di

import androidx.room.Room
import kaa.nurlibaydev.locationtrackingapp.database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val DatabaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

//    single {
//        val dbFile = androidContext().getDatabasePath("location.db")
//        Room.databaseBuilder<AppDatabase>(
//            context = androidContext(),
//            name = dbFile.absolutePath
//        )
//    }

    single { get<AppDatabase>().locationDao() }
}
