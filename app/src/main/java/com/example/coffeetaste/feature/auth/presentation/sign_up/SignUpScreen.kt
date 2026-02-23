package com.example.coffeetaste.feature.auth.presentation.sign_up

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.coffeetaste.R
import com.example.coffeetaste.core.designsystem.components.BrandHeader
import com.example.coffeetaste.core.designsystem.theme.CoffeeTasteTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

/**
 * Sign Up screen.
 */
@Composable
fun SignUpScreen(
) {
    SignUpContent(
        isDarkTheme = CoffeeTasteTheme.isDark
    )
}

@Composable
private fun SignUpContent(
    isDarkTheme: Boolean
) {
    if (isDarkTheme) SignUpDarkContent() else SignUpLightContent()
}

@Composable
private fun SignUpDarkContent() {
    val extra = CoffeeTasteTheme.extra

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
            BrandHeader(titleColor = extra.heroTitle)
            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = stringResource(R.string.sign_up_title),
                style = MaterialTheme.typography.headlineLarge,
                color = extra.heroHeadline
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = stringResource(R.string.sign_up_subtitle),
                style = MaterialTheme.typography.bodyMedium,
                color = extra.heroSubtitle
            )
        }
    }
}

@Composable
private fun SignUpLightContent() {
    val extra = CoffeeTasteTheme.extra

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 24.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        BrandHeader(titleColor = extra.heroTitle)
        Spacer(modifier = Modifier.height(48.dp))

        Text(
            text = stringResource(R.string.sign_up_title),
            style = MaterialTheme.typography.headlineLarge,
            color = extra.heroHeadline
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = stringResource(R.string.sign_up_subtitle),
            style = MaterialTheme.typography.bodyMedium,
            color = extra.heroSubtitle
        )
    }
}
