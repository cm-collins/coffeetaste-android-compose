package com.example.coffeetaste.feature.auth.presentation.sign_in

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
 * Sign In screen ViewModel: holds state, handles events, emits effects.
 */
class SignInViewModel : ViewModel() {

    private val _state = MutableStateFlow(SignInContract.State())
    val state: StateFlow<SignInContract.State> = _state.asStateFlow()

    private val _effect = Channel<SignInContract.Effect>(Channel.BUFFERED)
    val effect = _effect.receiveAsFlow()

    fun onEvent(event: SignInContract.Event) {
        when (event) {
            is SignInContract.Event.EmailChanged -> _state.update {
                it.copy(email = event.value, errorMessage = null)
            }
            is SignInContract.Event.PasswordChanged -> _state.update {
                it.copy(password = event.value, errorMessage = null)
            }
            SignInContract.Event.SignInClicked -> viewModelScope.launch {
                _state.update { it.copy(isLoading = true, errorMessage = null) }
                // TODO: Call sign-in use case / repository, then:
                _effect.send(SignInContract.Effect.NavigateToMain)
                _state.update { it.copy(isLoading = false) }
            }
            SignInContract.Event.SignUpClicked -> viewModelScope.launch {
                _effect.send(SignInContract.Effect.NavigateToSignUp)
            }
        }
    }
}
