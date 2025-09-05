package kaa.nurlibaydev.locationtrackingapp.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "IOS screen",
                style = MaterialTheme.typography.headlineLarge
            )
        }
    }
}