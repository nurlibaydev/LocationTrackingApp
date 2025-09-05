package kaa.nurlibaydev.locationtrackingapp

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController {
    // App()

    Box(
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "IOS screen",
            style = MaterialTheme.typography.headlineLarge
        )
    }
}