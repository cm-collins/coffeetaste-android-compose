package com.example.coffeetaste

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.coffeetaste.core.designsystem.theme.CoffeeTasteTheme

/**
 * Main Activity. Entry point for the Coffee Taste app.
 * Uses edge-to-edge, Material 3 theme, and Compose for UI.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge so UI can draw behind status and navigation bars.
        enableEdgeToEdge()

        setContent {
            CoffeeTasteTheme {
                // Surface provides a consistent theme background.
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Scaffold hosts top bar, bottom bar, snackbars, and content.
                    Scaffold(
                        modifier = Modifier.fillMaxSize()
                    ) { paddingValues ->
                        // Root composable: NavHost and screen graphs go here.
                        CoffeeTasteApp(
                            paddingValues = paddingValues
                        )
                    }
                }
            }
        }
    }
}


