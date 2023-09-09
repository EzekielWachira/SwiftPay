package com.example.swiftpay.ui.screens.send_now

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.swiftpay.R
import com.example.swiftpay.ui.screens.common.AppBarWithTwoActions
import com.example.swiftpay.ui.screens.send_now.components.AccountDetailsComponent
import com.example.swiftpay.ui.screens.send_now.components.AmountComponent
import com.example.swiftpay.ui.screens.send_now.components.NoteComponent
import com.example.swiftpay.ui.theme.BlueGrey11
import com.example.swiftpay.ui.theme.DpDimensions
import com.example.swiftpay.ui.theme.SwiftPayTheme
import com.example.swiftpay.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SendNowScreen(navController: NavController) {

    val viewModel: SendNowViewModel = hiltViewModel()
    val state by viewModel.sendMoneyState.collectAsStateWithLifecycle()

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
                toolbarTitle = stringResource(id = R.string.send_now),
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
                    text = stringResource(R.string.recipient),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.inversePrimary,
                )

                Spacer(modifier = Modifier.height(DpDimensions.Small))

                AccountDetailsComponent(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { },
                    horizontalPadding = 0.dp
                )

                Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                Text(
                    text = stringResource(R.string.amount_to_send),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.inversePrimary,
                )
                Spacer(modifier = Modifier.height(DpDimensions.Small))
                AmountComponent(state = state, onAmountChange = viewModel::onAmountChange)
                Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                Text(
                    text = stringResource(R.string.add_notes),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.inversePrimary,
                )
                Spacer(modifier = Modifier.height(DpDimensions.Small))

                NoteComponent(state = state, onNoteChange = viewModel::onNoteChange)

            }


            Column(modifier = Modifier.fillMaxWidth()) {
                Divider(color = MaterialTheme.colorScheme.inverseSurface)
                Spacer(modifier = Modifier.height(DpDimensions.Small))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 16.dp,
                            end = 16.dp,
                            top = 16.dp,
                            bottom = 20.dp
                        )
                ) {
                    OutlinedButton(
                        onClick = { },
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onPrimary)
                    ) {
                        Text(
                            text = stringResource(id = R.string.cancel),
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onSecondary
                        )
                    }

//                                Spacer(modifier = modifier.width(10.dp))

                    Button(
                        onClick = {

                        },
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.onPrimary
                        )
                    ) {
                        Text(
                            text = stringResource(id = R.string.send_money_2),
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onBackground,
                        )
                    }
                }
            }


        }

    }

}

@Preview
@Composable
fun SendNowScreenPreview() {
    SwiftPayTheme {
        SendNowScreen(rememberNavController())
    }
}