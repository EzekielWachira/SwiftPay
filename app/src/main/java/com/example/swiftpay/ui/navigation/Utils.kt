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

    object Settings {
        const val APP_SETTINGS = "app_settings"
        const val NOTIFICATION_SETTINGS = "notification_settings"
    }

    object Payment {
        const val PAYMENT_METHODS_ROUTE = "payment_methods_route"
        const val PAYMENT_METHODS = "payment_methods"
        const val ADD_NEW_PAYMENT = "add_new_payment"
    }

    object Account {
        const val PERSONAL_INFO_SCREEN = "personal_info_screen"
        const val PERSONAL_INFO = "personal_info"
    }

}