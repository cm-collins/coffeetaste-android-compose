package com.example.coffeetaste.feature.auth.presentation.sign_up

/**
 * Sign Up screen contract: state, user events, and one-shot effects.
 */
object SignUpContract {

    data class State(
        val email: String = "",
        val password: String = "",
        val confirmPassword: String = "",
        val isLoading: Boolean = false,
        val errorMessage: String? = null
    )

    sealed interface Event {
        data class EmailChanged(val value: String) : Event
        data class PasswordChanged(val value: String) : Event
        data class ConfirmPasswordChanged(val value: String) : Event
        data object SignUpClicked : Event
        data object SignInClicked : Event
    }

    sealed interface Effect {
        data object NavigateToSignIn : Effect
        data object NavigateToMain : Effect
    }
}
