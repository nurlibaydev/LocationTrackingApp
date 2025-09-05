package kaa.nurlibaydev.locationtrackingapp.di.koin

import kaa.nurlibaydev.locationtrackingapp.data.LocationRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val ApplicationModule = module {
    singleOf(::LocationRepositoryImpl)
}