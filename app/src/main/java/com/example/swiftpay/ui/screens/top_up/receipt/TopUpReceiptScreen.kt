package com.example.swiftpay.ui.screens.top_up.receipt

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.swiftpay.R
import com.example.swiftpay.ui.screens.common.AppBarWithTwoActions
import com.example.swiftpay.ui.screens.common.TwoButtons
import com.example.swiftpay.ui.screens.request_money_receipt.components.RequestMoneyReceiptDetails
import com.example.swiftpay.ui.screens.top_up.receipt.components.TopUpReceiptDetails
import com.example.swiftpay.ui.theme.BlueGrey11
import com.example.swiftpay.ui.theme.DpDimensions
import com.example.swiftpay.ui.theme.SwiftPayTheme
import com.example.swiftpay.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun TopUpReceiptScreen(navController: NavController) {


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
                rightIcon = Icons.Outlined.Close,
                leftIcon = Icons.Outlined.Close,
                toolbarTitle = "",
                isRightIconVisible = false
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = DpDimensions.Normal),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                Box(
                    modifier = Modifier
                        .border(
                            2.dp,
                            color = MaterialTheme.colorScheme.inversePrimary,
                            shape = CircleShape
                        )
                        .size(70.dp)
                        .background(MaterialTheme.colorScheme.onPrimary, CircleShape),
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        painter = painterResource(id = R.drawable.done), contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        tint = MaterialTheme.colorScheme.inversePrimary
                    )
                }

                Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                Text(text = "$ 1,000.00", style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    fontSize = 30.sp)

                Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                Text(
                    text = "You top up to SwiftPay Balance",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onTertiary
                )
                Spacer(modifier = Modifier.height(DpDimensions.Smallest))


                Text(
                    text = "Andrew Ainsley",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onTertiary
                )

                Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                TopUpReceiptDetails(modifier = Modifier.fillMaxWidth())
            }

            TwoButtons(
                leftButtonText = stringResource(R.string.download_receipt),
                rightButtonText = stringResource(R.string.share_receipt),
                onLeftButtonClick = { },
                onRightButtonClick = { })
        }
    }

}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun TopUpReceiptScreenPreview() {
    SwiftPayTheme {
        TopUpReceiptScreen(rememberNavController())
    }
}