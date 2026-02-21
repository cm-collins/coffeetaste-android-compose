package com.example.coffeetaste.feature.auth.presentation.get_started

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

/**
 * Get Started screen ViewModel: holds state and emits effects for navigation.
 */
class GetStartedViewModel : ViewModel() {

    private val _state = MutableStateFlow(GetStartedContract.State())
    val state: StateFlow<GetStartedContract.State> = _state.asStateFlow()

    private val _effect = Channel<GetStartedContract.Effect>(Channel.BUFFERED)
    val effect = _effect.receiveAsFlow()

    fun onEvent(event: GetStartedContract.Event) {
        when (event) {
            GetStartedContract.Event.SignInClicked -> viewModelScope.launch {
                _effect.send(GetStartedContract.Effect.NavigateToSignIn)
            }
            GetStartedContract.Event.SignUpClicked -> viewModelScope.launch {
                _effect.send(GetStartedContract.Effect.NavigateToSignUp)
            }
        }
    }
}
