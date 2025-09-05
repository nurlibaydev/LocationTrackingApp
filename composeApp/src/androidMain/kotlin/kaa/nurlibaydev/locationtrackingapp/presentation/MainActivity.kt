package kaa.nurlibaydev.locationtrackingapp.presentation

import android.R
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.mapbox.geojson.Point
import com.mapbox.maps.extension.compose.MapEffect
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.rememberMapViewportState
import com.mapbox.maps.plugin.PuckBearing
import com.mapbox.maps.plugin.locationcomponent.createDefault2DPuck
import com.mapbox.maps.plugin.locationcomponent.location
import com.mapbox.maps.plugin.viewport.ViewportStatus
import kaa.nurlibaydev.locationtrackingapp.presentation.utils.RequestLocationPermission
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
//            App()

            val viewModel: LocationViewModel = koinViewModel()

            val context = LocalContext.current
            val snackbarHostState = remember { SnackbarHostState() }
            val scope = rememberCoroutineScope()
            var permissionRequestCount by remember {
                mutableIntStateOf(1)
            }
            var showMap by remember {
                mutableStateOf(false)
            }
            var showRequestPermissionButton by remember {
                mutableStateOf(false)
            }
            val mapViewportState = rememberMapViewportState {
                setCameraOptions {
                    center(TASHKENT)
                    zoom(ZOOM)
                    pitch(PITCH)
                }
            }

            Scaffold(
                floatingActionButton = {
                    if (mapViewportState.mapViewportStatus == ViewportStatus.Idle) {
                        FloatingActionButton(
                            onClick = {
                                mapViewportState.transitionToFollowPuckState()
                            }
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_menu_mylocation),
                                contentDescription = "Locate button"
                            )
                        }
                    }
                },
                snackbarHost = {
                    SnackbarHost(snackbarHostState)
                }
            ) { contentPadding ->
                RequestLocationPermission(
                    requestCount = permissionRequestCount,
                    onPermissionDenied = {
                        scope.launch {
                            snackbarHostState.showSnackbar("You need to accept location permissions.")
                        }
                        showRequestPermissionButton = true
                    },
                    onPermissionReady = {
                        showRequestPermissionButton = false
                        showMap = true
                    }
                )
                if (showMap) {
                    MapboxMap(
                        Modifier.fillMaxSize().padding(contentPadding),
                        mapViewportState = mapViewportState,
                    ) {
                        MapEffect(Unit) { mapView ->
                            mapView.location.updateSettings {
                                locationPuck = createDefault2DPuck(withBearing = true)
                                puckBearingEnabled = true
                                puckBearing = PuckBearing.HEADING
                                enabled = true
                                pulsingEnabled = true
                            }
                            mapViewportState.transitionToFollowPuckState()

                            mapView.location.addOnIndicatorPositionChangedListener { point ->
                                val lat = point.latitude()
                                val lon = point.longitude()
                                //viewModel.dispatch(LocationIntent.UpdateLocation(lat, lon))
                            }
                        }
                    }
                }
                if (showRequestPermissionButton) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Column(modifier = Modifier.align(Alignment.Center)) {
                            Button(
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                onClick = {
                                    permissionRequestCount += 1
                                }
                            ) {
                                Text("Request permission again ($permissionRequestCount)")
                            }
                            Button(
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                onClick = {
                                    context.startActivity(
                                        Intent(
                                            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                            Uri.fromParts("package", packageName, null)
                                        )
                                    )
                                }
                            ) {
                                Text("Show App Settings page")
                            }
                        }
                    }
                }
            }
        }
    }

    private companion object {
        const val ZOOM: Double = 0.0
        const val PITCH: Double = 0.0
        val TASHKENT: Point = Point.fromLngLat(69.2401, 41.2995)
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}