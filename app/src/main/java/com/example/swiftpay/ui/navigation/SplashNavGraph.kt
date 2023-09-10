package com.example.swiftpay.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.swiftpay.ui.navigation.NavDestinations.Account.PERSONAL_INFO
import com.example.swiftpay.ui.navigation.NavDestinations.Account.PERSONAL_INFO_SCREEN
import com.example.swiftpay.ui.navigation.NavDestinations.Auth.SPLASH
import com.example.swiftpay.ui.navigation.NavDestinations.Auth.SPLASH_MAIN
import com.example.swiftpay.ui.personal_info.PersonalInfoScreen
import com.example.swiftpay.ui.screens.splash.SplashScreen

fun NavGraphBuilder.splashNavGraph(navController: NavController) {
    navigation(
        startDestination = SPLASH,
        route = SPLASH_MAIN
    ) {
        composable(route = SPLASH,
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
            SplashScreen(navController)
        }
    }
}