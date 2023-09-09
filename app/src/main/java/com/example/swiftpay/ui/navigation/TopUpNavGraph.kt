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
import com.example.swiftpay.ui.navigation.NavDestinations.TopUp.SELECT_TOP_UP
import com.example.swiftpay.ui.navigation.NavDestinations.TopUp.TOP_UP_AMOUNT
import com.example.swiftpay.ui.navigation.NavDestinations.TopUp.TOP_UP_MAIN
import com.example.swiftpay.ui.navigation.NavDestinations.TopUp.TOP_UP_NOW
import com.example.swiftpay.ui.navigation.NavDestinations.TopUp.TOP_UP_RECEIPT
import com.example.swiftpay.ui.personal_info.PersonalInfoScreen
import com.example.swiftpay.ui.screens.top_up.TopUpScreen
import com.example.swiftpay.ui.screens.top_up.receipt.TopUpReceiptScreen
import com.example.swiftpay.ui.screens.top_up.select.SelectTopUpScreen
import com.example.swiftpay.ui.screens.top_up.top_up_now.TopUpNowScreen

fun NavGraphBuilder.topUpNavGraph(navController: NavController) {
    navigation(
        startDestination = TOP_UP_AMOUNT,
        route = TOP_UP_MAIN
    ) {
        composable(route = TOP_UP_AMOUNT,
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
            TopUpScreen(navController)
        }

        composable(route = SELECT_TOP_UP,
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
            SelectTopUpScreen(navController)
        }

        composable(route = TOP_UP_NOW,
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
            TopUpNowScreen(navController)
        }

        composable(route = TOP_UP_RECEIPT,
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
            TopUpReceiptScreen(navController)
        }
    }
}