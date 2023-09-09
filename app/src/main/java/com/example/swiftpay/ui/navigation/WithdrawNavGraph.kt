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
import com.example.swiftpay.ui.navigation.NavDestinations.Withdraw.WITHDRAW
import com.example.swiftpay.ui.navigation.NavDestinations.Withdraw.WITHDRAW_MAIN
import com.example.swiftpay.ui.navigation.NavDestinations.Withdraw.WITHDRAW_NOW
import com.example.swiftpay.ui.navigation.NavDestinations.Withdraw.WITHDRAW_RECEIPT
import com.example.swiftpay.ui.navigation.NavDestinations.Withdraw.WITHDRAW_TO
import com.example.swiftpay.ui.personal_info.PersonalInfoScreen
import com.example.swiftpay.ui.screens.withdraw.WithdrawScreen
import com.example.swiftpay.ui.screens.withdraw.receipt.WithdrawReceiptScreen
import com.example.swiftpay.ui.screens.withdraw.withdraw_now.WithdrawNowScreen
import com.example.swiftpay.ui.screens.withdraw.withdraw_to.WithdrawToScreen

fun NavGraphBuilder.withdrawNavGraph(navController: NavController) {
    navigation(
        startDestination = WITHDRAW ,
        route = WITHDRAW_MAIN
    ) {
        composable(route = WITHDRAW,
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
            WithdrawScreen(navController)
        }

        composable(route = WITHDRAW_TO,
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
            WithdrawToScreen(navController)
        }

        composable(route = WITHDRAW_NOW,
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
            WithdrawNowScreen(navController)
        }

        composable(route = WITHDRAW_RECEIPT,
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
            WithdrawReceiptScreen(navController)
        }
    }
}