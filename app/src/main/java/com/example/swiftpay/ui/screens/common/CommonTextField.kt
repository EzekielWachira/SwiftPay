package com.example.swiftpay.ui.screens.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.swiftpay.R
import com.example.swiftpay.ui.screens.sign_in.SignInViewModel
import com.example.swiftpay.ui.screens.sign_in.state.EmailPasswordState
import com.example.swiftpay.ui.theme.SwiftPayTheme

@Composable
fun CommonTextField(
    modifier: Modifier = Modifier,
    text: String,
    placeholder: String,
    onTextChange: (String) -> Unit
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
            TextField(
                value = text, onValueChange = { value ->
                    onTextChange(value)
                },
                placeholder = {
                    Text(
                        text = placeholder,
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
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                textStyle = MaterialTheme.typography.bodySmall
            )
        }
    }
}


@Preview
@Composable
fun CommonTextFieldPreview() {
    SwiftPayTheme {
        CommonTextField(modifier = Modifier.fillMaxWidth(),
            text = "",
            placeholder = "Name",
            onTextChange ={})
    }
}