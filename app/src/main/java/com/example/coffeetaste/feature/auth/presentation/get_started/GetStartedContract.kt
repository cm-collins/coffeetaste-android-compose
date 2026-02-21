package com.example.coffeetaste.feature.auth.presentation.get_started

/**
 * Get Started screen contract: state, user events, and one-shot effects.
 */
object GetStartedContract {

    data class State(
        val isLoading: Boolean = false
    )

    sealed interface Event {
        data object SignInClicked : Event
        data object SignUpClicked : Event
    }

    sealed interface Effect {
        data object NavigateToSignIn : Effect
        data object NavigateToSignUp : Effect
    }
}
