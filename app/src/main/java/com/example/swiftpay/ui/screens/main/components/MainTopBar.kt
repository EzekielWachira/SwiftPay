package com.example.swiftpay.ui.screens.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.swiftpay.R
import com.example.swiftpay.ui.theme.SwiftPayTheme

@Composable
fun MainTopBar(
    modifier: Modifier = Modifier,
    onNotificationClick: () -> Unit,
    onLogoClick: () -> Unit
) {

    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.onPrimary
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 10.dp)
                .fillMaxWidth()
        ) {
            IconButton(onClick = { onLogoClick() }) {
                Image(
                    painter = painterResource(id = R.drawable.pay_logo_dark),
                    contentDescription = "pay logo",
                    modifier = Modifier.size(30.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black, modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )

            Box(
               contentAlignment = Alignment.BottomCenter
            ) {


                IconButton(onClick = { onNotificationClick() }) {
                    Image(
                        painter = painterResource(id = R.drawable.notification),
                        contentDescription = "notification logo",
                        modifier = Modifier.size(30.dp)
                    )
                }
            }

        }
    }
}

@Preview
@Composable
fun MainTopBarPreview() {
    SwiftPayTheme {
        MainTopBar(onNotificationClick = { }, onLogoClick = {})
    }
}