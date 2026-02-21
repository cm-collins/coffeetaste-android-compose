package com.example.coffeetaste.feature.auth.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coffeetaste.core.navigation.Route
import com.example.coffeetaste.feature.auth.presentation.get_started.GetStartedContract
import com.example.coffeetaste.feature.auth.presentation.get_started.GetStartedScreen
import com.example.coffeetaste.feature.auth.presentation.get_started.GetStartedViewModel
import com.example.coffeetaste.feature.auth.presentation.sign_in.SignInContract
import com.example.coffeetaste.feature.auth.presentation.sign_in.SignInScreen
import com.example.coffeetaste.feature.auth.presentation.sign_in.SignInViewModel
import com.example.coffeetaste.feature.auth.presentation.sign_up.SignUpContract
import com.example.coffeetaste.feature.auth.presentation.sign_up.SignUpScreen
import com.example.coffeetaste.feature.auth.presentation.sign_up.SignUpViewModel

/**
 * Auth feature graph. Each screen uses its own ViewModel; host collects effects and navigates.
 */
@Composable
fun AuthHost(
    onAuthSuccess: () -> Unit
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.GET_STARTED
    ) {
        composable(Route.GET_STARTED) {
            val viewModel: GetStartedViewModel = viewModel()
            val state by viewModel.state.collectAsState()
            LaunchedEffect(Unit) {
                viewModel.effect.collect { effect ->
                    when (effect) {
                        GetStartedContract.Effect.NavigateToSignIn ->
                            navController.navigate(Route.SIGN_IN)
                        GetStartedContract.Effect.NavigateToSignUp ->
                            navController.navigate(Route.SIGN_UP)
                    }
                }
            }
            GetStartedScreen(state = state, onEvent = viewModel::onEvent)
        }
        composable(Route.SIGN_IN) {
            val viewModel: SignInViewModel = viewModel()
            val state by viewModel.state.collectAsState()
            LaunchedEffect(Unit) {
                viewModel.effect.collect { effect ->
                    when (effect) {
                        SignInContract.Effect.NavigateToSignUp ->
                            navController.navigate(Route.SIGN_UP)
                        SignInContract.Effect.NavigateToMain -> onAuthSuccess()
                    }
                }
            }
            SignInScreen(state = state, onEvent = viewModel::onEvent)
        }
        composable(Route.SIGN_UP) {
            val viewModel: SignUpViewModel = viewModel()
            val state by viewModel.state.collectAsState()
            LaunchedEffect(Unit) {
                viewModel.effect.collect { effect ->
                    when (effect) {
                        SignUpContract.Effect.NavigateToSignIn ->
                            navController.popBackStack()
                        SignUpContract.Effect.NavigateToMain -> onAuthSuccess()
                    }
                }
            }
            SignUpScreen(state = state, onEvent = viewModel::onEvent)
        }
    }
}
