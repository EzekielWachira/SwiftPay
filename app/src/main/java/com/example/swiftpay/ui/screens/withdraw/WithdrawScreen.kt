package com.example.swiftpay.ui.screens.withdraw

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.swiftpay.R
import com.example.swiftpay.ui.navigation.NavDestinations
import com.example.swiftpay.ui.navigation.NavDestinations.Withdraw.WITHDRAW_TO
import com.example.swiftpay.ui.navigation.Screen
import com.example.swiftpay.ui.screens.amount.AmountViewModel
import com.example.swiftpay.ui.screens.amount.components.NumberPad
import com.example.swiftpay.ui.screens.common.AppBarWithTwoActions
import com.example.swiftpay.ui.theme.BlueGrey11
import com.example.swiftpay.ui.theme.DpDimensions
import com.example.swiftpay.ui.theme.Green54
import com.example.swiftpay.ui.theme.Green67
import com.example.swiftpay.ui.theme.SwiftPayTheme
import com.example.swiftpay.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun WithdrawScreen(navController: NavController) {

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()


    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Green67,
            darkIcons = true
        )

        systemUiController.setNavigationBarColor(
            color = if (useDarkIcons)
                White else BlueGrey11,
            darkIcons = useDarkIcons
        )
    }

    val viewModel: AmountViewModel = hiltViewModel()
    val amountState by viewModel.amountState.collectAsStateWithLifecycle()


    Scaffold(
        topBar = {
            AppBarWithTwoActions(
                onLeftButtonClick = { navController.popBackStack() },
                onRightButtonClick = { },
                rightIcon = Icons.Outlined.ArrowBack,
                leftIcon = Icons.Outlined.ArrowBack,
                toolbarTitle = stringResource(id = R.string.amount_to_withdraw),
                isRightIconVisible = false,
                modifier = Modifier.background(MaterialTheme.colorScheme.onPrimary),
                textColor = Color.Black,
                iconColor = Color.Black
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
                    .background(MaterialTheme.colorScheme.onPrimary)
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = if (amountState.amount.isEmpty()) amountState.amount else stringResource(
                        id = R.string.amount,
                        amountState.amount.toFloat()
                    ),
                    onValueChange = { },
                    placeholder = {
                        Text(
                            text = "0.00",
                            fontSize = 50.sp,
                            fontFamily = FontFamily(
                                Font(
                                    R.font.poppins_semibold,
                                    FontWeight.SemiBold
                                )
                            ),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth(),
                            color = Color.Black
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        cursorColor = Color.Black
                    ),
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    textStyle = LocalTextStyle.current.copy(
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold, FontWeight.SemiBold)),
                        fontSize = 50.sp,
                        color = Color.Black
                    ),
                    readOnly = true
                )
                Text(
                    text = "Available balance: $7,378.00",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Black
                )
            }

            Column(
                modifier = Modifier.padding(DpDimensions.Normal)
            ) {

                Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                Button(
                    onClick = {
                        navController.navigate(WITHDRAW_TO)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.onPrimary,
                        disabledContainerColor = Green54
                    ),
                    enabled = amountState.amount.isNotEmpty() && amountState.amount.toFloat() > 0
                ) {

                    Text(
                        text = stringResource(id = R.string.continue_),
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }

                Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                NumberPad(onNumberClick = viewModel::onAmountChange, onDeleteAction = {
                    viewModel.onDelete(amountState.amount)
                }, state = { amountState }
                )
            }
        }

    }

}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun WithdrawScreenPreview() {
    SwiftPayTheme {
        WithdrawScreen(rememberNavController())
    }
}