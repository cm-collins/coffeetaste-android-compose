package com.example.coffeetaste.core.designsystem.components.getstarted

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/**
 * Hero text block: "Find your favorite", "Coffee Taste!", and subtitle.
 *
 * LEARN: CoffeeTasteExtraColors
 * - Custom color tokens beyond Material 3's built-in colors
 * - Accessed via CoffeeTasteTheme.extra (our custom theme object)
 * - Keeps color logic centralized in the design system
 */
@Composable
 fun HeroTextContent(
    extra: com.example.coffeetaste.core.designsystem.theme.CoffeeTasteExtraColors
) {
    Text(
        text = "Find your favorite",
        style = MaterialTheme.typography.headlineMedium,
        color = extra.heroHeadline,
        textAlign = TextAlign.Center
    )
    Text(
        text = "Coffee Taste!",
        // LEARN: Typography scale
        // - headlineLarge > headlineMedium > headlineSmall
        // - Use larger styles for emphasis, smaller for supporting text
        style = MaterialTheme.typography.headlineLarge,
        color = extra.heroAccent,
        textAlign = TextAlign.Center
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = "We're coffee shop, beer and wine bar,",
        style = MaterialTheme.typography.bodyMedium,
        color = extra.heroSubtitle,
        textAlign = TextAlign.Center
    )
    Text(
        text = "& event space for performing arts",
        style = MaterialTheme.typography.bodyMedium,
        color = extra.heroSubtitle,
        textAlign = TextAlign.Center
    )
}