package com.example.swiftpay.ui.screens.top_up.select

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.swiftpay.R
import com.example.swiftpay.ui.navigation.NavDestinations
import com.example.swiftpay.ui.navigation.NavDestinations.AddPayment.ADD_PAYMENT_MAIN
import com.example.swiftpay.ui.navigation.NavDestinations.TopUp.SELECT_TOP_UP
import com.example.swiftpay.ui.navigation.NavDestinations.TopUp.TOP_UP_NOW
import com.example.swiftpay.ui.screens.common.AppBarWithTwoActions
import com.example.swiftpay.ui.screens.payment_methods.components.paymentMethods
import com.example.swiftpay.ui.screens.withdraw.withdraw_to.components.PaymentMethodItem
import com.example.swiftpay.ui.theme.BlueGrey11
import com.example.swiftpay.ui.theme.DpDimensions
import com.example.swiftpay.ui.theme.Green54
import com.example.swiftpay.ui.theme.SwiftPayTheme
import com.example.swiftpay.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SelectTopUpScreen(navController: NavController) {

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
                onRightButtonClick = { navController.navigate(ADD_PAYMENT_MAIN) },
                rightIcon = Icons.Outlined.Add,
                leftIcon = Icons.Outlined.ArrowBack,
                toolbarTitle = stringResource(id = R.string.select_top_up_method),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.background),
                isRightIconVisible = true
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = DpDimensions.Normal, vertical = DpDimensions.Small)
                    .weight(1f)
                ,
                verticalArrangement = Arrangement.spacedBy(DpDimensions.Small)
            ) {

                items(paymentMethods, key = { it.name }) { paymentMethod ->
                    PaymentMethodItem(
                        paymentMethod = paymentMethod, onPaymentMethodClick = {},
                        modifier = Modifier.fillMaxWidth()
                    )
                }

            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {

                Divider(color = MaterialTheme.colorScheme.inverseSurface)

                Box(
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            end = 16.dp,
                            top = 16.dp,
                            bottom = 30.dp
                        )
                ) {

                    Button(
                        onClick = { navController.navigate(TOP_UP_NOW)  },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.onPrimary,
                            disabledContainerColor = Green54
                        ),
                        enabled = true
                    ) {

                        Text(
                            text = stringResource(id = R.string.continue_),
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
            }
        }
    }

}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SelectTopUpScreenPreview() {
    SwiftPayTheme {
        SelectTopUpScreen(rememberNavController())
    }
}