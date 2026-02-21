package com.example.coffeetaste.feature.splash.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.coffeetaste.feature.splash.presentation.splash.SplashContract
import com.example.coffeetaste.feature.splash.presentation.splash.SplashScreen
import com.example.coffeetaste.feature.splash.presentation.splash.SplashViewModel

/**
 * Host for the splash screen. Uses [SplashViewModel]; calls [onFinish] when effect is NavigateAway.
 */
@Composable
fun SplashHost(
    onFinish: () -> Unit
) {
    val viewModel: SplashViewModel = viewModel()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                SplashContract.Effect.NavigateAway -> onFinish()
            }
        }
    }

    SplashScreen(state = state)
}
