package com.example.swiftpay.ui.screens.amount.state

data class AmountState(
    val amount: String = "",
    val isValid: Boolean = amount.isNotEmpty() && amount.toFloat() > 0
)