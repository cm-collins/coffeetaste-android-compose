package com.example.coffeetaste.feature.auth.presentation.get_started

/**
 * Get Started screen contract.
 *
 * **State:** UI state for the screen (e.g. loading). Minimal for this entry screen.
 *
 * **Event:** User actions (SignInClicked, SignUpClicked). The Screen sends these; ViewModel handles them.
 *
 * **Effect:** One-shot navigation. The host collects these and navigates to Sign In or Sign Up.
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
