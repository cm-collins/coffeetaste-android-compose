package com.example.coffeetaste.core.designsystem.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

/**
 * Defines the global shape scale for the CoffeeTaste design system.
 * These shapes determine the corner radius for all Material3 components.
 */
val CoffeeTasteShapes = Shapes(
    // Extra Small: Used for small components like Tooltips and Menu items
    extraSmall = RoundedCornerShape(8.dp),

    // Small: Used for components like Snackbars and smaller Buttons
    small = RoundedCornerShape(12.dp),

    // Medium: Used for Cards, Dialogs, and smaller Date/Time pickers
    medium = RoundedCornerShape(16.dp),

    // Large: Used for larger surfaces like Nav Drawers or detailed Cards
    large = RoundedCornerShape(24.dp),

    // Extra Large: Used for the largest containers like Modal Bottom Sheets
    extraLarge = RoundedCornerShape(28.dp)
)