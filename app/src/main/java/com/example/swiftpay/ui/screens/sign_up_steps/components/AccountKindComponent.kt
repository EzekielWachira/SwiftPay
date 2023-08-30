package com.example.swiftpay.ui.screens.sign_up_steps.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.swiftpay.R
import com.example.swiftpay.ui.theme.SwiftPayTheme

@Composable
fun AccountKindComponent(
    modifier: Modifier = Modifier,
    onPersonalAccountClicked: () -> Unit,
    onBusinessAccountClicked: () -> Unit
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .padding(top = 10.dp)
            .scrollable(scrollState, Orientation.Vertical)
    ) {
        Text(
            text = stringResource(id = R.string.account_kind),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.inversePrimary,
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = stringResource(R.string.add_account_later),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.inversePrimary
        )

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .border(1.dp, MaterialTheme.colorScheme.inverseSurface, CircleShape)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.personal_account),
                    contentDescription = "Business icon",
                    modifier = Modifier.size(20.dp),
                    tint = MaterialTheme.colorScheme.inversePrimary
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp, end = 10.dp)
            ) {
                Text(
                    text = stringResource(R.string.personal_account),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.inversePrimary
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = stringResource(R.string.shop_send_receive),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.inversePrimary
                )

            }

            IconButton(onClick = { onPersonalAccountClicked() }) {
                Icon(
                    painter = painterResource(id = R.drawable.chevron_right),
                    contentDescription = "right arrow",
                    modifier = Modifier.size(20.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .border(1.dp, MaterialTheme.colorScheme.inverseSurface, CircleShape)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.business),
                    contentDescription = "Business icon",
                    modifier = Modifier.size(20.dp),
                    tint = MaterialTheme.colorScheme.inversePrimary
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp, end = 10.dp)
            ) {
                Text(
                    text = stringResource(R.string.business_account),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.inversePrimary
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = stringResource(R.string.grow_your_business),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.inversePrimary
                )

            }

            IconButton(onClick = { onBusinessAccountClicked() }) {
                Icon(
                    painter = painterResource(id = R.drawable.chevron_right),
                    contentDescription = "right arrow",
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun AccountKindComponentPreview() {
    SwiftPayTheme {
        AccountKindComponent(
            onPersonalAccountClicked = { },
            onBusinessAccountClicked = { }, modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(10.dp)
        )
    }
}