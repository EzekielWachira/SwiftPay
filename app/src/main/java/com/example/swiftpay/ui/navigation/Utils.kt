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

    }

    object AddPayment {
        const val ADD_PAYMENT_MAIN = "add_payment_payment"
        const val ADD_NEW_PAYMENT = "add_new_payment"
    }

    object Account {
        const val PERSONAL_INFO_SCREEN = "personal_info_screen"
        const val PERSONAL_INFO = "personal_info"
    }

    object NotificationSettings {
        const val NOTIFICATION_SETTINGS_SCREEN = "notification_settings_screen"
        const val NOTIFICATION_SETTINGS = "notification_settings"
    }

    object Security {
        const val SECURITY_SCREEN = "security_screen"
        const val SECURITY = "security"
    }

    object HelpCenter {
        const val HELP_CENTER_MAIN = "help_center_main"
        const val HELP_CENTER = "help_center"
    }

    object Language {
        const val LANGUAGE_MAIN = "language_main"
        const val LANGUAGE = "language"
    }

    object SendMoney {
        const val SEND_MONEY_MAIN = "send_money_main"
        const val SEND_MONEY = "send_money"
        const val SEND_NOW = "send_now"
        const val SEND_MONEY_RECEIPT ="send_money_receipt"
    }

    object SendTo {
        const val SEND_TO_MAIN = "send_to_main"
        const val SEND_TO = "send_to"
    }

    object RequestMoney {
        const val REQUEST_MONEY_MAIN = "request_money_main"
        const val REQUEST_MONEY = "request_money"
        const val REQUEST_NOW = "request_now"
        const val REQUEST_FROM = "request_from"
        const val REQUEST_RECEIPT = "request_receipt"
    }

    object TopUp {
        const val TOP_UP_MAIN = "top_up_main"
        const val TOP_UP_AMOUNT = "top_up_amount"
        const val SELECT_TOP_UP = "select_top_up"
        const val TOP_UP_NOW = "top_up_now"
        const val TOP_UP_RECEIPT = "top_up_receipt"
    }

    object Withdraw {
        const val WITHDRAW_MAIN = "withdraw_main"
        const val WITHDRAW = "withdraw"
        const val WITHDRAW_TO = "withdraw_to"
        const val WITHDRAW_NOW = "withdraw_now"
        const val WITHDRAW_RECEIPT = "withdraw_receipt"
    }

}