package com.example.swiftpay.ui.screens.main

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.swiftpay.ui.navigation.BottomNavBar
import com.example.swiftpay.ui.navigation.NavDestinations
import com.example.swiftpay.ui.navigation.NavDestinations.Auth.AUTH_MAIN
import com.example.swiftpay.ui.navigation.NavDestinations.MAIN
import com.example.swiftpay.ui.navigation.Screen
import com.example.swiftpay.ui.navigation.accountNavGraph
import com.example.swiftpay.ui.navigation.addContactNavGraph
import com.example.swiftpay.ui.navigation.addPaymentNavGraph
import com.example.swiftpay.ui.navigation.authNavGraph
import com.example.swiftpay.ui.navigation.helpCenterNavGraph
import com.example.swiftpay.ui.navigation.languageNavGraph
import com.example.swiftpay.ui.navigation.mainNavGraph
import com.example.swiftpay.ui.navigation.navigationSettings
import com.example.swiftpay.ui.navigation.paymentMethodsNavGraph
import com.example.swiftpay.ui.navigation.requestNavGraph
import com.example.swiftpay.ui.navigation.securityNavGraph
import com.example.swiftpay.ui.navigation.sendMoneyNavGraph
import com.example.swiftpay.ui.navigation.sendToNavGraph
import com.example.swiftpay.ui.navigation.topUpNavGraph
import com.example.swiftpay.ui.navigation.withdrawNavGraph
import com.example.swiftpay.ui.screens.auth.AuthScreen
import com.example.swiftpay.ui.theme.BlueGrey11
import com.example.swiftpay.ui.theme.Green67
import com.example.swiftpay.ui.theme.SwiftPayTheme
import com.example.swiftpay.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun MainScreen() {

    var bottomBarVisible by rememberSaveable {
        mutableStateOf(false)
    }

    var isLoggedIn by rememberSaveable {
        mutableStateOf(true)
    }

    val navController = rememberNavController()
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    bottomBarVisible = when (navBackStackEntry?.destination?.route) {
        Screen.Home.route -> true
        Screen.Contacts.route -> true
//        Screen.Scan.route -> true
        Screen.Insights.route -> true
        Screen.Account.route -> true
        else -> false
    }

//    SideEffect {
//        systemUiController.setSystemBarsColor(
//            color = if (useDarkIcons)
//                Green67 else Green67,
//            darkIcons = true
//        )
//
//        systemUiController.setNavigationBarColor(
//            color = if (useDarkIcons)
//                White else BlueGrey11,
//            darkIcons = true
//        )
//    }

    Scaffold(
        bottomBar = { BottomNavBar(navController = navController, visible = bottomBarVisible) }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = MAIN,
            modifier = Modifier.padding(paddingValues)
        ) {

            mainNavGraph(navController)
            paymentMethodsNavGraph(navController)
            accountNavGraph(navController)
            addPaymentNavGraph(navController)
            navigationSettings(navController)
            securityNavGraph(navController)
            languageNavGraph(navController)
            helpCenterNavGraph(navController)
            sendMoneyNavGraph(navController)
            sendToNavGraph(navController)
            requestNavGraph(navController)
            topUpNavGraph(navController)
            withdrawNavGraph(navController)
            addContactNavGraph(navController)
            navigation(
                route = NavDestinations.Auth.AUTH,
                startDestination = "authentication"
            ) {
                composable(route = "authentication",
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
                    AuthScreen()
                }
            }

        }

    }


}

@Preview
@Composable
fun MainScreenPreview() {
    SwiftPayTheme {
        MainScreen()
    }
}