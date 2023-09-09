package com.example.swiftpay.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.swiftpay.ui.navigation.NavDestinations.SendMoney.SEND_MONEY
import com.example.swiftpay.ui.navigation.NavDestinations.SendMoney.SEND_MONEY_MAIN
import com.example.swiftpay.ui.navigation.NavDestinations.SendMoney.SEND_MONEY_RECEIPT
import com.example.swiftpay.ui.navigation.NavDestinations.SendMoney.SEND_NOW
import com.example.swiftpay.ui.screens.amount.EnterAmountScreen
import com.example.swiftpay.ui.screens.receipt.ReceiptScreen
import com.example.swiftpay.ui.screens.send_now.SendNowScreen

fun NavGraphBuilder.sendMoneyNavGraph(navController: NavController) {
    navigation(
        startDestination = SEND_MONEY,
        route = SEND_MONEY_MAIN
    ) {
        composable(route = SEND_MONEY,
            enterTransition = {
                slideInVertically(
                    animationSpec = tween(700),
                    initialOffsetY = { it }
                )
            },
            exitTransition = {
                slideOutVertically(
                    animationSpec = tween(700),
                    targetOffsetY = { it }
                )
            }
        ) {
            EnterAmountScreen(navController)
        }
        composable(route = SEND_NOW,
            enterTransition = {
                slideInVertically(
                    animationSpec = tween(700),
                    initialOffsetY = { it }
                )
            },
            exitTransition = {
                slideOutVertically(
                    animationSpec = tween(700),
                    targetOffsetY = { it }
                )
            }) {
            SendNowScreen(navController = navController)
        }
        composable(route = SEND_MONEY_RECEIPT,
            enterTransition = {
                slideInVertically(
                    animationSpec = tween(700),
                    initialOffsetY = { it }
                )
            },
            exitTransition = {
                slideOutVertically(
                    animationSpec = tween(700),
                    targetOffsetY = { it }
                )
            }) {
            ReceiptScreen(navController = navController)
        }
    }
}