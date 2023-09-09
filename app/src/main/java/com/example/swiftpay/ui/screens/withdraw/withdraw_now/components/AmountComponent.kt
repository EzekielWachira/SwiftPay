package com.example.swiftpay.ui.screens.withdraw.withdraw_now.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.swiftpay.R
import com.example.swiftpay.ui.screens.send_now.state.SendMoneyState
import com.example.swiftpay.ui.theme.SwiftPayTheme
import com.example.swiftpay.ui.screens.withdraw.withdraw_now.state.WithdrawState

@Composable
fun AmountComponent(
    modifier: Modifier = Modifier,
    state: WithdrawState,
    onAmountChange: (String) -> Unit
) {

    Box(modifier = modifier
        .clip(RoundedCornerShape(10.dp))
        .background(MaterialTheme.colorScheme.secondaryContainer, RoundedCornerShape(10.dp))
        .height(70.dp),
        contentAlignment = Alignment.Center) {

        TextField(
            value =state.amount,
            onValueChange = { value ->
                onAmountChange(value)
            },
            placeholder = {
                Text(
                    text = "0.0",
                    fontFamily = FontFamily(Font(R.font.poppins_semibold, FontWeight.SemiBold)),
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.inversePrimary
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
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            textStyle = LocalTextStyle.current.copy(
                textAlign = TextAlign.Start,
                fontFamily = FontFamily(Font(R.font.poppins_semibold, FontWeight.SemiBold)),
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.inversePrimary
            )
        )

    }

}


@Preview
@Composable
fun AmountComponentPreview() {
    SwiftPayTheme {
        AmountComponent(state = WithdrawState(), onAmountChange = {})
    }
}