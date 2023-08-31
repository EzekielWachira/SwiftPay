package com.example.swiftpay.ui.navigation

val navigationScreens = listOf(
    Screen.Home,
    Screen.Contacts,
    Screen.Scan,
    Screen.Insights,
    Screen.Account
)


object NavDestinations {
    const val MAIN = "main"
    const val SEND = "send"
    const val REQUEST = "request"
    const val TOP_UP = "top_up"
    const val WITHDRAW = "withdraw"
}