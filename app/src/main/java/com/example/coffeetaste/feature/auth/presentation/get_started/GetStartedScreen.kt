package com.example.coffeetaste.feature.auth.presentation.get_started

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import com.example.coffeetaste.R
import androidx.compose.material3.Text
import com.example.coffeetaste.core.designsystem.components.BrandHeader
import com.example.coffeetaste.core.designsystem.components.CoffeeTasteCtaButton
import com.example.coffeetaste.core.designsystem.theme.CoffeeTasteTheme
import com.example.coffeetaste.core.designsystem.theme.CoffeeTasteExtraColors

/**
 * Get Started screen.
 *
 * This is intentionally a single screen implementation. We only branch on the parts that are
 * genuinely different between themes (background/illustration placement), to avoid duplicating
 * whole UI trees.
 */
@Composable
fun GetStartedScreen(
    state: GetStartedContract.State,
    onEvent: (GetStartedContract.Event) -> Unit
) {
    GetStartedContent(
        isDarkTheme = CoffeeTasteTheme.isDark,
        extra = CoffeeTasteTheme.extra,
        onGetStartedClick = { onEvent(GetStartedContract.Event.SignUpClicked) }
    )
}

@Composable
private fun GetStartedContent(
    isDarkTheme: Boolean,
    extra: CoffeeTasteExtraColors,
    onGetStartedClick: () -> Unit
) {
    if (isDarkTheme) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(R.drawable.get_started_bg),
                contentDescription = null,
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

                CoffeeTasteCtaButton(
                    text = stringResource(R.string.get_started_cta),
                    onClick = onGetStartedClick,
                    modifier = Modifier.fillMaxWidth()
                )

                // Bottom breathing room so CTA doesn't hug the nav bar.
                Spacer(modifier = Modifier.weight(0.7f))
            }
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp))
            BrandHeader(titleColor = extra.heroTitle)

            Spacer(modifier = Modifier.weight(0.3f))

            Image(
                painter = painterResource(R.drawable.get_started_bg),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.weight(0.3f))

            HeroTextContent(extra = extra)

            Spacer(modifier = Modifier.height(24.dp))

            CoffeeTasteCtaButton(
                text = stringResource(R.string.get_started_cta),
                onClick = onGetStartedClick,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(48.dp))
        }
    }
}

@Composable
private fun HeroTextContent(
    extra: CoffeeTasteExtraColors
) {
    Text(
        text = stringResource(R.string.get_started_headline),
        style = MaterialTheme.typography.headlineMedium,
        color = extra.heroHeadline,
        textAlign = TextAlign.Center
    )
    Text(
        text = stringResource(R.string.get_started_accent),
        style = MaterialTheme.typography.headlineLarge,
        color = extra.heroAccent,
        textAlign = TextAlign.Center
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = stringResource(R.string.get_started_subtitle_line_1),
        style = MaterialTheme.typography.bodyMedium,
        color = extra.heroSubtitle,
        textAlign = TextAlign.Center
    )
    Text(
        text = stringResource(R.string.get_started_subtitle_line_2),
        style = MaterialTheme.typography.bodyMedium,
        color = extra.heroSubtitle,
        textAlign = TextAlign.Center
    )
}
