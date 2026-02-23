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
 * Get Started screen ViewModel.
 *
 * **State:** [_state] is writable; [state] is read-only StateFlow for the UI. asStateFlow() keeps the Screen from writing.
 *
 * **Effects:** [_effect] is a Channel for one-shot navigation. [effect] is the Flow the host collects; it navigates to Sign In or Sign Up based on the effect.
 *
 * **onEvent:** SignInClicked / SignUpClicked send the corresponding effect. No async work; navigation is handled by the host.
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
