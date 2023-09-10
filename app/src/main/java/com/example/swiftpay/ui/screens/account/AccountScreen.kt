package com.example.swiftpay.ui.screens.account

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.swiftpay.R
import com.example.swiftpay.ui.navigation.NavDestinations
import com.example.swiftpay.ui.navigation.NavDestinations.Account.PERSONAL_INFO_SCREEN
import com.example.swiftpay.ui.navigation.NavDestinations.HelpCenter.HELP_CENTER_MAIN
import com.example.swiftpay.ui.navigation.NavDestinations.Language.LANGUAGE_MAIN
import com.example.swiftpay.ui.navigation.NavDestinations.NotificationSettings.NOTIFICATION_SETTINGS_SCREEN
import com.example.swiftpay.ui.navigation.NavDestinations.Payment.PAYMENT_METHODS_ROUTE
import com.example.swiftpay.ui.navigation.NavDestinations.Security.SECURITY_SCREEN
import com.example.swiftpay.ui.screens.account.components.AccountDetailsSection
import com.example.swiftpay.ui.screens.account.components.AccountItem
import com.example.swiftpay.ui.screens.account.components.CustomDivider
import com.example.swiftpay.ui.screens.account.components.DarkModeItem
import com.example.swiftpay.ui.screens.account.components.LanguageItem
import com.example.swiftpay.ui.screens.account.components.LogoutConfirmationBottomSheet
import com.example.swiftpay.ui.screens.account.components.LogoutItem
import com.example.swiftpay.ui.screens.account.components.QRCodeBottomSheet
import com.example.swiftpay.ui.screens.common.CommonAppBar
import com.example.swiftpay.ui.screens.sign_in.SignInViewModel
import com.example.swiftpay.ui.theme.BlueGrey11
import com.example.swiftpay.ui.theme.DpDimensions
import com.example.swiftpay.ui.theme.SwiftPayTheme
import com.example.swiftpay.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountScreen(navController: NavController) {

//    val navController = rememberNavController()
    val scrollState = rememberScrollState()
    val bottomSheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()
    val viewModel: AccountViewModel = hiltViewModel()
    val signInViewModel: SignInViewModel = hiltViewModel()
    val switchState by viewModel.switchState.collectAsStateWithLifecycle()
    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }

    var isLogoutSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }


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

            Column(
                modifier = Modifier.fillMaxSize()
            ) {


                AccountDetailsSection(
                    onQrCodeClick = {
                        isSheetOpen = true
                    },
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        navController.navigate(PERSONAL_INFO_SCREEN)
                    }
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
                        navController.navigate(PAYMENT_METHODS_ROUTE)
                    }

                    AccountItem(
                        icon = R.drawable.account, title = stringResource(R.string.personal_info),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        navController.navigate(PERSONAL_INFO_SCREEN)
                    }

                    AccountItem(
                        icon = R.drawable.notification,
                        title = stringResource(R.string.notification),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        navController.navigate(NOTIFICATION_SETTINGS_SCREEN)
                    }

                    AccountItem(
                        icon = R.drawable.secutiry, title = stringResource(R.string.security),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        navController.navigate(SECURITY_SCREEN)
                    }

                    LanguageItem(
                        icon = R.drawable.language,
                        title = stringResource(R.string.language),
                        language = "English (US)",
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        navController.navigate(LANGUAGE_MAIN)
                    }

                    DarkModeItem(
                        icon = R.drawable.dark_mode,
                        title = stringResource(R.string.dark_mode),
                        onState = { switchState },
                        onCheckChange = viewModel::onCheckChange
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
                    ) {
                        navController.navigate(HELP_CENTER_MAIN)
                    }

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
                    ) {
                        isLogoutSheetOpen = true
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                }
            }

            if (isSheetOpen) {
                QRCodeBottomSheet(
                    coroutineScope = coroutineScope,
                    bottomSheetState = bottomSheetState,
                    isFullScreen = false,
                    cornerRadius = DpDimensions.Dp20
                ) { isSheetOpen = false }
            }

            if (isLogoutSheetOpen) {
                LogoutConfirmationBottomSheet(
                    bottomSheetState = bottomSheetState,
                    onDismiss = { isLogoutSheetOpen = false },
                    onLogout = {
                        navController.navigate(NavDestinations.Auth.AUTH) {
                            popUpTo(NavDestinations.MAIN) {
                                inclusive = false
                            }
                        }.also {
                            signInViewModel.saveIsLoggedIn(false)
                        }
                    },
                    onCancel = {
                        isLogoutSheetOpen = false
                    }
                )
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