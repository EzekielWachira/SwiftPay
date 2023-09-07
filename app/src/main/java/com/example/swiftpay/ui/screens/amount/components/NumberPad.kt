package com.example.swiftpay.ui.screens.amount.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Backspace
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.swiftpay.ui.screens.amount.state.AmountState
import com.example.swiftpay.ui.theme.DpDimensions
import com.example.swiftpay.ui.theme.SwiftPayTheme

private const val TAG = "NumberPad"
@Composable
fun NumberPad(
    modifier: Modifier = Modifier,
    onNumberClick: (String) -> Unit,
    onDeleteAction: () -> Unit,
    state: () -> AmountState
) {

    Log.d(TAG, "NumberPad: ${state().amount}")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Spacer(modifier = Modifier.height(DpDimensions.Dp20))
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextButton(
                onClick = { onNumberClick("1") },
                modifier = Modifier
                    .weight(1f)
                    .height(60.dp)
            ) {
                Text(
                    text = "1",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.inversePrimary
                )
            }

            TextButton(
                onClick = { onNumberClick("2") },
                modifier = Modifier
                    .weight(1f)
                    .height(60.dp)
            ) {
                Text(
                    text = "2",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.inversePrimary
                )
            }

            TextButton(
                onClick = { onNumberClick("3") },
                modifier = Modifier
                    .weight(1f)
                    .height(60.dp)
            ) {
                Text(
                    text = "3",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.inversePrimary
                )
            }
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextButton(
                onClick = { onNumberClick("4") },
                modifier = Modifier
                    .weight(1f)
                    .height(60.dp)
            ) {
                Text(
                    text = "4",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.inversePrimary
                )
            }

            TextButton(
                onClick = { onNumberClick("5") },
                modifier = Modifier
                    .weight(1f)
                    .height(60.dp)
            ) {
                Text(
                    text = "5",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.inversePrimary
                )
            }

            TextButton(
                onClick = { onNumberClick("6") },
                modifier = Modifier
                    .weight(1f)
                    .height(60.dp)
            ) {
                Text(
                    text = "6",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.inversePrimary
                )
            }
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextButton(
                onClick = { onNumberClick("7") },
                modifier = Modifier
                    .weight(1f)
                    .height(60.dp)
            ) {
                Text(
                    text = "7",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.inversePrimary
                )
            }

            TextButton(
                onClick = { onNumberClick("8") },
                modifier = Modifier
                    .weight(1f)
                    .height(60.dp)
            ) {
                Text(
                    text = "8",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.inversePrimary
                )
            }

            TextButton(
                onClick = { onNumberClick("9") },
                modifier = Modifier
                    .weight(1f)
                    .height(60.dp)
            ) {
                Text(
                    text = "9",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.inversePrimary
                )
            }
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextButton(
                onClick = {
                    if (!state().amount.contains(".") ||
                        (state().amount.isNotEmpty() && state().amount.toFloat() > 0)
                    )
                        onNumberClick(".")
                },
                modifier = Modifier
                    .weight(1f)
                    .height(60.dp)
            ) {
                Text(
                    text = ".",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    fontWeight = FontWeight.ExtraBold
                )
            }

            TextButton(
                onClick = {
                    if (state().amount.isEmpty()) return@TextButton
                    else onNumberClick("0")
                },
                modifier = Modifier
                    .weight(1f)
                    .height(60.dp)
            ) {
                Text(
                    text = "0",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.inversePrimary
                )
            }

            IconButton(
                onClick = { onDeleteAction() },
                modifier = Modifier
                    .weight(1f)
                    .height(60.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Backspace,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(DpDimensions.Dp20))
    }


}

@Preview
@Composable
fun NumberPadPreview() {
    SwiftPayTheme {
        NumberPad(onNumberClick = {}, onDeleteAction = {}, state = { AmountState() })
    }
}


data class Number(
    val number: String,
    val key: Int = 1
)


