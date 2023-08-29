package com.example.swiftpay.ui.screens.otp

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.swiftpay.ui.screens.common.AppBar
import com.example.swiftpay.ui.theme.BlueGrey11
import com.example.swiftpay.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun OtpScreen() {

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = if (useDarkIcons)
                White else BlueGrey11,
            darkIcons = useDarkIcons
        )
    }

    val navController = rememberNavController()

    Scaffold(
        topBar = { AppBar(modifier = Modifier.fillMaxWidth(), onBackClicked = { }) }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {


        }
    }

}