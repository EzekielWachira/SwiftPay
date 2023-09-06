package com.example.swiftpay.ui.navigation

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
        composable(route = NOTIFICATION_SETTINGS) {
            NotificationSettingsScreen(navController)
        }
    }
}