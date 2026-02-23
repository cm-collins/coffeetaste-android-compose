package com.example.coffeetaste.feature.auth.presentation.sign_up

/**
 * Sign Up screen contract.
 *
 * **State:** Form fields (email, password, confirmPassword), loading flag, and optional error message. The Screen binds to these.
 *
 * **Event:** User actions (field changes, SignUpClicked, SignInClicked). The Screen sends these; ViewModel updates state or emits effects.
 *
 * **Effect:** One-shot navigation. NavigateToSignIn for "Go to Sign In"; NavigateToMain when sign-up succeeds. The host collects and navigates.
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
