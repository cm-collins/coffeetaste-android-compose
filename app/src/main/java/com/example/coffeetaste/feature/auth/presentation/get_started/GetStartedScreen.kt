package com.example.coffeetaste.feature.auth.presentation.get_started

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Get Started screen (View). Displays state and sends events to ViewModel.
 */
@Composable
fun GetStartedScreen(
    state: GetStartedContract.State,
    onEvent: (GetStartedContract.Event) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Get Started",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { onEvent(GetStartedContract.Event.SignInClicked) }
        ) {
            Text("Sign In")
        }
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = { onEvent(GetStartedContract.Event.SignUpClicked) }
        ) {
            Text("Sign Up")
        }
    }
}
