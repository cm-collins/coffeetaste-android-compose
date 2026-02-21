package com.example.coffeetaste

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Root Compose UI. Add NavHost and navigation graphs (e.g. AuthGraph, MainGraph) here.
 * Content is inset by [paddingValues] from Scaffold (status bar, nav bar, app bars).
 */
@Composable
fun CoffeeTasteApp(
    paddingValues: PaddingValues
) {
    Box(modifier = Modifier.padding(paddingValues)) {
        // TODO: Add NavHost + AuthGraph + MainGraph
    }
}
