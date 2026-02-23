package com.example.coffeetaste.feature.splash.presentation.splash

/**
 * Splash screen contract: state and one-shot effects (no user events).
 */
object SplashContract {

    data class State(
        val isLoading: Boolean = true
    )

    sealed interface Effect {
        data object NavigateAway : Effect
    }
}
