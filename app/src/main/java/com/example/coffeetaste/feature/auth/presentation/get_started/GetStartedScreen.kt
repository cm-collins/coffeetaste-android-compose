package com.example.coffeetaste.feature.auth.presentation.get_started

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.coffeetaste.R
import com.example.coffeetaste.core.designsystem.components.GetStartedCtaButton
import com.example.coffeetaste.core.designsystem.theme.CoffeeTasteTheme

/**
 * Get Started screen (View). Displays state and sends events to ViewModel.
 * Uses design system colors for text on image (onImageContent) and CTA button (two-tone in light, single in dark).
 */
@Composable
fun GetStartedScreen(
    state: GetStartedContract.State,
    onEvent: (GetStartedContract.Event) -> Unit
) {
    val extra = CoffeeTasteTheme.extra
    val onImage = extra.onImageContent

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.get_started_bg),
            contentDescription = "Get started background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(extra.scrim)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(34.dp))
            Image(
                painter = painterResource(R.drawable.coffee_cup),
                contentDescription = "CoffeeTaste logo",
                modifier = Modifier.size(60.dp)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "COFFEE TASTE!",
                style = MaterialTheme.typography.titleLarge,
                color = onImage
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Find your favorite",
                style = MaterialTheme.typography.headlineMedium,
                color = onImage
            )
            Text(
                text = "Coffee Taste!",
                style = MaterialTheme.typography.headlineLarge,
                color = onImage
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "We're coffee shop, beer and wine bar,",
                style = MaterialTheme.typography.bodyMedium,
                color = onImage.copy(alpha = 0.92f)
            )
            Text(
                text = "& event space for performing arts",
                style = MaterialTheme.typography.bodyMedium,
                color = onImage.copy(alpha = 0.92f)
            )
            Spacer(modifier = Modifier.height(30.dp))
            GetStartedCtaButton(
                onClick = { onEvent(GetStartedContract.Event.SignUpClicked) },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
