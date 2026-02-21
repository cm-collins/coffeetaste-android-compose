package com.example.coffeetaste.core.designsystem.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

// --- BRAND COLORS ---
// These are the core identity colors of your app
private val CoffeeBrown = Color(0xFF55433C)   // Main brand color (Buttons, active states)
private val CoffeeGold = Color(0xFFA97C37)    // Accent color (Icons, highlights, stars)

// --- LIGHT MODE NEUTRALS ---
private val LightBackground = Color(0xFFF7F5F4) // Soft off-white background
private val LightSurface = Color(0xFFFFFFFF)    // Pure white for cards/elevated items
private val LightSurfaceVariant = Color(0xFFF0ECEA) // Slightly darker gray-brown for input fields
private val LightOnSurface = Color(0xFF1C1B1A)      // Main text color
private val LightOnSurfaceVariant = Color(0xFF4A3F3A) // Subtle text (labels, hints)
private val LightOutline = Color(0xFFD6CCC7)        // Borders and dividers

// --- DARK MODE NEUTRALS ---
private val DarkBackground = Color(0xFF0F0D0C)  // Near black, warm tone
private val DarkSurface = Color(0xFF151211)     // Card background in dark mode
private val DarkSurfaceVariant = Color(0xFF201B19) // Input fields in dark mode
private val DarkOnSurface = Color(0xFFF2EDEA)      // Light text for dark mode
private val DarkOnSurfaceVariant = Color(0xFFC8BEB9) // Muted text for dark mode
private val DarkOutline = Color(0xFF3A332F)         // Borders for dark mode

/**
 * Material 3 Color Scheme for Light Mode
 */
val CoffeeTasteLightColorScheme = lightColorScheme(
    primary = CoffeeBrown,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFE8DAD4),
    onPrimaryContainer = Color(0xFF241E1C),
    secondary = CoffeeGold,
    onSecondary = Color.White,
    background = LightBackground,
    onBackground = LightOnSurface,
    surface = LightSurface,
    onSurface = LightOnSurface,
    surfaceVariant = LightSurfaceVariant,
    onSurfaceVariant = LightOnSurfaceVariant,
    outline = LightOutline
)

/**
 * Material 3 Color Scheme for Dark Mode
 */
val CoffeeTasteDarkColorScheme = darkColorScheme(
    primary = Color(0xFF7A645C), // Slightly lighter brown for better contrast on dark
    onPrimary = Color.White,
    primaryContainer = Color(0xFF5C4A43),
    onPrimaryContainer = Color(0xFFE8DAD4),
    secondary = CoffeeGold,
    onSecondary = Color.White,
    background = DarkBackground,
    onBackground = DarkOnSurface,
    surface = DarkSurface,
    onSurface = DarkOnSurface,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = DarkOnSurfaceVariant,
    outline = DarkOutline
)