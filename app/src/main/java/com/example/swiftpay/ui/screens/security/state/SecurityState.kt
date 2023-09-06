package com.example.swiftpay.ui.screens.security.state

data class SecurityState(
    val rememberMe: Boolean = false,
    val biometricId: Boolean = false,
    val faceId: Boolean = false,
    val smsAuthenticator: Boolean = false,
    val googleAuthenticator: Boolean = false,
)
