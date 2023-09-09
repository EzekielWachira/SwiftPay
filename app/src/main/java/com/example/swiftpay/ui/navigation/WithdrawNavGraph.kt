package com.example.swiftpay.ui.navigation

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
        composable(route = WITHDRAW) {
            WithdrawScreen(navController)
        }

        composable(route = WITHDRAW_TO) {
            WithdrawToScreen(navController)
        }

        composable(route = WITHDRAW_NOW) {
            WithdrawNowScreen(navController)
        }

        composable(route = WITHDRAW_RECEIPT) {
            WithdrawReceiptScreen(navController)
        }
    }
}