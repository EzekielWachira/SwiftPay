package com.example.swiftpay.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.swiftpay.ui.navigation.NavDestinations.SendMoney.SEND_MONEY
import com.example.swiftpay.ui.navigation.NavDestinations.SendMoney.SEND_MONEY_MAIN
import com.example.swiftpay.ui.navigation.NavDestinations.SendTo.SEND_TO
import com.example.swiftpay.ui.navigation.NavDestinations.SendTo.SEND_TO_MAIN
import com.example.swiftpay.ui.screens.amount.EnterAmountScreen
import com.example.swiftpay.ui.screens.security.SecurityScreen
import com.example.swiftpay.ui.screens.send_to.SendToScreen

fun NavGraphBuilder.sendToNavGraph(navController: NavController) {
    navigation(
        startDestination = SEND_TO,
        route = SEND_TO_MAIN
    ) {
        composable(route = SEND_TO) {
            SendToScreen(navController)
        }
    }
}