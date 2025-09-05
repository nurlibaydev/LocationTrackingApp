package kaa.nurlibaydev.locationtrackingapp.presentation.utils

import android.os.Build
import kaa.nurlibaydev.locationtrackingapp.Platform

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

//actual fun getPlatform(): Platform = AndroidPlatform()