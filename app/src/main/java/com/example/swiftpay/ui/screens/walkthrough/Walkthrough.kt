package com.example.swiftpay.ui.screens.walkthrough

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.swiftpay.R

data class Walkthrough(
    @DrawableRes val image: Int,
    @StringRes val title: Int,
    @StringRes val description: Int
)

val onboardingItems = listOf(
    Walkthrough(
        image = R.drawable.home_screen,
        title = R.string.send_money,
        description = R.string.send_money_desc
    ),
    Walkthrough(
        image = R.drawable.receiptt,
        title = R.string.safe_secure,
        description = R.string.safe_secure_desc
    ),
    Walkthrough(
        image = R.drawable.transactionss,
        title = R.string.manage_track,
        description = R.string.manage_track_desc
    )
)
