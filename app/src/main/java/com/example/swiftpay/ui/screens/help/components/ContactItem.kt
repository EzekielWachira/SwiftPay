package com.example.swiftpay.ui.screens.help.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.swiftpay.R
import com.example.swiftpay.ui.theme.DpDimensions

@Composable
fun ContactItem(
    modifier: Modifier = Modifier,
    title: String,
    @DrawableRes icon: Int,
    onClick: () -> Unit
) {

    Surface(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp),
        border = BorderStroke(
            1.dp,
            MaterialTheme.colorScheme.inverseSurface
        ),
        onClick = { onClick() },
        color = MaterialTheme.colorScheme.secondaryContainer,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
                top = 10.dp,
                bottom = 10.dp
            )
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier
                    .size(DpDimensions.Dp20)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = title, style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.inversePrimary,
                modifier = Modifier.weight(1f)
            )

            Icon(
                painter = painterResource(id = R.drawable.chevron_right),
                contentDescription = "Done Icon",
                modifier = Modifier.size(20.dp)
            )
        }
    }

}