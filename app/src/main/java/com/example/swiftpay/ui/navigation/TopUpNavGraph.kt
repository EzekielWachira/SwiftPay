package com.example.swiftpay.ui.navigation

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
        composable(route = TOP_UP_AMOUNT) {
            TopUpScreen(navController)
        }

        composable(route = SELECT_TOP_UP) {
            SelectTopUpScreen(navController)
        }

        composable(route = TOP_UP_NOW) {
            TopUpNowScreen(navController)
        }

        composable(route = TOP_UP_RECEIPT) {
            TopUpReceiptScreen(navController)
        }
    }
}