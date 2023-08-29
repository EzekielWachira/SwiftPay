package com.example.swiftpay.ui.screens.otp.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.swiftpay.R
import com.example.swiftpay.ui.screens.otp.state.OtpState

@Composable
fun OtpView(modifier: Modifier = Modifier, otpState: OtpState) {
    Surface(
        color = MaterialTheme.colorScheme.secondaryContainer,
        shape = RoundedCornerShape(10.dp),
        modifier = modifier.height(60.dp)
            .padding(16.dp)
    ) {
        TextField(
            value = otpState.value, onValueChange = { value ->
//                signInViewModel.onEmailTextEntered(value)
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