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
import com.example.swiftpay.ui.navigation.NavDestinations.AddPayment.ADD_NEW_PAYMENT
import com.example.swiftpay.ui.navigation.NavDestinations.AddPayment.ADD_PAYMENT_MAIN
import com.example.swiftpay.ui.personal_info.PersonalInfoScreen
import com.example.swiftpay.ui.screens.add_payment.AddPaymentScreen

fun NavGraphBuilder.addPaymentNavGraph(navController: NavController) {
    navigation(
        startDestination = ADD_NEW_PAYMENT,
        route = ADD_PAYMENT_MAIN
    ) {
        composable(route = ADD_NEW_PAYMENT,
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
            AddPaymentScreen(navController)
        }
    }
}