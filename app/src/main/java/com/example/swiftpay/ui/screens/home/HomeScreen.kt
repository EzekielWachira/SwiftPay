package com.example.swiftpay.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.swiftpay.R
import com.example.swiftpay.ui.navigation.NavDestinations
import com.example.swiftpay.ui.navigation.NavDestinations.SendMoney.SEND_MONEY_MAIN
import com.example.swiftpay.ui.navigation.NavDestinations.SendTo.SEND_TO_MAIN
import com.example.swiftpay.ui.screens.home.components.Transaction
import com.example.swiftpay.ui.screens.home.components.TransactionHistoryItem
import com.example.swiftpay.ui.screens.home.components.TransactionsStickyHeader
import com.example.swiftpay.ui.screens.home.components.transactions
import com.example.swiftpay.ui.screens.main.components.MainTopBar
import com.example.swiftpay.ui.theme.BlueGrey11
import com.example.swiftpay.ui.theme.Green67
import com.example.swiftpay.ui.theme.SwiftPayTheme
import com.example.swiftpay.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavController) {

    val groupedTransactions = transactions.groupBy { it.formattedDate }

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()
    val coroutineScope = rememberCoroutineScope()


    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Green67,
            darkIcons = useDarkIcons
        )

        systemUiController.setNavigationBarColor(
            color = if (useDarkIcons)
                White else BlueGrey11,
            darkIcons = true
        )
    }

    Scaffold(
        topBar = { MainTopBar(onNotificationClick = { }, onLogoClick = { }) }
    ) { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {

                item {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.onPrimary)
                    ) {

                        Spacer(modifier = Modifier.height(20.dp))

                        Row {
                            Text(
                                text = "3,343.34", style = MaterialTheme.typography.titleLarge,
                                fontSize = 35.sp, color = Color.Black
                            )

                            Text(
                                text = "$",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.Black
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Available balance",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Black
                        )

                        Spacer(modifier = Modifier.height(30.dp))

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .size(60.dp)
                                        .clip(CircleShape)
                                        .border(1.dp, Color.Black, CircleShape)
                                        .clickable {
                                            coroutineScope.launch {
                                                navController.navigate(SEND_TO_MAIN)
                                            }
                                        }
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.send),
                                        contentDescription = "Business icon",
                                        modifier = Modifier.size(25.dp),
                                        tint = Color.Black
                                    )
                                }

                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    text = "Send", style = MaterialTheme.typography.titleSmall,
                                    color = Color.Black
                                )

                            }

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .size(60.dp)
                                        .clip(CircleShape)
                                        .border(1.dp, Color.Black, CircleShape)
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.receive_1),
                                        contentDescription = "Business icon",
                                        modifier = Modifier.size(25.dp),
                                        tint = Color.Black
                                    )
                                }

                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    text = "Request", style = MaterialTheme.typography.titleSmall,
                                    color = Color.Black
                                )

                            }


                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .size(60.dp)
                                        .clip(CircleShape)
                                        .border(1.dp, Color.Black, CircleShape)
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.top_up),
                                        contentDescription = "Business icon",
                                        modifier = Modifier.size(25.dp),
                                        tint = Color.Black
                                    )
                                }

                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    text = "Top Up", style = MaterialTheme.typography.titleSmall,
                                    color = Color.Black
                                )

                            }

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .size(60.dp)
                                        .clip(CircleShape)
                                        .border(1.dp, Color.Black, CircleShape)
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.withdraw),
                                        contentDescription = "Business icon",
                                        modifier = Modifier.size(25.dp),
                                        tint = Color.Black
                                    )
                                }

                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    text = "Withdraw", style = MaterialTheme.typography.titleSmall,
                                    color = Color.Black
                                )

                            }

                        }

                        Spacer(modifier = Modifier.height(30.dp))
                    }

                    TransactionHistorySection(modifier = Modifier.fillMaxWidth(), onViewAllClicked = { })
                }

                groupedTransactions.forEach { (date, transactions) ->
                    stickyHeader {
                        TransactionsStickyHeader(
                            text = date, modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp, end = 16.dp)
                        )
                    }

                    itemsIndexed(transactions, key = { id, trans -> "$id" + trans.name }) { index: Int, transaction: Transaction ->
                        TransactionHistoryItem(
                            transaction = transaction, onTransactionClick = { },
                            modifier = Modifier.fillMaxWidth()
                        )

                        if (index < transactions.lastIndex)
                            Divider(
                                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                                color = MaterialTheme.colorScheme.inverseSurface
                            )
                    }
//                    items(transactions, key = { it.name }) {  transaction ->
//                        TransactionHistoryItem(transaction = transaction, onTransactionClick = {  },
//                            modifier = Modifier.fillMaxWidth())
//                    }
                }
            }

        }
    }

}


@Preview
@Composable
fun HomeScreenPreview() {
    SwiftPayTheme {
        HomeScreen(navController = rememberNavController())
    }
}

@Composable
fun TransactionHistorySection(
    modifier: Modifier = Modifier,
    onViewAllClicked: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(
            start = 16.dp,
            end = 16.dp,
            top = 10.dp,
            bottom = 10.dp
        )
    ) {

        Text(
            text = stringResource(R.string.transaction_history),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.inversePrimary
        )

        TextButton(onClick = { onViewAllClicked() }) {
            Text(
                text = stringResource(R.string.view_all),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onTertiary
            )
        }

        IconButton(onClick = { onViewAllClicked() }) {
            Icon(
                painter = painterResource(id = R.drawable.chevron_right),
                contentDescription = "Right arrow",
                modifier = Modifier.size(16.dp),
                tint = MaterialTheme.colorScheme.onTertiary
            )
        }

    }
}

@Preview
@Composable
fun TransactionHistorySectionPreview() {
    SwiftPayTheme {
        TransactionHistorySection(modifier = Modifier.fillMaxWidth(), onViewAllClicked = {})
    }
}