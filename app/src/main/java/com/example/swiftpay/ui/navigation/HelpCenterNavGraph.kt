package com.example.swiftpay.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.swiftpay.ui.navigation.NavDestinations.HelpCenter.HELP_CENTER
import com.example.swiftpay.ui.navigation.NavDestinations.HelpCenter.HELP_CENTER_MAIN
import com.example.swiftpay.ui.navigation.NavDestinations.NotificationSettings.NOTIFICATION_SETTINGS
import com.example.swiftpay.ui.navigation.NavDestinations.NotificationSettings.NOTIFICATION_SETTINGS_SCREEN
import com.example.swiftpay.ui.navigation.NavDestinations.Security.SECURITY
import com.example.swiftpay.ui.navigation.NavDestinations.Security.SECURITY_SCREEN
import com.example.swiftpay.ui.screens.help.HelpCenterScreen
import com.example.swiftpay.ui.screens.notitifcation_settings.NotificationSettingsScreen
import com.example.swiftpay.ui.screens.security.SecurityScreen

fun NavGraphBuilder.helpCenterNavGraph(navController: NavController) {
    navigation(
        startDestination = HELP_CENTER,
        route = HELP_CENTER_MAIN
    ) {
        composable(route = HELP_CENTER) {
            HelpCenterScreen(navController)
        }
    }
}