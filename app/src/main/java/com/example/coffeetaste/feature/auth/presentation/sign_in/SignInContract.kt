package com.example.coffeetaste.feature.auth.presentation.sign_in

/**
 * Sign In screen contract.
 *
 * **State:** Form fields (email, password), loading flag, and optional error message. The Screen binds to these.
 *
 * **Event:** User actions (field changes, SignInClicked, SignUpClicked). The Screen sends these; ViewModel updates state or emits effects.
 *
 * **Effect:** One-shot navigation. NavigateToSignUp for "Go to Sign Up"; NavigateToMain when sign-in succeeds. The host collects and navigates.
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
