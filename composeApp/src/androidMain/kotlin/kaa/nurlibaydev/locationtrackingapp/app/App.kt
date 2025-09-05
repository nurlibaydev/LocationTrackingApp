package kaa.nurlibaydev.locationtrackingapp.app

import android.app.Application
import kaa.nurlibaydev.locationtrackingapp.di.koin.initKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }
}