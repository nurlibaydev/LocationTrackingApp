package kaa.nurlibaydev.locationtrackingapp.di.koin

import kaa.nurlibaydev.locationtrackingapp.data.LocationRepository
import kaa.nurlibaydev.locationtrackingapp.data.LocationRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<LocationRepository> {
        LocationRepositoryImpl(get())
    }
}