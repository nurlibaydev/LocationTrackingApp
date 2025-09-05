package kaa.nurlibaydev.locationtrackingapp.presentation

sealed class LocationIntent {
    object LoadHistory : LocationIntent()
    data class UpdateLocation(val lat: Double, val lon: Double) : LocationIntent()
}