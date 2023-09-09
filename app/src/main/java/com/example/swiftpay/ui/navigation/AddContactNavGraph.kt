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
import com.example.swiftpay.ui.navigation.NavDestinations.Contacts.ADD_CONTACT
import com.example.swiftpay.ui.navigation.NavDestinations.Contacts.ADD_CONTACT_MAIN
import com.example.swiftpay.ui.personal_info.PersonalInfoScreen
import com.example.swiftpay.ui.screens.add_contact.AddContactScreen

fun NavGraphBuilder.addContactNavGraph(navController: NavController) {
    navigation(
        startDestination = ADD_CONTACT,
        route = ADD_CONTACT_MAIN
    ) {
        composable(route = ADD_CONTACT,
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
            AddContactScreen(navController)
        }
    }
}