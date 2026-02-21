package com.example.coffeetaste.feature.home.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coffeetaste.core.navigation.Route
import com.example.coffeetaste.feature.home.presentation.home.HomeScreen
import com.example.coffeetaste.feature.home.presentation.home.HomeViewModel

/**
 * Main (post-auth) feature graph. Home screen uses ViewModel (state + events).
 */
@Composable
fun MainHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.HOME
    ) {
        composable(Route.HOME) {
            val viewModel: HomeViewModel = viewModel()
            val state by viewModel.state.collectAsState()
            HomeScreen(state = state, onEvent = viewModel::onEvent)
        }
        // TODO: Add Route.FAVORITES, Route.CART, Route.PROFILE when ready
    }
}
