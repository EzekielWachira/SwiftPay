package com.example.swiftpay.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.swiftpay.ui.navigation.NavDestinations.NotificationSettings.NOTIFICATION_SETTINGS
import com.example.swiftpay.ui.navigation.NavDestinations.NotificationSettings.NOTIFICATION_SETTINGS_SCREEN
import com.example.swiftpay.ui.navigation.NavDestinations.Security.SECURITY
import com.example.swiftpay.ui.navigation.NavDestinations.Security.SECURITY_SCREEN
import com.example.swiftpay.ui.screens.notitifcation_settings.NotificationSettingsScreen
import com.example.swiftpay.ui.screens.security.SecurityScreen

fun NavGraphBuilder.securityNavGraph(navController: NavController) {
    navigation(
        startDestination = SECURITY,
        route = SECURITY_SCREEN
    ) {
        composable(route = SECURITY) {
            SecurityScreen(navController)
        }
    }
}