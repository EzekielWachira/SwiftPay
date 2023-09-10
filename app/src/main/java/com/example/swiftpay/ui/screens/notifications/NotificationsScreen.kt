package com.example.swiftpay.ui.screens.notifications

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Settings
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
import com.example.swiftpay.ui.navigation.NavDestinations.NotificationSettings.NOTIFICATION_SETTINGS_SCREEN
import com.example.swiftpay.ui.screens.common.AppBarWithTwoActions
import com.example.swiftpay.ui.screens.home.components.TransactionsStickyHeader
import com.example.swiftpay.ui.screens.notifications.components.NotificationItem
import com.example.swiftpay.ui.screens.notifications.components.notifications
import com.example.swiftpay.ui.theme.BlueGrey11
import com.example.swiftpay.ui.theme.DpDimensions
import com.example.swiftpay.ui.theme.SwiftPayTheme
import com.example.swiftpay.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NotificationsScreen(navController: NavController) {

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
            AppBarWithTwoActions(
                onLeftButtonClick = { navController.popBackStack() },
                onRightButtonClick = { navController.navigate(NOTIFICATION_SETTINGS_SCREEN) },
                rightIcon = Icons.Outlined.Settings,
                leftIcon = Icons.Outlined.ArrowBack,
                toolbarTitle = stringResource(id = R.string.notification),
                isRightIconVisible = true
            )
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(horizontal = DpDimensions.Smallest)
        ) {

            item { 
                Spacer(modifier = Modifier.height(DpDimensions.Normal))
            }

            notifications.groupBy { it.date }.forEach { (date, notifications) ->
                stickyHeader {
                    Column {
                        Spacer(modifier = Modifier.height(DpDimensions.Normal))
                        TransactionsStickyHeader(
                            text = date, modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp, end = 16.dp)
                        )
                        Spacer(modifier = Modifier.height(DpDimensions.Normal))
                    }
                }

                itemsIndexed(notifications, key = { id, notif -> "$id ${notif.title}" }) { index, notification ->
                    NotificationItem(notification = notification, onNotificationClick = {},
                        modifier = Modifier.fillMaxWidth())
                }
            }
            
        }

    }

}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun NotificationsScreenPreview() {
    SwiftPayTheme {
        NotificationsScreen(rememberNavController())
    }
}