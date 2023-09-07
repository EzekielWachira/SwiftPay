package com.example.swiftpay.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.swiftpay.ui.navigation.NavDestinations.HelpCenter.HELP_CENTER
import com.example.swiftpay.ui.navigation.NavDestinations.HelpCenter.HELP_CENTER_MAIN
import com.example.swiftpay.ui.navigation.NavDestinations.Language.LANGUAGE
import com.example.swiftpay.ui.navigation.NavDestinations.Language.LANGUAGE_MAIN
import com.example.swiftpay.ui.navigation.NavDestinations.NotificationSettings.NOTIFICATION_SETTINGS
import com.example.swiftpay.ui.navigation.NavDestinations.NotificationSettings.NOTIFICATION_SETTINGS_SCREEN
import com.example.swiftpay.ui.navigation.NavDestinations.Security.SECURITY
import com.example.swiftpay.ui.navigation.NavDestinations.Security.SECURITY_SCREEN
import com.example.swiftpay.ui.screens.help.HelpCenterScreen
import com.example.swiftpay.ui.screens.language.LanguageScreen
import com.example.swiftpay.ui.screens.notitifcation_settings.NotificationSettingsScreen
import com.example.swiftpay.ui.screens.security.SecurityScreen

fun NavGraphBuilder.languageNavGraph(navController: NavController) {
    navigation(
        startDestination = LANGUAGE,
        route = LANGUAGE_MAIN
    ) {
        composable(route = LANGUAGE) {
            LanguageScreen(navController)
        }
    }
}