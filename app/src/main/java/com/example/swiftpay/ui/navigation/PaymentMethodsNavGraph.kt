package com.example.swiftpay.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.swiftpay.ui.navigation.NavDestinations.Payment.PAYMENT_METHODS
import com.example.swiftpay.ui.navigation.NavDestinations.Payment.PAYMENT_METHODS_ROUTE
import com.example.swiftpay.ui.screens.payment_methods.PaymentMethodsScreen

fun NavGraphBuilder.paymentMethodsNavGraph(navController: NavController) {
    navigation(
        startDestination = PAYMENT_METHODS,
        route = PAYMENT_METHODS_ROUTE
    ) {
        composable(route = PAYMENT_METHODS,
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
            PaymentMethodsScreen(navController)
        }
    }
}