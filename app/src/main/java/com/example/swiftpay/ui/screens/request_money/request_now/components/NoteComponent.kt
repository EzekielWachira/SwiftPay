package com.example.swiftpay.ui.screens.request_money.request_now.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.swiftpay.R
import com.example.swiftpay.ui.screens.request_money.request_now.state.RequestState
import com.example.swiftpay.ui.screens.send_now.state.SendMoneyState
import com.example.swiftpay.ui.theme.SwiftPayTheme

@Composable
fun NoteComponent(
    modifier: Modifier = Modifier,
    state: RequestState,
    onNoteChange: (String) -> Unit
) {

    Box(modifier = modifier
        .clip(RoundedCornerShape(10.dp))
        .background(MaterialTheme.colorScheme.secondaryContainer, RoundedCornerShape(10.dp))
        .height(200.dp),
        contentAlignment = Alignment.TopCenter) {

        TextField(
            value = state.note, onValueChange = { value ->
                onNoteChange(value)
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.enter_note),
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
            modifier = Modifier.fillMaxSize(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            textStyle = MaterialTheme.typography.bodyMedium
        )

    }

}


@Preview
@Composable
fun NoteComponentPreview() {
    SwiftPayTheme {
       NoteComponent(
            state = RequestState(),
            onNoteChange = {})
    }
}