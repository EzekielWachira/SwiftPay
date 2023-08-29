package com.example.swiftpay.extensions

import java.util.regex.Pattern

fun String.isValidEmail(): Boolean {
    val emailString = ("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    return Pattern.compile(emailString).matcher(this).matches()
}

fun String.isValidPassword(): Boolean {
    return length >= 5
}