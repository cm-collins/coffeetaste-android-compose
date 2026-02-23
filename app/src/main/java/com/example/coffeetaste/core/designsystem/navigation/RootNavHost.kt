package com.example.coffeetaste.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.coffeetaste.feature.auth.presentation.AuthHost
import com.example.coffeetaste.feature.home.presentation.MainHost
import com.example.coffeetaste.feature.splash.presentation.SplashHost

/**
 * Root (entrypoint) graph: Splash → Auth host → Main host.
 * Each host has its own NavController and internal graph.
 */
@Composable
fun RootNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Route.SPLASH
    ) {
        composable(Route.SPLASH) {
            SplashHost(
                onFinish = {
                    navController.navigate(Graph.AUTH) {
                        popUpTo(Route.SPLASH) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(Graph.AUTH) {
            AuthHost(
                onAuthSuccess = {
                    navController.navigate(Graph.MAIN) {
                        popUpTo(Graph.AUTH) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(Graph.MAIN) {
            MainHost()
        }
    }
}
