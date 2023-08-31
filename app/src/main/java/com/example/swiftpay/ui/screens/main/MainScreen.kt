package com.example.swiftpay.ui.screens.main

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
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.swiftpay.ui.navigation.BottomNavBar
import com.example.swiftpay.ui.navigation.NavDestinations
import com.example.swiftpay.ui.navigation.Screen
import com.example.swiftpay.ui.screens.account.AccountScreen
import com.example.swiftpay.ui.screens.contacts.ContactsScreen
import com.example.swiftpay.ui.screens.home.HomeScreen
import com.example.swiftpay.ui.screens.insights.InsightsScreen
import com.example.swiftpay.ui.screens.main.components.MainTopBar
import com.example.swiftpay.ui.screens.scan.ScanScreen
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

    val navController = rememberNavController()
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    bottomBarVisible = when (navBackStackEntry?.destination?.route) {
        Screen.Home.route -> true
        Screen.Contacts.route -> true
        Screen.Scan.route -> true
        Screen.Insights.route -> true
        Screen.Account.route -> true
        else -> false
    }

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = if (useDarkIcons)
                Green67 else Green67,
            darkIcons = true
        )

        systemUiController.setNavigationBarColor(
            color = if (useDarkIcons)
                White else BlueGrey11,
            darkIcons = true
        )
    }

    Scaffold(
        bottomBar = { BottomNavBar(navController = navController, visible = bottomBarVisible) }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = NavDestinations.MAIN,
            modifier = Modifier.padding(paddingValues)
        ) {

            navigation(startDestination = Screen.Home.route, route = NavDestinations.MAIN) {

                composable(route = Screen.Home.route) {
                    HomeScreen(navController = navController)
                }

                composable(route = Screen.Contacts.route) {
                    ContactsScreen(navController = navController)
                }

                composable(route = Screen.Scan.route) {
                    ScanScreen(navController = navController)
                }

                composable(route = Screen.Insights.route) {
                    InsightsScreen(navController = navController)
                }

                composable(route = Screen.Account.route) {
                    AccountScreen(navController = navController)
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