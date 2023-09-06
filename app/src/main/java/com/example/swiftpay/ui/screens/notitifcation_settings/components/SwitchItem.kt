package com.example.swiftpay.ui.screens.notitifcation_settings.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.swiftpay.ui.theme.DpDimensions
import com.example.swiftpay.ui.theme.Green67_A
import com.example.swiftpay.ui.theme.Grey62

@Composable
fun SwitchItem(
    modifier: Modifier = Modifier,
    onCheckChange: (Boolean) -> Unit,
    isChecked: () -> Boolean,
    text: String,
) {

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = DpDimensions.Small),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.inversePrimary,
                modifier = Modifier.weight(1f)
            )

            Switch(
                checked = isChecked(),
                onCheckedChange = { isChecked -> onCheckChange(isChecked) },
                colors = SwitchDefaults.colors(
                    uncheckedThumbColor = MaterialTheme.colorScheme.secondaryContainer,
//                    checkedThumbColor = MaterialTheme.colorScheme.onPrimary,
                    checkedTrackColor = Green67_A,
                    checkedBorderColor = Grey62
                )
            )

        }
    }

}