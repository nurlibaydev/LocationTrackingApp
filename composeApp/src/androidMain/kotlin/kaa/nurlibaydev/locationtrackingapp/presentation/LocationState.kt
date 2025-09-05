package kaa.nurlibaydev.locationtrackingapp.presentation

import kaa.nurlibaydev.locationtrackingapp.database.model.LocationEntity

data class LocationState(
    val isTracking: Boolean = false,
    val lastLat: Double? = null,
    val lastLon: Double? = null,
    val history: List<LocationEntity> = emptyList()
)