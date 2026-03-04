package com.example.coffeetaste.feature.home.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffeetaste.core.designsystem.theme.CoffeeTasteTheme

/**
 * Home screen (View). Binds state to UI and sends events to ViewModel.
 */
@Composable
fun HomeScreen(
    state: HomeContract.State,
    onEvent: (HomeContract.Event) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Home",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(16.dp))
        if (state.isLoading) {
            CircularProgressIndicator()
        } else {
            if (state.message.isNotEmpty()) {
                Text(
                    text = state.message,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "Home - Light")
@Composable
fun HomeScreenPreviewLight() {
    CoffeeTasteTheme(darkTheme = false) {
        Surface {
            HomeScreen(
                state = HomeContract.State(message = "Welcome to Coffee Taste!"),
                onEvent = {}
            )
        }
    }
}

@Preview(showBackground = true, name = "Home - Dark")
@Composable
fun HomeScreenPreviewDark() {
    CoffeeTasteTheme(darkTheme = true) {
        Surface {
            HomeScreen(
                state = HomeContract.State(message = "Welcome to Coffee Taste!"),
                onEvent = {}
            )
        }
    }
}
