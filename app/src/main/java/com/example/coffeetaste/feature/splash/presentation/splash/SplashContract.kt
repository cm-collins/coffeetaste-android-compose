package com.example.coffeetaste.feature.splash.presentation.splash

/**
 * Splash screen contract.
 *
 * **State:** UI state (e.g. isLoading). No user events; navigation is driven by a timer in the ViewModel.
 *
 * **Effect:** One-shot events. NavigateAway is collected by the host to trigger navigation to Auth.
 */
object SplashContract {

    data class State(
        val isLoading: Boolean = true
    )

    sealed interface Effect {
        data object NavigateAway : Effect
    }
}
