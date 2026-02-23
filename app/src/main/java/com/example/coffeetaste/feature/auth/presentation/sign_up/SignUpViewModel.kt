package com.example.coffeetaste.feature.auth.presentation.sign_up

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Sign Up screen ViewModel.
 *
 * **State:** [_state] is writable; [state] is read-only StateFlow. Holds email, password, confirmPassword, isLoading, errorMessage.
 *
 * **Effects:** [_effect] is a Channel for one-shot navigation. [effect] is collected by the host (NavigateToSignIn or NavigateToMain).
 *
 * **onEvent:** Field changes update state and clear error. SignUpClicked sets loading, then sends NavigateToMain (TODO: validate and call sign-up use case). SignInClicked sends NavigateToSignIn.
 */
class SignUpViewModel : ViewModel() {

    private val _state = MutableStateFlow(SignUpContract.State())
    val state: StateFlow<SignUpContract.State> = _state.asStateFlow()

    private val _effect = Channel<SignUpContract.Effect>(Channel.BUFFERED)
    val effect = _effect.receiveAsFlow()

    fun onEvent(event: SignUpContract.Event) {
        when (event) {
            is SignUpContract.Event.EmailChanged -> _state.update {
                it.copy(email = event.value, errorMessage = null)
            }
            is SignUpContract.Event.PasswordChanged -> _state.update {
                it.copy(password = event.value, errorMessage = null)
            }
            is SignUpContract.Event.ConfirmPasswordChanged -> _state.update {
                it.copy(confirmPassword = event.value, errorMessage = null)
            }
            SignUpContract.Event.SignUpClicked -> viewModelScope.launch {
                _state.update { it.copy(isLoading = true, errorMessage = null) }
                _effect.send(SignUpContract.Effect.NavigateToMain)
                _state.update { it.copy(isLoading = false) }
            }
            SignUpContract.Event.SignInClicked -> viewModelScope.launch {
                _effect.send(SignUpContract.Effect.NavigateToSignIn)
            }
        }
    }
}
