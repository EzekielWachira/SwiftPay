package com.example.swiftpay.ui.screens.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.swiftpay.R
import com.example.swiftpay.ui.theme.DpDimensions

@Composable
fun TwoButtons(
    leftButtonText: String,
    rightButtonText: String,
    onLeftButtonClick:() -> Unit,
    onRightButtonClick:() -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Divider(color = MaterialTheme.colorScheme.inverseSurface)
        Spacer(modifier = Modifier.height(DpDimensions.Small))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = 20.dp
                )
        ) {
            OutlinedButton(
                onClick = { onLeftButtonClick() },
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.onPrimary)
            ) {
                Text(
                    text = leftButtonText,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSecondary
                )
            }

//                                Spacer(modifier = modifier.width(10.dp))

            Button(
                onClick = {
onRightButtonClick()
                },
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                Text(
                    text = rightButtonText,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onBackground,
                )
            }
        }
    }
}