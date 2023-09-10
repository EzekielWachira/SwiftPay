package com.example.swiftpay.ui.screens.splash

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
import com.example.swiftpay.ui.navigation.NavDestinations.Auth.AUTH
import com.example.swiftpay.ui.navigation.NavDestinations.MAIN_APP
import com.example.swiftpay.ui.navigation.Screen
import com.example.swiftpay.ui.navigation.authNavGraph
import com.example.swiftpay.ui.navigation.splashNavGraph
import com.example.swiftpay.ui.screens.auth.AuthScreen
import com.example.swiftpay.ui.screens.main.MainScreen

@Composable
fun SplashMain() {
    val navController = rememberNavController()

    Scaffold { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = NavDestinations.Auth.SPLASH_MAIN,
            modifier = Modifier.padding(paddingValues)
        ) {
            splashNavGraph(navController)

            navigation(
                route = MAIN_APP,
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


            navigation(
                route = AUTH,
                startDestination = "authentication"
            ) {
                composable(route = "authentication",
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
                    AuthScreen()
                }
            }
        }

    }
}