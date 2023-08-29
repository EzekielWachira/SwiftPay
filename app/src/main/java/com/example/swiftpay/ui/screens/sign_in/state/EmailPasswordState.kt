package com.example.swiftpay.ui.screens.sign_in.state

data class EmailPasswordState(
    var isValidEmail: Boolean = false,
    val email: String = "",
    val isValidPassword: Boolean = false,
    val password: String = ""
)

enum class Action {
    RESET_PASSWORD,
    SIGN_UP,
    SIGN_IN
}
