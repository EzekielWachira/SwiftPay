package com.example.swiftpay.ui.navigation

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
        composable(route = ADD_NEW_PAYMENT) {
            AddPaymentScreen(navController)
        }
    }
}