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
        composable(route = SEND_TO,
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
            SendToScreen(navController)
        }
    }
}