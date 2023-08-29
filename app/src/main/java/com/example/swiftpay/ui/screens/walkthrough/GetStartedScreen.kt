package com.example.swiftpay.ui.screens.walkthrough

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.swiftpay.R
import com.example.swiftpay.ui.theme.BlueGrey11
import com.example.swiftpay.ui.theme.SwiftPayTheme
import com.example.swiftpay.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun GetStartedScreen() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()
    val navController = rememberNavController()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = if (useDarkIcons)
                White else BlueGrey11,
            darkIcons = useDarkIcons
        )
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            MiddleContent(
                Modifier
                    .weight(1f)
                    .padding(32.dp))
            BottomButtons(onSignInClick = { }, onSignUpClick = { })

        }

    }
}

@Preview
@Composable
fun GetStartedScreenPreview() {
    SwiftPayTheme {
        GetStartedScreen()
    }
}

@Composable
fun MiddleContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.pay_logo),
            contentDescription = "Pay logo",
            modifier = Modifier.size(150.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(id = R.string.get_started_desc),
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSecondary,
            fontSize = 30.sp,
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(id = R.string.with_swift_pay),
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.onSecondary,
            textAlign = TextAlign.Center
        )


    }
}

@Composable
fun BottomButtons(
    modifier: Modifier = Modifier,
    onSignInClick: () -> Unit,
    onSignUpClick: () -> Unit
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Divider(color = MaterialTheme.colorScheme.inverseSurface)

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = 30.dp
                )
        ) {

            OutlinedButton(
                onClick = { onSignUpClick },
                modifier = Modifier.weight(1f).height(50.dp),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.onPrimary)
            ) {
                Text(
                    text = stringResource(id = R.string.sign_up),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSecondary
                )
            }


            Button(
                onClick = { onSignInClick },
                modifier = Modifier.weight(1f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                Text(
                    text = stringResource(id = R.string.sign_in),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

        }
    }
}