package com.example.coffeetaste.core.designsystem.components.getstarted

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
 * Dark theme layout: Coffee beans image at top, content below.
 *
 * LEARN: Box for layering
 * - Box stacks children on top of each other (z-axis)
 * - Last child is on top (painter's algorithm)
 * - Use Alignment to position children within the Box
 */
@Composable
 fun GetStartedDarkContent(
    onEvent: (GetStartedContract.Event) -> Unit
) {
    val extra = CoffeeTasteTheme.extra

    // Dark theme: full-screen background image with content layered on top.
    // If the PNG has transparency, a dark `background` behind it can look like an overlay,
    // so we avoid drawing a background color beneath the image.
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.get_started_bg),
            contentDescription = "Coffee beans background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Push the header to the middle like the design.
            Spacer(modifier = Modifier.weight(1.1f))

            BrandHeader(titleColor = extra.heroTitle)

            Spacer(modifier = Modifier.height(30.dp))

            HeroTextContent(extra = extra)

            Spacer(modifier = Modifier.height(24.dp))

            GetStartedCtaButton(
                onClick = { onEvent(GetStartedContract.Event.SignUpClicked) },
                modifier = Modifier.fillMaxWidth()
            )

            // Bottom breathing room so CTA doesn't hug the nav bar.
            Spacer(modifier = Modifier.weight(0.7f))
        }
    }
}