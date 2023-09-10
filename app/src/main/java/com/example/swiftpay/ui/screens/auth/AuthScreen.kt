package com.example.swiftpay.ui.screens.auth

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.swiftpay.ui.navigation.NavDestinations
import com.example.swiftpay.ui.navigation.Screen
import com.example.swiftpay.ui.navigation.authNavGraph
import com.example.swiftpay.ui.screens.main.MainScreen

@Composable
fun AuthScreen() {
    val navController = rememberNavController()

    Scaffold { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = NavDestinations.Auth.AUTH_MAIN,
            modifier = Modifier.padding(paddingValues)
        ) {
            authNavGraph(navController)
            navigation(
                route = NavDestinations.MAIN_APP,
                startDestination = Screen.Home.route
            ) {
                composable(route = Screen.Home.route,
                    enterTransition = {
                        slideInVertically(
                            animationSpec = tween(700),
                            initialOffsetY = { it }
                        )
                    },
                    exitTransition = {
                        slideOutVertically (
                            animationSpec = tween(700),
                            targetOffsetY = { it }
                        )
                    }) {
                    MainScreen()
                }
            }
        }

    }
}