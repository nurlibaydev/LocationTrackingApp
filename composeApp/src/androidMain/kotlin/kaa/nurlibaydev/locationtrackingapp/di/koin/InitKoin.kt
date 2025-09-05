package kaa.nurlibaydev.locationtrackingapp.di.koin

import android.app.Application
import kaa.nurlibaydev.locationtrackingapp.data.di.DatabaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext

fun Application.initKoin() {
    GlobalContext.startKoin {
        androidLogger()
        androidContext(this@initKoin)
        modules(
            PresentationModule,
            // ApplicationModule,
            DatabaseModule,
            repositoryModule
        )
    }
}