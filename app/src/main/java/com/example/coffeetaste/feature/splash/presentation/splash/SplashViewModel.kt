package com.example.coffeetaste.feature.splash.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

/**
 * Splash screen ViewModel.
 *
 * **State:** [_state] is the writable holder; [state] is exposed as read-only StateFlow so the
 * UI can collect it and recompose when it changes. asStateFlow() keeps the Screen from writing.
 *
 * **Effects:** [_effect] is a Channel for one-shot events (e.g. NavigateAway). BUFFERED means
 * values are buffered if the collector is slow. [effect] is the Flow the host collects in
 * LaunchedEffect; when it receives NavigateAway it calls onFinish() and the root navigates to Auth.
 *
 * **Init:** Launches a coroutine in viewModelScope (cancels when ViewModel is cleared). After
 * a short delay the splash is visible, then we send NavigateAway and set isLoading = false.
 */
class SplashViewModel : ViewModel() {

    private val _state = MutableStateFlow(SplashContract.State())
    val state: StateFlow<SplashContract.State> = _state.asStateFlow()

    private val _effect = Channel<SplashContract.Effect>(Channel.BUFFERED)
    val effect = _effect.receiveAsFlow()

    init {
        viewModelScope.launch {
            delay(1500)
            _effect.send(SplashContract.Effect.NavigateAway)
            _state.value = _state.value.copy(isLoading = false)
        }
    }
}
