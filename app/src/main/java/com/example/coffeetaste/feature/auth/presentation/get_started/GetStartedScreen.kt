package com.example.coffeetaste.feature.auth.presentation.get_started

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import com.example.coffeetaste.core.designsystem.components.getstarted.GetStartedDarkContent
import com.example.coffeetaste.core.designsystem.components.getstarted.GetStartedLightContent

/**
 * Get Started screen with different layouts for light and dark themes.
 *
 * LEARN: Conditional Composables
 * - We use `if/else` at the Composable level to render entirely different UI trees
 * - This is a valid pattern when layouts differ significantly between states
 * - For minor differences, prefer using Modifier conditionals instead
 */
@Composable
fun GetStartedScreen(
    state: GetStartedContract.State, onEvent: (GetStartedContract.Event) -> Unit
) {
    // LEARN: isSystemInDarkTheme()
    // - Returns true if device is in dark mode
    // - This is a Composable function, so it automatically recomposes when theme changes
    val isDarkTheme = isSystemInDarkTheme()

    if (isDarkTheme) {
        GetStartedDarkContent(onEvent = onEvent)
    } else {
        GetStartedLightContent(onEvent = onEvent)
    }
}
