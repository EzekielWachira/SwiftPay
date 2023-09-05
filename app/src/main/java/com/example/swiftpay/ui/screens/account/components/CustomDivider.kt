package com.example.swiftpay.ui.screens.account.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomDivider(
    modifier: Modifier = Modifier,
    text: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Text(
            text = text, style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.inversePrimary
        )

        Spacer(modifier = Modifier.width(16.dp))

        Divider(modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.inverseSurface)

    }

}