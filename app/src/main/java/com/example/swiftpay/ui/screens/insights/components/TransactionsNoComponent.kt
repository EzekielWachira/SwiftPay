package com.example.swiftpay.ui.screens.insights.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.swiftpay.R
import com.example.swiftpay.ui.theme.DpDimensions
import com.example.swiftpay.ui.theme.SwiftPayTheme

class TransactionsNoComponent {
}

@Composable
fun TransactionsNoComponent(
    modifier: Modifier = Modifier
) {

    Surface(
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.inverseSurface,
        ),
        modifier = modifier,
        shape = RoundedCornerShape(DpDimensions.Small),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = DpDimensions.Normal)
        ) {

            Text(
                text = stringResource(R.string.number_of_transactions),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.inversePrimary
            )

            Spacer(modifier = Modifier.height(DpDimensions.Small))

            Divider(color = MaterialTheme.colorScheme.inverseSurface)

            Spacer(modifier = Modifier.height(DpDimensions.Small))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "32",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.inversePrimary
                    )

                    Text(
                        text = stringResource(R.string.income),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.inversePrimary
                    )
                }

                Divider(
                    color = MaterialTheme.colorScheme.inverseSurface,
                    modifier = Modifier
                        .height(80.dp)
                        .width(1.dp)
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "23",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.inversePrimary
                    )

                    Text(
                        text = stringResource(R.string.sent),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.inversePrimary
                    )
                }

                Divider(
                    color = MaterialTheme.colorScheme.inverseSurface,
                    modifier = Modifier
                        .height(80.dp)
                        .width(1.dp)
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "12",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.inversePrimary
                    )

                    Text(
                        text = stringResource(R.string.request),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.inversePrimary
                    )
                }


            }

            Spacer(modifier = Modifier.height(DpDimensions.Small))

            Divider(color = MaterialTheme.colorScheme.inverseSurface)

            Spacer(modifier = Modifier.height(DpDimensions.Small))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "8",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.inversePrimary
                    )

                    Text(
                        text = stringResource(R.string.top_up),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.inversePrimary
                    )
                }

                Divider(
                    color = MaterialTheme.colorScheme.inverseSurface,
                    modifier = Modifier
                        .height(80.dp)  //fill the max height
                        .width(1.dp)
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "7",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.inversePrimary
                    )

                    Text(
                        text = stringResource(R.string.withdrawn),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.inversePrimary
                    )
                }

                Divider(
                    color = MaterialTheme.colorScheme.inverseSurface,
                    modifier = Modifier
                        .height(80.dp)
                        .width(1.dp)
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "70",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.inversePrimary
                    )

                    Text(
                        text = stringResource(R.string.all),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.inversePrimary
                    )
                }


            }

        }
    }

}

@Preview
@Composable
fun TransactionsNoComponentPreview() {
    SwiftPayTheme {
        TransactionsNoComponent(modifier = Modifier.fillMaxWidth())
    }
}