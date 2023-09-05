package com.example.swiftpay.ui.screens.account

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.swiftpay.R
import com.example.swiftpay.ui.screens.account.components.AccountDetailsSection
import com.example.swiftpay.ui.screens.account.components.AccountItem
import com.example.swiftpay.ui.screens.account.components.CustomDivider
import com.example.swiftpay.ui.screens.account.components.DarkModeItem
import com.example.swiftpay.ui.screens.account.components.LanguageItem
import com.example.swiftpay.ui.screens.account.components.LogoutItem
import com.example.swiftpay.ui.screens.common.CommonAppBar
import com.example.swiftpay.ui.screens.sign_in.state.SwitchState
import com.example.swiftpay.ui.theme.BlueGrey11
import com.example.swiftpay.ui.theme.DpDimensions
import com.example.swiftpay.ui.theme.SwiftPayTheme
import com.example.swiftpay.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun AccountScreen(navController: NavController) {

    val scrollState = rememberScrollState()

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = if (useDarkIcons)
                White else BlueGrey11,
            darkIcons = useDarkIcons
        )
    }

    Scaffold(
        topBar = {
            CommonAppBar(
                isRightIconVisible = false,
                toolBarTitle = stringResource(id = R.string.account),
                onMoreClick = { }) {
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {

            AccountDetailsSection(
                onQrCodeClick = { },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(DpDimensions.Small))

            Column(
                modifier = Modifier
                    .padding(horizontal = DpDimensions.Normal)
            ) {
                CustomDivider(
                    text = stringResource(R.string.general),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(DpDimensions.Small))

                AccountItem(
                    icon = R.drawable.cards, title = stringResource(R.string.payment_methods),
                    modifier = Modifier.fillMaxWidth()
                ) {

                }

                AccountItem(
                    icon = R.drawable.account, title = stringResource(R.string.account),
                    modifier = Modifier.fillMaxWidth()
                ) {

                }

                AccountItem(
                    icon = R.drawable.notification, title = stringResource(R.string.notification),
                    modifier = Modifier.fillMaxWidth()
                ) {

                }

                AccountItem(
                    icon = R.drawable.secutiry, title = stringResource(R.string.security),
                    modifier = Modifier.fillMaxWidth()
                ) {

                }

                LanguageItem(
                    icon = R.drawable.language,
                    title = stringResource(R.string.language),
                    language = "English (US)",
                    modifier = Modifier.fillMaxWidth()
                ) {

                }

                DarkModeItem(
                    icon = R.drawable.dark_mode,
                    title = "Dark Mode",
                    switchState = SwitchState(false),
                    onCheckChange = { }
                )

                Spacer(modifier = Modifier.height(DpDimensions.Normal))

                CustomDivider(
                    text = stringResource(R.string.about),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(DpDimensions.Normal))

                AccountItem(
                    icon = R.drawable.help,
                    title = stringResource(R.string.help),
                    modifier = Modifier.fillMaxWidth()
                ) { }

                AccountItem(
                    icon = R.drawable.privacy,
                    title = stringResource(R.string.privacy),
                    modifier = Modifier.fillMaxWidth()
                ) { }

                AccountItem(
                    icon = R.drawable.info,
                    title = stringResource(R.string.about),
                    modifier = Modifier.fillMaxWidth()
                ) { }

                LogoutItem(
                    icon = R.drawable.logout,
                    title = stringResource(R.string.logout),
                    modifier = Modifier.fillMaxWidth()
                ) {}

                Spacer(modifier = Modifier.height(30.dp))

            }


        }
    }

}

@Preview
@Composable
fun AccountScreenPreview() {
    SwiftPayTheme {
        AccountScreen(rememberNavController())
    }
}