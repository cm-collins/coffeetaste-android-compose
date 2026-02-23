package com.example.coffeetaste.core.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.MaterialTheme

/**
 * Extra colors for CoffeeTaste beyond Material 3.
 *
 * **Hero text colors (used on Get Started and similar screens):**
 * - `heroTitle`: Brand title color (e.g. "COFFEE TASTE!")
 * - `heroHeadline`: Main headline (e.g. "Find your favorite")
 * - `heroAccent`: Accent text like styled "Coffee Taste!" tagline
 * - `heroSubtitle`: Subtitle/description text
 *
 * **CTA button:**
 * - Light theme: two-tone (brown body + gold icon section)
 * - Dark theme: single-tone (same color for body and icon section)
 *
 * **Utility colors:**
 * - `scrim`: Overlay for modals/sheets
 * - `glassSurface`: Frosted glass effect surfaces
 */
@Immutable
data class CoffeeTasteExtraColors(
    val chipSelected: Color,
    val chipSelectedContent: Color,
    val chipUnselected: Color,
    val chipUnselectedContent: Color,
    val scrim: Color,
    val glassSurface: Color,
    val heroTitle: Color,
    val heroHeadline: Color,
    val heroAccent: Color,
    val heroSubtitle: Color,
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
        heroTitle = Color.Unspecified,
        heroHeadline = Color.Unspecified,
        heroAccent = Color.Unspecified,
        heroSubtitle = Color.Unspecified,
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
