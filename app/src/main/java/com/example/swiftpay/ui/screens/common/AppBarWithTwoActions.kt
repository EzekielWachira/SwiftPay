package com.example.swiftpay.ui.screens.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.swiftpay.ui.theme.DpDimensions

@Composable
fun AppBarWithTwoActions(
    modifier: Modifier = Modifier,
    onLeftButtonClick: () -> Unit,
    onRightButtonClick: () -> Unit,
    @DrawableRes rightIcon: Int,
    @DrawableRes leftIcon: Int,
    toolbarTitle: String,
    isRightIconVisible: Boolean
) {

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(
                horizontal = DpDimensions.Normal,
                vertical = DpDimensions.Small
            )
        ) {

            IconButton(onClick = { onLeftButtonClick() }) {
                Icon(
                    painter = painterResource(id = leftIcon),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.inversePrimary
                )
            }

            Text(
                text = toolbarTitle,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.inversePrimary, modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
            )

            if (isRightIconVisible) {

                IconButton(onClick = { onRightButtonClick() }) {
                    Icon(
                        painter = painterResource(id = rightIcon),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.inversePrimary
                    )
                }
            } else {
                Spacer(modifier = Modifier.width(50.dp))
            }

        }

    }
}


@Composable
fun AppBarWithTwoActions(
    modifier: Modifier = Modifier,
    onLeftButtonClick: () -> Unit,
    onRightButtonClick: () -> Unit,
    rightIcon: ImageVector,
    leftIcon: ImageVector,
    toolbarTitle: String,
    isRightIconVisible: Boolean
) {

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(
                horizontal = DpDimensions.Normal,
                vertical = DpDimensions.Small
            )
        ) {

            IconButton(onClick = { onLeftButtonClick() }) {
                Icon(
                    imageVector = leftIcon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.inversePrimary
                )
            }

            Text(
                text = toolbarTitle,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.inversePrimary, modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
            )

            if (isRightIconVisible) {

                IconButton(onClick = { onRightButtonClick() }) {
                    Icon(
                        imageVector = rightIcon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.inversePrimary
                    )
                }
            } else {
                Spacer(modifier = Modifier.width(50.dp))
            }

        }

    }

}