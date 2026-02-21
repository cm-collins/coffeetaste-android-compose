package com.example.coffeetaste.feature.auth.presentation.sign_in

/**
 * Sign In screen contract: state, user events, and one-shot effects.
 */
object SignInContract {

    data class State(
        val email: String = "",
        val password: String = "",
        val isLoading: Boolean = false,
        val errorMessage: String? = null
    )

    sealed interface Event {
        data class EmailChanged(val value: String) : Event
        data class PasswordChanged(val value: String) : Event
        data object SignInClicked : Event
        data object SignUpClicked : Event
    }

    sealed interface Effect {
        data object NavigateToSignUp : Effect
        data object NavigateToMain : Effect
    }
}
