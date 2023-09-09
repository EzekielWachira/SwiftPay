package com.example.swiftpay.ui.screens.request_money.request_money_receipt.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.swiftpay.ui.screens.receipt.components.ReceiptDetails
import com.example.swiftpay.ui.theme.DpDimensions
import com.example.swiftpay.ui.theme.SwiftPayTheme

@Composable
fun RequestMoneyReceiptDetails(
    modifier: Modifier = Modifier
) {

    Surface(
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.inverseSurface,
        ),
        modifier = modifier,
        shape = RoundedCornerShape(DpDimensions.Small),
        color = MaterialTheme.colorScheme.secondaryContainer
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(DpDimensions.Normal)
        ) {

            Spacer(modifier = Modifier.height(DpDimensions.Normal))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(text = "You requested",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onTertiary,
                    modifier = Modifier.weight(1f))

                Text(text = "$250.00",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    textAlign = TextAlign.End,
                    modifier = Modifier.weight(1f))

            }

            Spacer(modifier = Modifier.height(DpDimensions.Normal))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(text = "To",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onTertiary,
                    modifier = Modifier.weight(1f))

                Text(text = "Alexia Hershey",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    textAlign = TextAlign.End,
                    modifier = Modifier.weight(1f))

            }

            Spacer(modifier = Modifier.height(DpDimensions.Normal))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(text = "Email",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onTertiary,
                    modifier = Modifier.weight(1f))

                Text(text = "alexia.hershey@gmail.com",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    textAlign = TextAlign.End,
                    modifier = Modifier.weight(1f))

            }

            Spacer(modifier = Modifier.height(DpDimensions.Normal))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(text = "Date",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onTertiary,
                    modifier = Modifier.weight(1f))

                Text(text = "Sept 8, 2023 12:32 PM",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    textAlign = TextAlign.End,
                    modifier = Modifier.weight(1f))

            }

            Spacer(modifier = Modifier.height(DpDimensions.Normal))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(text = "Transaction ID",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onTertiary,
                    modifier = Modifier.weight(1f))

                Text(text = "4808377636",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    textAlign = TextAlign.End,
                    modifier = Modifier.weight(1f))

            }

            Spacer(modifier = Modifier.height(DpDimensions.Normal))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(text = "Reference ID",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onTertiary,
                    modifier = Modifier.weight(1f))

                Text(text = "HDGSK93",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    textAlign = TextAlign.End,
                    modifier = Modifier.weight(1f))

            }

            Spacer(modifier = Modifier.height(DpDimensions.Dp20))
            Divider(color = MaterialTheme.colorScheme.inverseSurface)
            Spacer(modifier = Modifier.height(DpDimensions.Dp20))
            Text(text = "Notes",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onTertiary,
                )
            Spacer(modifier = Modifier.height(DpDimensions.Smallest))

            Text(text = "Lorem ipsum dolor site amet",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.inversePrimary,
                )

            Spacer(modifier = Modifier.height(DpDimensions.Normal))


        }


    }

}

@Preview
@Composable
fun ReceiptDetailsPreview() {
    SwiftPayTheme {
        RequestMoneyReceiptDetails(modifier = Modifier.fillMaxWidth())
    }
}