package com.example.coffeetaste.core.designsystem.components.getstarted

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.coffeetaste.R
import com.example.coffeetaste.core.designsystem.theme.CoffeeTasteTheme
import com.example.coffeetaste.feature.auth.presentation.get_started.GetStartedContract

/**
 * Light theme layout: Logo at top, illustration in middle, text + button at bottom.
 *
 * LEARN: Modifier.weight()
 * - Only works inside Row or Column scope
 * - Distributes remaining space proportionally after fixed-size items are measured
 * - weight(1f) means "take all remaining space" when it's the only weighted item
 */
@Composable
 fun GetStartedLightContent(
    onEvent: (GetStartedContract.Event) -> Unit
) {
    val extra = CoffeeTasteTheme.extra

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 24.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top section: Logo + Brand title
        Spacer(modifier = Modifier.height(60.dp))
        BrandHeader(titleColor = extra.heroTitle)

        // LEARN: Spacer with weight
        // - This pushes content above and below apart
        // - The illustration is centered in the remaining vertical space
        Spacer(modifier = Modifier.weight(0.3f))

        // Middle section: Decorative illustration
        // LEARN: painterResource
        // - Loads drawable resources at runtime
        // - Returns a Painter object that Image composable can render
        Image(
            painter = painterResource(R.drawable.get_started_bg),
            contentDescription = "Coffee illustration",
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), // Takes remaining space proportionally
            contentScale = ContentScale.Fit // LEARN: Fit = scale to fit without cropping
        )

        Spacer(modifier = Modifier.weight(0.3f))

        // Bottom section: Headlines + CTA
        HeroTextContent(extra = extra)

        Spacer(modifier = Modifier.height(24.dp))

        GetStartedCtaButton(
            onClick = { onEvent(GetStartedContract.Event.SignUpClicked) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(48.dp))
    }
}