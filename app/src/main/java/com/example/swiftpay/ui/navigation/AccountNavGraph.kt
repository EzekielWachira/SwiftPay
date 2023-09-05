package com.example.swiftpay.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.swiftpay.ui.navigation.NavDestinations.Account.PERSONAL_INFO
import com.example.swiftpay.ui.navigation.NavDestinations.Account.PERSONAL_INFO_SCREEN
import com.example.swiftpay.ui.personal_info.PersonalInfoScreen

fun NavGraphBuilder.accountNavGraph(navController: NavController) {
    navigation(
        startDestination = PERSONAL_INFO,
        route = PERSONAL_INFO_SCREEN
    ) {
        composable(route = PERSONAL_INFO) {
            PersonalInfoScreen(navController)
        }
    }
}