package com.example.swiftpay.ui.navigation

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
import com.example.swiftpay.ui.screens.security.SecurityScreen
import com.example.swiftpay.ui.screens.send_now.SendNowScreen

fun NavGraphBuilder.sendMoneyNavGraph(navController: NavController) {
    navigation(
        startDestination = SEND_MONEY,
        route = SEND_MONEY_MAIN
    ) {
        composable(route = SEND_MONEY) {
            EnterAmountScreen(navController)
        }
        composable(route = SEND_NOW) {
            SendNowScreen(navController = navController)
        }
        composable(route = SEND_MONEY_RECEIPT) {
            ReceiptScreen(navController = navController)
        }
    }
}