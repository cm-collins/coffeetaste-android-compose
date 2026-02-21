package com.example.coffeetaste.core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Helper: apply Gilroy to any TextStyle (and optionally override weight)
private fun TextStyle.withGilroy(weight: FontWeight? = null): TextStyle =
    copy(
        fontFamily = Gilroy,
        fontWeight = weight ?: this.fontWeight
    )

private val baseline = Typography()

val CoffeeTasteTypography = Typography(
    // Make sure ALL text styles use Gilroy (no surprises in the UI)
    displayLarge = baseline.displayLarge.withGilroy(),
    displayMedium = baseline.displayMedium.withGilroy(),
    displaySmall = baseline.displaySmall.withGilroy(),

    headlineLarge = baseline.headlineLarge.withGilroy(FontWeight.ExtraBold).copy(
        fontSize = 34.sp,
        lineHeight = 40.sp
    ),
    headlineMedium = baseline.headlineMedium.withGilroy(),
    headlineSmall = baseline.headlineSmall.withGilroy(),

    titleLarge = baseline.titleLarge.withGilroy(FontWeight.Bold).copy(
        fontSize = 22.sp,
        lineHeight = 28.sp
    ),
    titleMedium = baseline.titleMedium.withGilroy(),
    titleSmall = baseline.titleSmall.withGilroy(),

    bodyLarge = baseline.bodyLarge.withGilroy().copy(
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    bodyMedium = baseline.bodyMedium.withGilroy().copy(
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    bodySmall = baseline.bodySmall.withGilroy(),

    labelLarge = baseline.labelLarge.withGilroy(FontWeight.SemiBold).copy(
        fontSize = 16.sp,
        lineHeight = 20.sp
    ),
    labelMedium = baseline.labelMedium.withGilroy(),
    labelSmall = baseline.labelSmall.withGilroy(),
)