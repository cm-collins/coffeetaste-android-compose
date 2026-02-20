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
import com.example.coffeetaste.ui.CoffeTasteApp
import com.example.coffeetaste.ui.theme.CoffeetasteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 1) Enables edge-to-edge content (your UI can draw behind status/nav bars)

        enableEdgeToEdge()
        // 2) This is the "Compose world" entry point for your UI


        setContent {
            // 3) App theme wrapper (light/dark mode, typography, colors, shapes)
            CoffeetasteTheme {
                //surface gives your app a proper and consistent UI theme background
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                    // 5) Scaffold is the standard layout container:
                    //    it will later host top bar, bottom bar, snackbars, etc.
                    Scaffold(
                        modifier = Modifier.fillMaxSize()
                    ) { paddingValues ->
                        // 6) Your app root composable:
                        //    this is where NavigationHost + screens will live.

                        CoffeTasteApp(
                            paddingValues = paddingValues
                        )

                    }

                }
            }
        }
    }
}
