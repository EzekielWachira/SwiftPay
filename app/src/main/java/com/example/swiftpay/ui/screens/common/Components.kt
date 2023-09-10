package com.example.swiftpay.ui.screens.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.swiftpay.R
import com.example.swiftpay.ui.screens.sign_in.SignInViewModel
import com.example.swiftpay.ui.screens.sign_in.state.EmailPasswordState
import com.example.swiftpay.ui.screens.sign_in.state.SwitchState
import com.example.swiftpay.ui.theme.Green54
import com.example.swiftpay.ui.theme.SwiftPayTheme

@Composable
fun AppBar(modifier: Modifier = Modifier, onBackClicked: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(
                all = 16.dp
            )
    ) {

        IconButton(onClick = { onBackClicked() }) {
            Icon(
                imageVector = Icons.Filled.ArrowBack, contentDescription = "Back arrow",
                tint = MaterialTheme.colorScheme.inversePrimary
            )
        }

    }
}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun AppBarPreview() {
    SwiftPayTheme {
        AppBar {}
    }
}


@Composable
fun BottomButtonSection(modifier: Modifier = Modifier, text: String, emailPasswordState: EmailPasswordState, switchState: SwitchState, onButtonClick: () -> Unit) {
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
                onClick = { onButtonClick() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary,
                    disabledContainerColor = Green54
                ),
                enabled = emailPasswordState.isValidEmail && emailPasswordState.isValidPassword && switchState.isChecked
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

@Preview
@Composable
fun BottomButtonSectionPreview() {
    SwiftPayTheme {
        BottomButtonSection(text = "Sign in", emailPasswordState = EmailPasswordState(), switchState = SwitchState()) {}
    }
}

@Composable
fun EmailSection(
    modifier: Modifier = Modifier,
    state: EmailPasswordState,
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = R.string.email),
            color = MaterialTheme.colorScheme.inversePrimary,
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(10.dp))

        EnterEmailUserName(state = state)
    }
}

@Composable
fun EnterEmailUserName(
    modifier: Modifier = Modifier,
    state: EmailPasswordState,
    signInViewModel: SignInViewModel = hiltViewModel()
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
                    signInViewModel.onEmailTextEntered(value)
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
                textStyle = MaterialTheme.typography.bodyMedium
            )
        }
    }
}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun EmailSectionPreview() {
    SwiftPayTheme {
        EmailSection(state = EmailPasswordState(), modifier = Modifier.fillMaxWidth())
    }
}


@Composable
fun PasswordSection(
    modifier: Modifier = Modifier,
    state: EmailPasswordState,
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = R.string.password),
            color = MaterialTheme.colorScheme.inversePrimary,
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(10.dp))

        EnterPassword(
            state = state,
            modifier = modifier
        )
    }
}


@Composable
fun EnterPassword(
    modifier: Modifier = Modifier,
    state: EmailPasswordState,
    signInViewModel: SignInViewModel = hiltViewModel()
) {

    var isPasswordVisible by rememberSaveable {
        mutableStateOf(false)
    }

//    val state by viewModel.passwordInputState.collectAsState()

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
                painter = painterResource(id = R.drawable.lock),
                contentDescription = "password icon",
                modifier = Modifier.size(
                    24.dp
                )
            )

            TextField(
                value = state.password, onValueChange = { password ->
                    signInViewModel.onPasswordEntered(password)
                },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.password),
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
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val toggleIcon = if (isPasswordVisible)
                        painterResource(id = R.drawable.visibility)
                    else painterResource(id = R.drawable.visibility_off)

                    IconButton(
                        onClick = { isPasswordVisible = !isPasswordVisible },
                    ) {
                        Icon(
                            painter = toggleIcon, contentDescription = "",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                },
                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                singleLine = true,
                textStyle = MaterialTheme.typography.bodyMedium
            )
        }
    }
}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PasswordSectionPreview() {
    SwiftPayTheme {
        PasswordSection(state = EmailPasswordState(), modifier = Modifier.fillMaxWidth())
    }
}


@Composable
fun SwitchComponent(
    modifier: Modifier = Modifier,
    label: String,
    switchState: SwitchState,
    viewModel: SignInViewModel = hiltViewModel()
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Checkbox(
            checked = switchState.isChecked,
            onCheckedChange = { isChecked ->
                viewModel.onSwitchChecked(isChecked)
            },
            colors = CheckboxDefaults.colors(
                checkedColor = MaterialTheme.colorScheme.primary,
                uncheckedColor = MaterialTheme.colorScheme.primary,
                checkmarkColor =  MaterialTheme.colorScheme.inversePrimary
            )
        )

        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.inversePrimary,
            modifier = Modifier.weight(1f)
        )

    }
}

@Preview
@Composable
fun SwitchComponentPreview() {
    SwiftPayTheme {
        SwitchComponent(label = "Remember me", switchState = SwitchState())
    }
}
