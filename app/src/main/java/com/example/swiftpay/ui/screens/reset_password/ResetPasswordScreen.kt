package com.example.swiftpay.ui.screens.reset_password

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.swiftpay.R
import com.example.swiftpay.ui.screens.common.AppBar
import com.example.swiftpay.ui.screens.reset_password.components.ResetPasswordBottomButtonSection
import com.example.swiftpay.ui.screens.reset_password.components.ResetPasswordEmailSection
import com.example.swiftpay.ui.theme.BlueGrey11
import com.example.swiftpay.ui.theme.SwiftPayTheme
import com.example.swiftpay.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ResetPasswordScreen(navController: NavController) {

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = if (useDarkIcons)
                White else BlueGrey11,
            darkIcons = useDarkIcons
        )
    }

    val resetPasswordViewModel: ResetPasswordViewModel = hiltViewModel()
    val emailState by resetPasswordViewModel.emailState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = { AppBar(modifier = Modifier.fillMaxWidth(), onBackClicked = { navController.popBackStack() }) }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 10.dp
                    )
                    .weight(1f)
            ) {

                Text(
                    text = stringResource(id = R.string.reset_password),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    fontSize = 30.sp
                )

                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = stringResource(R.string.enter_your_email),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.inversePrimary
                )

                Spacer(modifier = Modifier.height(40.dp))

                ResetPasswordEmailSection(state = emailState)

            }

            ResetPasswordBottomButtonSection(
                text = stringResource(id = R.string.continue_),
                emailState = emailState,
                modifier = Modifier.fillMaxWidth(),
                onButtonClick = { }
            )
        }
    }

}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ResetPasswordScreenPreview() {
    SwiftPayTheme {
        ResetPasswordScreen(rememberNavController())
    }
}