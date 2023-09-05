package com.example.swiftpay.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navigation
import com.example.swiftpay.ui.navigation.NavDestinations.Account.PERSONAL_INFO
import com.example.swiftpay.ui.navigation.NavDestinations.Account.PERSONAL_INFO_SCREEN
import com.example.swiftpay.ui.personal_info.PersonalInfoScreen
import com.example.swiftpay.ui.screens.account.AccountScreen
import com.example.swiftpay.ui.screens.contacts.ContactsScreen
import com.example.swiftpay.ui.screens.home.HomeScreen
import com.example.swiftpay.ui.screens.insights.InsightsScreen
import com.example.swiftpay.ui.screens.scan.ScanScreen

fun NavGraphBuilder.mainNavGraph(navController: NavController) {
    navigation(startDestination = Screen.Home.route, route = NavDestinations.MAIN) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.Contacts.route) {
            ContactsScreen(navController = navController)
        }

        composable(route = Screen.Scan.route) {
            ScanScreen(navController = navController)
        }

        composable(route = Screen.Insights.route) {
            InsightsScreen(navController = navController)
        }

        composable(route = Screen.Account.route) {
            AccountScreen(navController)
        }

    }
}