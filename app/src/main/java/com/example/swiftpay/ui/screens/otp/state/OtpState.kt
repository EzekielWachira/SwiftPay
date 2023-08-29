package com.example.swiftpay.ui.screens.otp.state

data class OtpState(
    var value: String = "",
    var fullOtp: MutableList<String> = mutableListOf(),
    var index: Int = -1
) {
    override fun toString(): String {
        return fullOtp.joinToString("")
    }
}
