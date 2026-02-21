package com.example.coffeetaste.core.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.MaterialTheme

/**
 * Custom color palette for CoffeeTaste that extends beyond the standard Material3 Scheme.
 *
 * @Immutable: Tells the Compose compiler these values won't change after creation,
 * allowing for better performance during recompositions.
 */
@Immutable
data class CoffeeTasteExtraColors(
    val chipSelected: Color,
    val chipSelectedContent: Color,
    val chipUnselected: Color,
    val chipUnselectedContent: Color,
    val scrim: Color,         // Used for dark overlays on images to make text readable
    val glassSurface: Color   // Used for translucent "frosted glass" effects on cards/fields
)

/**
 * CompositionLocal is a tool for passing data down through the UI tree implicitly.
 * This "key" allows us to access our custom colors anywhere in the app without
 * passing them as parameters to every single Composable function.
 */
val LocalCoffeeTasteExtraColors = staticCompositionLocalOf {
    // Default values are "Unspecified". These are used if you forget to
    // provide the actual colors in your Theme.kt file.
    CoffeeTasteExtraColors(
        chipSelected = Color.Unspecified,
        chipSelectedContent = Color.Unspecified,
        chipUnselected = Color.Unspecified,
        chipUnselectedContent = Color.Unspecified,
        scrim = Color.Unspecified,
        glassSurface = Color.Unspecified
    )
}

/**
 * A central entry point for the app's design system.
 * Use this object instead of 'MaterialTheme' to access both standard and custom colors.
 *
 * Usage: CoffeeTasteTheme.extra.scrim OR CoffeeTasteTheme.colors.primary
 */
object CoffeeTasteTheme {

    // Retrieves the custom colors provided by the nearest CompositionLocalProvider
    val extra: CoffeeTasteExtraColors
        @Composable get() = LocalCoffeeTasteExtraColors.current

    // Convenience property to access standard Material3 colors via our custom object
    val colors
        @Composable get() = MaterialTheme.colorScheme
}