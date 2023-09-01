package com.example.swiftpay.ui.screens.home.components

import android.widget.Space
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.swiftpay.R
import com.example.swiftpay.ui.theme.SwiftPayTheme

@Composable
fun TransactionHistoryItem(
    modifier: Modifier = Modifier,
    transaction: Transaction,
    onTransactionClick: (Transaction) -> Unit
) {
    Surface(
        onClick = { onTransactionClick(transaction) },
        color = MaterialTheme.colorScheme.background
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
            Image(
                painter = painterResource(id = transaction.picture),
                contentDescription = transaction.name + " picture",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(50.dp)
            )

            Column(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
                    .weight(1f)
            ) {
                Text(
                    text = transaction.name,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.inversePrimary
                )

                Text(
                    text = transaction.time,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onTertiary
                )
            }

            Column(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = (if (transaction.transactionDirection == TransactionDirection.IN) "+" else "-") + transaction.amount,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.inversePrimary
                )

                Text(
                    text = transaction.type,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onTertiary
                )
            }
        }
    }
}

@Preview
@Composable
fun TransactionHistoryItemPreview() {
    SwiftPayTheme {
        TransactionHistoryItem(
            modifier = Modifier.fillMaxWidth(),
            transaction = transactions[0],
            onTransactionClick = {}
        )
    }
}

@Composable
fun TransactionsStickyHeader(modifier: Modifier = Modifier, text: String) {
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


data class Transaction(
    val name: String,
    val time: String,
    val formattedDate: String,
    val amount: String,
    val transactionDirection: TransactionDirection,
    val type: String,
    @DrawableRes val picture: Int = listOf(
        R.drawable.person_1,
        R.drawable.person_2,
        R.drawable.person_3,
        R.drawable.person_4,
        R.drawable.person_5,
    ).random()
)

enum class TransactionDirection {
    IN,
    OUT
}


val transactions = listOf(
    Transaction(
        name = "John Doe",
        time = "03.23 PM",
        formattedDate = "Today",
        amount = "$ 384.23",
        transactionDirection = TransactionDirection.IN,
        type = "Received"
    ),
    Transaction(
        name = "Jane Doe",
        time = "03.23 PM",
        formattedDate = "Today",
        amount = "$ 384.23",
        transactionDirection = TransactionDirection.IN,
        type = "Received"
    ),
    Transaction(
        name = "Chris Cloe",
        time = "03.23 PM",
        formattedDate = "Yesterday",
        amount = "$ 384.23",
        transactionDirection = TransactionDirection.OUT,
        type = "Sent"
    ),
    Transaction(
        name = "Anderson Jay",
        time = "03.23 PM",
        formattedDate = "Yesterday",
        amount = "$ 384.23",
        transactionDirection = TransactionDirection.IN,
        type = "Received"
    ),
    Transaction(
        name = "Ezzy Pilot",
        time = "03.23 PM",
        formattedDate = "Yesterday",
        amount = "$ 384.23",
        transactionDirection = TransactionDirection.OUT,
        type = "Sent"
    ),
    Transaction(
        name = "John Kamau",
        time = "03.23 PM",
        formattedDate = "02 Sep 2023",
        amount = "$ 384.23",
        transactionDirection = TransactionDirection.OUT,
        type = "Sent"
    ),
    Transaction(
        name = "Chris Bane",
        time = "03.23 PM",
        formattedDate = "02 Sep 2023",
        amount = "$ 384.23",
        transactionDirection = TransactionDirection.IN,
        type = "Received"
    ),
    Transaction(
        name = "Theresa Webb",
        time = "03.23 PM",
        formattedDate = "23 Aug 2023",
        amount = "$ 384.23",
        transactionDirection = TransactionDirection.OUT,
        type = "Sent"
    ),
    Transaction(
        name = "Mary Winkles",
        time = "03.23 PM",
        formattedDate = "23 Aug 2023",
        amount = "$ 384.23",
        transactionDirection = TransactionDirection.IN,
        type = "Received"
    ),
    Transaction(
        name = "Rold Richards",
        time = "03.23 PM",
        formattedDate = "23 Aug 2023",
        amount = "$ 384.23",
        transactionDirection = TransactionDirection.IN,
        type = "Received"
    ),
    Transaction(
        name = "Kristin Doe",
        time = "03.23 PM",
        formattedDate = "20 Aug 2023",
        amount = "$ 384.23",
        transactionDirection = TransactionDirection.OUT,
        type = "Sent"
    ),
    Transaction(
        name = "James Briks",
        time = "03.23 PM",
        formattedDate = "19 Aug 2023",
        amount = "$ 384.23",
        transactionDirection = TransactionDirection.IN,
        type = "Received"
    ),
    Transaction(
        name = "Blues Man",
        time = "03.23 PM",
        formattedDate = "13 Aug 2023",
        amount = "$ 384.23",
        transactionDirection = TransactionDirection.OUT,
        type = "Sent"
    ),
)