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
    dynamicColor: Boolean = false, // keep false so your brand colors always show
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

    // Custom tokens to match your UI behavior:
    // - Light selected chip = brown
    // - Dark selected chip = gold
    val extraColors = if (darkTheme) {
        CoffeeTasteExtraColors(
            chipSelected = colorScheme.secondary,
            chipSelectedContent = colorScheme.onSecondary,
            chipUnselected = colorScheme.surfaceVariant,
            chipUnselectedContent = colorScheme.onSurfaceVariant,
            scrim = Color.Black.copy(alpha = 0.55f),
            glassSurface = Color.White.copy(alpha = 0.06f)
        )
    } else {
        CoffeeTasteExtraColors(
            chipSelected = colorScheme.primary,
            chipSelectedContent = colorScheme.onPrimary,
            chipUnselected = colorScheme.surfaceVariant,
            chipUnselectedContent = colorScheme.onSurfaceVariant,
            scrim = Color.Black.copy(alpha = 0.15f),
            glassSurface = Color.Black.copy(alpha = 0.03f)
        )
    }

    CompositionLocalProvider(LocalCoffeeTasteExtraColors provides extraColors) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = CoffeeTasteTypography,
            shapes = CoffeeTasteShapes,
            content = content
        )
    }
}