package com.example.coffeetaste.core.designsystem.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

// --- BRAND COLORS ---
// Core identity colors used consistently across light and dark themes
internal val CoffeeBrown = Color(0xFF55433C)       // Primary brand color (buttons, active states)
internal val CoffeeGold = Color(0xFFA97C37)        // Accent color (icons, highlights, stars)
internal val CoffeeBrownDark = Color(0xFF3D302B)   // Darker brown for dark theme buttons

// --- LIGHT MODE NEUTRALS ---
private val LightBackground = Color(0xFFFFFFFF)     // Pure white background (matches design)
private val LightSurface = Color(0xFFFFFFFF)        // White for cards/elevated items
private val LightSurfaceVariant = Color(0xFFF5F2F0) // Soft off-white for input fields
private val LightOnSurface = Color(0xFF1C1B1A)      // Primary text color (near black)
private val LightOnSurfaceVariant = Color(0xFF6B5D56) // Secondary text (muted brown-gray)
private val LightOutline = Color(0xFFD6CCC7)        // Borders and dividers

// --- DARK MODE NEUTRALS ---
private val DarkBackground = Color(0xFF0F0D0C)      // Near black, warm tone
private val DarkSurface = Color(0xFF1A1614)         // Elevated surfaces
private val DarkSurfaceVariant = Color(0xFF252019)  // Input fields in dark mode
private val DarkOnSurface = Color(0xFFF5F2F0)       // Primary text (off-white)
private val DarkOnSurfaceVariant = Color(0xFFB8AEA8) // Secondary text (muted)
private val DarkOutline = Color(0xFF3D3632)         // Borders for dark mode

/**
 * Material 3 Color Scheme for Light Mode.
 * White background with dark brown primary and gold accent.
 */
val CoffeeTasteLightColorScheme = lightColorScheme(
    primary = CoffeeBrown,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFE8DAD4),
    onPrimaryContainer = Color(0xFF241E1C),
    secondary = CoffeeGold,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFF5E6D3),
    onSecondaryContainer = Color(0xFF3D2E1E),
    background = LightBackground,
    onBackground = LightOnSurface,
    surface = LightSurface,
    onSurface = LightOnSurface,
    surfaceVariant = LightSurfaceVariant,
    onSurfaceVariant = LightOnSurfaceVariant,
    outline = LightOutline,
    outlineVariant = Color(0xFFE8E0DC)
)

/**
 * Material 3 Color Scheme for Dark Mode.
 * Dark warm background with adjusted browns and gold accent.
 */
val CoffeeTasteDarkColorScheme = darkColorScheme(
    primary = CoffeeBrownDark,
    onPrimary = Color.White,
    primaryContainer = Color(0xFF4A3B35),
    onPrimaryContainer = Color(0xFFE8DAD4),
    secondary = CoffeeGold,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFF4A3B2A),
    onSecondaryContainer = Color(0xFFF5E6D3),
    background = DarkBackground,
    onBackground = DarkOnSurface,
    surface = DarkSurface,
    onSurface = DarkOnSurface,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = DarkOnSurfaceVariant,
    outline = DarkOutline,
    outlineVariant = Color(0xFF2D2824)
)