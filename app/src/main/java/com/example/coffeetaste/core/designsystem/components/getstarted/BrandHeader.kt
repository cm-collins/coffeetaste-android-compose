package com.example.coffeetaste.core.designsystem.components.getstarted

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeetaste.R


/**
 * Reusable brand header: Logo icon + "COFFEE TASTE!" title.
 *
 * LEARN: Extracting Composables
 * - Extract repeated UI into small, focused composables
 * - Pass only what varies as parameters (here: titleColor)
 * - Keeps code DRY and easier to maintain
 */
@Composable
 fun BrandHeader(
    titleColor: Color
) {
    Image(
        painter = painterResource(R.drawable.coffee_cup),
        contentDescription = "CoffeeTaste logo",
        modifier = Modifier.size(48.dp)
    )
    Spacer(modifier = Modifier.height(12.dp))
    Text(
        text = "COFFEE TASTE!",
        // LEARN: MaterialTheme.typography
        // - Provides consistent text styles defined in your theme
        // - Use semantic names (headlineMedium, bodyLarge) not raw TextStyles
        style = MaterialTheme.typography.labelLarge,
        color = titleColor,
        // LEARN: letterSpacing
        // - Adjusts space between characters
        // - Use sp units for scalable spacing
        letterSpacing = 3.sp
    )
}