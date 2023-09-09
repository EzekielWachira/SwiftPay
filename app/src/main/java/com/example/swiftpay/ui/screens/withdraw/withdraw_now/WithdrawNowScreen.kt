package com.example.swiftpay.ui.screens.withdraw.withdraw_now

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import com.example.swiftpay.ui.navigation.NavDestinations.Withdraw.WITHDRAW_RECEIPT
import com.example.swiftpay.ui.screens.common.AppBarWithTwoActions
import com.example.swiftpay.ui.screens.common.TwoButtons
import com.example.swiftpay.ui.screens.payment_methods.components.paymentMethods
import com.example.swiftpay.ui.theme.BlueGrey11
import com.example.swiftpay.ui.theme.DpDimensions
import com.example.swiftpay.ui.theme.SwiftPayTheme
import com.example.swiftpay.ui.theme.White
import com.example.swiftpay.ui.screens.withdraw.withdraw_now.components.AmountComponent
import com.example.swiftpay.ui.screens.withdraw.withdraw_now.components.NoteComponent
import com.example.swiftpay.ui.screens.withdraw.withdraw_now.components.PaymentMethodItem
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun WithdrawNowScreen(navController: NavController) {

    val viewModel: WithdrawNowViewModel = hiltViewModel()
    val state by viewModel.withdraw.collectAsStateWithLifecycle()


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
                toolbarTitle = stringResource(id = R.string.withdraw_now),
                isRightIconVisible = false
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()

        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = DpDimensions.Normal)
            ) {

                Spacer(modifier = Modifier.height(DpDimensions.Normal))

                Text(
                    text = stringResource(R.string.amount_to_withdraw),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.inversePrimary,
                )
                Spacer(modifier = Modifier.height(DpDimensions.Small))
                AmountComponent(state = state, onAmountChange = viewModel::onAmountChange)
                Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                Text(
                    text = stringResource(R.string.withdraw_to),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.inversePrimary,
                )

                Spacer(modifier = Modifier.height(DpDimensions.Small))

                PaymentMethodItem(paymentMethod = paymentMethods[4], onPaymentMethodClick = {},
                    modifier = Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                Text(
                    text = stringResource(R.string.add_notes),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.inversePrimary,
                )
                Spacer(modifier = Modifier.height(DpDimensions.Small))

                NoteComponent(state = state, onNoteChange = viewModel::onNoteChange)


            }



            TwoButtons(
                leftButtonText = stringResource(R.string.cancel),
                rightButtonText = stringResource(R.string.confirm_withdraw),
                onLeftButtonClick = { navController.popBackStack() },
                onRightButtonClick = { navController.navigate(WITHDRAW_RECEIPT) })

        }


        }

}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun WithdrawNowScreenPreview() {
    SwiftPayTheme {
        WithdrawNowScreen(rememberNavController())
    }
}