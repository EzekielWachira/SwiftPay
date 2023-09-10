package com.example.swiftpay.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.swiftpay.ui.navigation.NavDestinations.Account.PERSONAL_INFO
import com.example.swiftpay.ui.navigation.NavDestinations.Account.PERSONAL_INFO_SCREEN
import com.example.swiftpay.ui.navigation.NavDestinations.RequestMoney.REQUEST_FROM
import com.example.swiftpay.ui.navigation.NavDestinations.RequestMoney.REQUEST_MONEY
import com.example.swiftpay.ui.navigation.NavDestinations.RequestMoney.REQUEST_MONEY_MAIN
import com.example.swiftpay.ui.navigation.NavDestinations.RequestMoney.REQUEST_NOW
import com.example.swiftpay.ui.navigation.NavDestinations.RequestMoney.REQUEST_RECEIPT
import com.example.swiftpay.ui.personal_info.PersonalInfoScreen
import com.example.swiftpay.ui.screens.request_money.request_amount.RequestAmountScreen
import com.example.swiftpay.ui.screens.request_money.request_from.RequestFromScreen
import com.example.swiftpay.ui.screens.request_money.request_money_receipt.RequestMoneyReceiptScreen
import com.example.swiftpay.ui.screens.request_money.request_now.RequestNowScreen

fun NavGraphBuilder.requestNavGraph(navController: NavController) {
    navigation(
        startDestination = REQUEST_FROM,
        route = REQUEST_MONEY_MAIN
    ) {
        composable(route = REQUEST_FROM,
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
            RequestFromScreen(navController)
        }

        composable(route = REQUEST_MONEY,
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
            RequestAmountScreen(navController)
        }

        composable(route = REQUEST_NOW,
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
            RequestNowScreen(navController)
        }

        composable(route = REQUEST_RECEIPT,
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
            RequestMoneyReceiptScreen(navController)
        }
    }
}