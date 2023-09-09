package com.example.swiftpay.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.swiftpay.ui.navigation.NavDestinations.NotificationSettings.NOTIFICATION_SETTINGS
import com.example.swiftpay.ui.navigation.NavDestinations.NotificationSettings.NOTIFICATION_SETTINGS_SCREEN
import com.example.swiftpay.ui.screens.notitifcation_settings.NotificationSettingsScreen

fun NavGraphBuilder.navigationSettings(navController: NavController) {
    navigation(
        startDestination = NOTIFICATION_SETTINGS,
        route = NOTIFICATION_SETTINGS_SCREEN
    ) {
        composable(route = NOTIFICATION_SETTINGS,
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
            NotificationSettingsScreen(navController)
        }
    }
}