package com.example.swiftpay.ui.navigation

import android.util.Config.PROFILE
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.swiftpay.R

sealed class Screen(val route: String, @StringRes val label: Int, @DrawableRes val icon: Int) {
    object Home: Screen(HOME, R.string.home, R.drawable.home)
    object Contacts: Screen(CONTACTS, R.string.contacts, R.drawable.contacts)
    object Scan: Screen(SCAN, R.string.scan, R.drawable.scan)
    object Insights: Screen(INSIGHTS, R.string.insights, R.drawable.insights)
    object Account: Screen(ACCOUNT, R.string.account, R.drawable.account)

    companion object {
        const val HOME = "home"
        const val CONTACTS = "contacts"
        const val INSIGHTS = "insights"
        const val ACCOUNT = "account"
        const val SCAN = "scan"
    }
}