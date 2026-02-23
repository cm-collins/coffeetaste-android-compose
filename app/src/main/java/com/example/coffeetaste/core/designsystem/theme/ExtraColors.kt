package com.example.coffeetaste.core.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.MaterialTheme

/**
 * Extra colors for CoffeeTaste beyond Material 3.
 *
 * **onImageContent:** Text/icon color on full-bleed hero images (e.g. Get Started). White in dark theme, dark in light for contrast.
 *
 * **ctaButtonBackground / ctaButtonIconSection / onCtaButton:** Primary CTA (e.g. Get Started). Dark theme: single block (icon section = background). Light theme: two-tone (icon section = gold).
 */
@Immutable
data class CoffeeTasteExtraColors(
    val chipSelected: Color,
    val chipSelectedContent: Color,
    val chipUnselected: Color,
    val chipUnselectedContent: Color,
    val scrim: Color,
    val glassSurface: Color,
    val onImageContent: Color,
    val ctaButtonBackground: Color,
    val ctaButtonIconSection: Color,
    val onCtaButton: Color
)

val LocalCoffeeTasteExtraColors = staticCompositionLocalOf {
    CoffeeTasteExtraColors(
        chipSelected = Color.Unspecified,
        chipSelectedContent = Color.Unspecified,
        chipUnselected = Color.Unspecified,
        chipUnselectedContent = Color.Unspecified,
        scrim = Color.Unspecified,
        glassSurface = Color.Unspecified,
        onImageContent = Color.Unspecified,
        ctaButtonBackground = Color.Unspecified,
        ctaButtonIconSection = Color.Unspecified,
        onCtaButton = Color.Unspecified
    )
}

object CoffeeTasteTheme {
    val extra: CoffeeTasteExtraColors
        @Composable get() = LocalCoffeeTasteExtraColors.current
    val colors
        @Composable get() = MaterialTheme.colorScheme
}
