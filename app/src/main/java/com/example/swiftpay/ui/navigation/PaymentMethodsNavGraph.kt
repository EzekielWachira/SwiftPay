package com.example.swiftpay.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.swiftpay.ui.navigation.NavDestinations.Payment.ADD_NEW_PAYMENT
import com.example.swiftpay.ui.navigation.NavDestinations.Payment.PAYMENT_METHODS
import com.example.swiftpay.ui.navigation.NavDestinations.Payment.PAYMENT_METHODS_ROUTE
import com.example.swiftpay.ui.screens.add_payment.AddPaymentScreen
import com.example.swiftpay.ui.screens.payment_methods.PaymentMethodsScreen

fun NavGraphBuilder.paymentMethodsNavGraph(navController: NavController) {
    navigation(
        startDestination = PAYMENT_METHODS,
        route = PAYMENT_METHODS_ROUTE
    ) {
        composable(route = PAYMENT_METHODS) {
            PaymentMethodsScreen(navController)
        }
        composable(ADD_NEW_PAYMENT) {
            AddPaymentScreen(navController)
        }
    }
}