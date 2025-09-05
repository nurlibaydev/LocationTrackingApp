package kaa.nurlibaydev.locationtrackingapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kaa.nurlibaydev.locationtrackingapp.data.LocationRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LocationViewModel(
    private val repository: LocationRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(LocationState())
    val state: StateFlow<LocationState> = _state.asStateFlow()

    fun dispatch(intent: LocationIntent) {
        when (intent) {
            is LocationIntent.LoadHistory -> loadHistory()
            is LocationIntent.UpdateLocation -> updateLocation(intent.lat, intent.lon)
        }
    }

    private fun loadHistory() {
        viewModelScope.launch {
            val all = repository.getAllList()
        }
    }

    private fun updateLocation(lat: Double, lon: Double) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    lastLat = lat,
                    lastLon = lon
                )
            }
            repository.saveLocation(
                lat = lat,
                lon = lon
            )
            delay(3000)
        }
    }
}