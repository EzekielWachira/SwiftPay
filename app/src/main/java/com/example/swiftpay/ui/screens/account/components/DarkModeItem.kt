package com.example.swiftpay.ui.screens.account.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.swiftpay.R
import com.example.swiftpay.ui.screens.sign_in.state.SwitchState
import com.example.swiftpay.ui.theme.DpDimensions
import com.example.swiftpay.ui.theme.Green67_A
import com.example.swiftpay.ui.theme.Grey62

@Composable
fun DarkModeItem(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    title: String,
    switchState: SwitchState,
    onCheckChange: (Boolean) -> Unit
) {

    Surface(
        shape = RoundedCornerShape(DpDimensions.Small),
        color = MaterialTheme.colorScheme.background,
        modifier = modifier
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(
                horizontal = DpDimensions.Small,
                vertical = DpDimensions.Small
            )
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = MaterialTheme.colorScheme.inversePrimary
            )

            Text(
                text = title, style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.inversePrimary,
                modifier = Modifier
                    .padding(horizontal = DpDimensions.Normal)
                    .weight(1f)
            )

            Switch(
                checked = switchState.isChecked,
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