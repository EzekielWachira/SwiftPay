package com.example.swiftpay.ui.screens.sign_in

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
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
import com.example.swiftpay.ui.navigation.NavDestinations
import com.example.swiftpay.ui.navigation.NavDestinations.Auth.CREATE_ACCOUNT
import com.example.swiftpay.ui.navigation.NavDestinations.Auth.FORGOT_PASSWORD
import com.example.swiftpay.ui.screens.common.AppBar
import com.example.swiftpay.ui.screens.common.BottomButtonSection
import com.example.swiftpay.ui.screens.common.EmailSection
import com.example.swiftpay.ui.screens.common.PasswordSection
import com.example.swiftpay.ui.screens.common.SwitchComponent
import com.example.swiftpay.ui.theme.BlueGrey11
import com.example.swiftpay.ui.theme.SwiftPayTheme
import com.example.swiftpay.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SignInScreen(navController: NavController) {

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = if (useDarkIcons)
                White else BlueGrey11,
            darkIcons = useDarkIcons
        )
    }

    val viewModel: SignInViewModel = hiltViewModel()

    val emailPasswordState by viewModel.emailPasswordState.collectAsStateWithLifecycle()
    val switchState by viewModel.switchState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = { AppBar(modifier = Modifier.fillMaxWidth()) { navController.popBackStack() } }
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
                    text = stringResource(id = R.string.welcome_back),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    fontSize = 30.sp
                )

                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = stringResource(R.string.please_enter_your_email),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.inversePrimary
                )

                Spacer(modifier = Modifier.height(40.dp))

                EmailSection(state = emailPasswordState)

                Spacer(modifier = Modifier.height(15.dp))

                PasswordSection(state = emailPasswordState)

                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SwitchComponent(
                        label = stringResource(R.string.remember_me),
                        switchState = switchState,
                        modifier = Modifier.weight(1f)
                    )

                    TextButton(onClick = { navController.navigate(FORGOT_PASSWORD) }) {
                        Text(
                            text = stringResource(R.string.forgot_password),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.inversePrimary
                        )
                    }
                }

                Spacer(modifier = Modifier.height(15.dp))

                Divider(color = MaterialTheme.colorScheme.inverseSurface)

                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(R.string.don_t_have_an_account),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.inversePrimary
                    )

                    TextButton(onClick = { navController.navigate(CREATE_ACCOUNT) }) {
                        Text(
                            text = stringResource(id = R.string.sign_up),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.inversePrimary
                        )
                    }
                }

            }

            BottomButtonSection(
                text = stringResource(id = R.string.sign_in),
                emailPasswordState = emailPasswordState,
                switchState = switchState,
                modifier = Modifier.fillMaxWidth(),
                onButtonClick = {
                    navController.navigate(NavDestinations.MAIN_APP) {
                        popUpTo(NavDestinations.Auth.AUTH_MAIN) {
                            inclusive = false
                        }
                    }.also {
                        viewModel.saveIsLoggedIn(true)
                    }
                }
            )

        }
    }

}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SignInScreenPreview() {
    SwiftPayTheme {
        SignInScreen(rememberNavController())
    }
}