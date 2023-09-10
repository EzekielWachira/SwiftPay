package com.example.swiftpay.ui.screens.reset_password.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.swiftpay.R
import com.example.swiftpay.ui.screens.reset_password.state.EmailState
import com.example.swiftpay.ui.screens.reset_password.ResetPasswordViewModel
import com.example.swiftpay.ui.theme.Green54

@Composable
fun ResetPasswordBottomButtonSection(
    modifier: Modifier = Modifier,
    text: String,
    emailState: EmailState,
    onButtonClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {

        Divider(color = MaterialTheme.colorScheme.inverseSurface)

        Box(
            modifier = modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = 30.dp
                )
        ) {

            Button(
                onClick = { onButtonClick },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary,
                    disabledContainerColor = Green54
                ),
                enabled = emailState.isValidEmail
            ) {

                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}


@Composable
fun ResetPasswordEmailSection(
    modifier: Modifier = Modifier,
    state: EmailState,
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = R.string.email),
            color = MaterialTheme.colorScheme.inversePrimary,
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(10.dp))

        EnterEmailSection(state = state)
    }
}

@Composable
fun EnterEmailSection(
    modifier: Modifier = Modifier,
    state: EmailState,
    resetPasswordViewModel: ResetPasswordViewModel = hiltViewModel()
) {

//    val emailState by signInViewModel.emailPasswordState.collectAsState()

    Surface(
        color = MaterialTheme.colorScheme.secondaryContainer,
        shape = RoundedCornerShape(10.dp),
        modifier = modifier.height(60.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 10.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.email), contentDescription = "Email icon",
                modifier = Modifier.size(
                    24.dp
                )
            )

            TextField(
                value = state.email, onValueChange = { value ->
                    resetPasswordViewModel.onEmailEntered(value)
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.email),
                        style = MaterialTheme.typography.bodyMedium
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    cursorColor = MaterialTheme.colorScheme.inversePrimary
                ),
                modifier = Modifier.weight(1f),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                textStyle = MaterialTheme.typography.bodySmall
            )
        }
    }
}