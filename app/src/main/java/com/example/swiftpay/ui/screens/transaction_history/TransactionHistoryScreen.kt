package com.example.swiftpay.ui.screens.transaction_history

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.swiftpay.R
import com.example.swiftpay.ui.screens.common.AppBarWithTwoActions
import com.example.swiftpay.ui.screens.help.components.FilterItem
import com.example.swiftpay.ui.screens.help.components.transactionFilters
import com.example.swiftpay.ui.screens.home.components.Transaction
import com.example.swiftpay.ui.screens.home.components.TransactionHistoryItem
import com.example.swiftpay.ui.screens.home.components.TransactionsStickyHeader
import com.example.swiftpay.ui.screens.home.components.moreTransactions
import com.example.swiftpay.ui.screens.home.components.transactions
import com.example.swiftpay.ui.theme.BlueGrey11
import com.example.swiftpay.ui.theme.DpDimensions
import com.example.swiftpay.ui.theme.SwiftPayTheme
import com.example.swiftpay.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TransactionHistoryScreen(navController: NavController) {

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()

    val groupedTransactions = moreTransactions.groupBy { it.formattedDate }


    SideEffect {
        systemUiController.setSystemBarsColor(
            color = if (useDarkIcons)
                White else BlueGrey11,
            darkIcons = useDarkIcons
        )
    }

    Scaffold(
        topBar = {
            AppBarWithTwoActions(
                onLeftButtonClick = { navController.popBackStack() },
                onRightButtonClick = { },
                rightIcon = Icons.Outlined.Search,
                leftIcon = Icons.Outlined.ArrowBack,
                toolbarTitle = stringResource(id = R.string.transaction_history),
                isRightIconVisible = true
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(horizontal = DpDimensions.Small)
        ) {

            Spacer(modifier = Modifier.height(DpDimensions.Normal))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(DpDimensions.Small)
            ) {
                items(transactionFilters, key = { it.title }) { filter ->
                    FilterItem(filter = filter, onClick = {})
                }
            }

            Spacer(modifier = Modifier.height(DpDimensions.Small))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {

                item {
                    Spacer(modifier = Modifier.height(DpDimensions.Normal))
                }

                groupedTransactions.forEach { (date, transactions) ->
                    stickyHeader {
                        TransactionsStickyHeader(
                            text = date, modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp, end = 16.dp)
                        )
                    }

                    itemsIndexed(
                        transactions,
                        key = { id, trans -> "$id" + trans.name }) { index: Int, transaction: Transaction ->
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
                }
            }

        }
    }
}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun TransactionHistoryScreenPreview() {
    SwiftPayTheme {
        TransactionHistoryScreen(rememberNavController())
    }
}