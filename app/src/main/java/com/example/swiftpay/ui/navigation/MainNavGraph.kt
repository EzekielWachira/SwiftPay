package com.example.swiftpay.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navigation
import com.example.swiftpay.ui.navigation.NavDestinations.Account.PERSONAL_INFO
import com.example.swiftpay.ui.navigation.NavDestinations.Account.PERSONAL_INFO_SCREEN
import com.example.swiftpay.ui.navigation.NavDestinations.Contacts.ADD_CONTACT
import com.example.swiftpay.ui.personal_info.PersonalInfoScreen
import com.example.swiftpay.ui.screens.account.AccountScreen
import com.example.swiftpay.ui.screens.add_contact.AddContactScreen
import com.example.swiftpay.ui.screens.contacts.ContactsScreen
import com.example.swiftpay.ui.screens.home.HomeScreen
import com.example.swiftpay.ui.screens.insights.InsightsScreen
import com.example.swiftpay.ui.screens.scan.ScanScreen

fun NavGraphBuilder.mainNavGraph(navController: NavController) {
    navigation(startDestination = Screen.Home.route, route = NavDestinations.MAIN) {
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
            HomeScreen(navController = navController)
        }

        composable(route = Screen.Contacts.route,
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
            ContactsScreen(navController = navController)
        }

        composable(route = Screen.Scan.route,
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
            ScanScreen(navController = navController)
        }

        composable(route = Screen.Insights.route,
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
            InsightsScreen(navController = navController)
        }

        composable(route = Screen.Account.route,
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
            AccountScreen(navController)
        }

    }
}