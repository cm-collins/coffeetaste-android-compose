package com.example.coffeetaste.core.designsystem.theme

import androidx.compose.runtime.staticCompositionLocalOf

/**
 * Source of truth for whether [CoffeeTasteTheme] is currently using a dark palette.
 *
 * Why this exists:
 * - Screens should not guess dark/light via `isSystemInDarkTheme()` because the app may allow
 *   forcing light/dark regardless of system settings.
 * - This local is provided by [CoffeeTasteTheme] and read via `CoffeeTasteTheme.isDark`.
 */
val LocalCoffeeTasteIsDark = staticCompositionLocalOf { false }

