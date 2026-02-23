package com.example.coffeetaste.core.designsystem.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

@Composable
fun CoffeeTasteTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> CoffeeTasteDarkColorScheme
        else -> CoffeeTasteLightColorScheme
    }

    val extraColors = if (darkTheme) {
        // Dark theme: light text on dark/image background, single-tone CTA button
        CoffeeTasteExtraColors(
            chipSelected = colorScheme.secondary,
            chipSelectedContent = colorScheme.onSecondary,
            chipUnselected = colorScheme.surfaceVariant,
            chipUnselectedContent = colorScheme.onSurfaceVariant,
            scrim = Color.Black.copy(alpha = 0.55f),
            glassSurface = Color.White.copy(alpha = 0.06f),
            heroTitle = Color.White,
            heroHeadline = Color.White,
            heroAccent = CoffeeGold,
            heroSubtitle = Color.White.copy(alpha = 0.85f),
            ctaButtonBackground = CoffeeBrownDark,
            ctaButtonIconSection = CoffeeBrownDark,
            onCtaButton = Color.White
        )
    } else {
        // Light theme: dark text on light background, two-tone CTA button
        CoffeeTasteExtraColors(
            chipSelected = colorScheme.primary,
            chipSelectedContent = colorScheme.onPrimary,
            chipUnselected = colorScheme.surfaceVariant,
            chipUnselectedContent = colorScheme.onSurfaceVariant,
            scrim = Color.Black.copy(alpha = 0.15f),
            glassSurface = Color.Black.copy(alpha = 0.03f),
            heroTitle = CoffeeBrown,
            heroHeadline = Color(0xFF1C1B1A),
            heroAccent = CoffeeGold,
            heroSubtitle = Color(0xFF6B5D56),
            ctaButtonBackground = CoffeeBrown,
            ctaButtonIconSection = CoffeeGold,
            onCtaButton = Color.White
        )
    }

    CompositionLocalProvider(
        LocalCoffeeTasteExtraColors provides extraColors,
        LocalCoffeeTasteIsDark provides darkTheme
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = CoffeeTasteTypography,
            shapes = CoffeeTasteShapes,
            content = content
        )
    }
}