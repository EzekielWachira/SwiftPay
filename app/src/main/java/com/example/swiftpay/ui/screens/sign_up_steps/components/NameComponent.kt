package com.example.swiftpay.ui.screens.sign_up_steps.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.swiftpay.R
import com.example.swiftpay.ui.screens.sign_up_steps.state.NameState
import com.example.swiftpay.ui.theme.Green54
import com.example.swiftpay.ui.theme.SwiftPayTheme


@Composable
fun NameComponent(
    modifier: Modifier = Modifier,
    nameState: NameState,
    onNameEntered: (String) -> Unit,
    onButtonClicked: () -> Unit
) {
    Column(
        modifier = modifier
    ) {

        Column(
            modifier = Modifier.weight(1f).padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = stringResource(id = R.string.what_is_your_name),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.inversePrimary,
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = stringResource(R.string.enter_full_name),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.inversePrimary
            )

            Spacer(modifier = Modifier.height(25.dp))

            EmailSection(state = nameState, onNameEntered = onNameEntered)
        }

        BottomButtonSection(
            text = stringResource(id = R.string.continue_),
            nameState = nameState,
            onButtonClick = { onButtonClicked() }
        )

    }
}


@Preview
@Composable
fun NameComponentPreview() {
    SwiftPayTheme {
        NameComponent(
            modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
            nameState = NameState(),
            onNameEntered = {},
            onButtonClicked = {}
        )
    }
}

@Composable
fun BottomButtonSection(
    modifier: Modifier = Modifier,
    text: String,
    nameState: NameState,
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
                onClick = { onButtonClick() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary,
                    disabledContainerColor = Green54
                ),
                enabled = nameState.name.isNotBlank()
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
fun EmailSection(
    modifier: Modifier = Modifier,
    state: NameState,
    onNameEntered: (String) -> Unit
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = R.string.full_name),
            color = MaterialTheme.colorScheme.inversePrimary,
            style = MaterialTheme.typography.labelMedium
        )

        Spacer(modifier = Modifier.height(10.dp))

        EnterNameSection(state = state, onNameEntered = onNameEntered)
    }
}

@Composable
fun EnterNameSection(
    modifier: Modifier = Modifier,
    state: NameState,
    onNameEntered: (String) -> Unit
) {
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
                painter = painterResource(id = R.drawable.account),
                contentDescription = "name icon",
                modifier = Modifier.size(
                    24.dp
                )
            )

            TextField(
                value = state.name, onValueChange = { value ->
                    onNameEntered(value)
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.name),
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