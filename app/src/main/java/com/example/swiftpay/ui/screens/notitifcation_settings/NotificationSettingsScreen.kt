package com.example.swiftpay.ui.screens.notitifcation_settings

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.swiftpay.R
import com.example.swiftpay.ui.screens.account.components.CustomDivider
import com.example.swiftpay.ui.screens.common.AppBarWithTwoActions
import com.example.swiftpay.ui.screens.notitifcation_settings.components.SwitchItem
import com.example.swiftpay.ui.theme.BlueGrey11
import com.example.swiftpay.ui.theme.DpDimensions
import com.example.swiftpay.ui.theme.SwiftPayTheme
import com.example.swiftpay.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun NotificationSettingsScreen(navController: NavController) {

    val viewModel: NotificationSettingsViewModel = hiltViewModel()
    val notificationSettingsState by viewModel.notificationSettingsState.collectAsStateWithLifecycle()

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
                onRightButtonClick = { },
                rightIcon = Icons.Outlined.ArrowBack,
                leftIcon = Icons.Outlined.ArrowBack,
                toolbarTitle = stringResource(id = R.string.notification),
                isRightIconVisible = false
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = DpDimensions.Normal)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(DpDimensions.Small)
        ) {

            CustomDivider(
                text = stringResource(id = R.string.general),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = DpDimensions.Small)
            )

            SwitchItem(
                onCheckChange = viewModel::onStatusUpdate,
                isChecked = { notificationSettingsState.statusUpdate },
                text = stringResource(R.string.transactions_status_updates)
            )

            SwitchItem(
                onCheckChange = viewModel::onFraudAlert,
                isChecked = { notificationSettingsState.fraudAlert },
                text = stringResource(R.string.fraud_alert)
            )

            SwitchItem(
                onCheckChange = viewModel::onPaymentRequest,
                isChecked = { notificationSettingsState.paymentRequest },
                text = stringResource(R.string.payment_requests)
            )

            SwitchItem(
                onCheckChange = viewModel::onCardActivity,
                isChecked = { notificationSettingsState.cardActivity },
                text = stringResource(R.string.card_activity)
            )

            SwitchItem(
                onCheckChange = viewModel::onSupportNotifications,
                isChecked = { notificationSettingsState.supportNotifications },
                text = stringResource(R.string.customer_support)
            )

            SwitchItem(
                onCheckChange = viewModel::onAccountBalance,
                isChecked = { notificationSettingsState.accountBalance },
                text = stringResource(R.string.account_balance)
            )

            SwitchItem(
                onCheckChange = viewModel::onSecurityAlert,
                isChecked = { notificationSettingsState.securityAlert },
                text = stringResource(R.string.security_alert)
            )

            SwitchItem(
                onCheckChange = viewModel::onDailyWeeklySummary,
                isChecked = { notificationSettingsState.dailyWeeklySummary },
                text = stringResource(R.string.daily_weekly_summary)
            )

            Spacer(modifier = Modifier.height(DpDimensions.Smallest))

            CustomDivider(
                text = stringResource(id = R.string.general),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = DpDimensions.Small)
            )

            Spacer(modifier = Modifier.height(DpDimensions.Smallest))

            SwitchItem(
                onCheckChange = viewModel::onAppUpdates,
                isChecked = { notificationSettingsState.appUpdates },
                text = stringResource(R.string.app_updates)
            )

            SwitchItem(
                onCheckChange = viewModel::onPromotionalOffers,
                isChecked = { notificationSettingsState.promotionalOffers },
                text = stringResource(R.string.promotional_offers)
            )

            SwitchItem(
                onCheckChange = viewModel::onSurvey,
                isChecked = { notificationSettingsState.survey },
                text = stringResource(R.string.participate_servey)
            )
        }
    }
}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun NotificationSettingsScreenPreview() {
    SwiftPayTheme {
        NotificationSettingsScreen(rememberNavController())
    }
}