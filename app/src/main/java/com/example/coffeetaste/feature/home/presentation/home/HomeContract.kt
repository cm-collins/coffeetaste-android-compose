package com.example.coffeetaste.feature.home.presentation.home

/**
 * Home screen contract: state, user events, and one-shot effects.
 */
object HomeContract {

    data class State(
        val isLoading: Boolean = false,
        val message: String = ""
    )

    sealed interface Event {
        data object Refresh : Event
    }

    sealed interface Effect {
        data class ShowMessage(val text: String) : Effect
    }
}
