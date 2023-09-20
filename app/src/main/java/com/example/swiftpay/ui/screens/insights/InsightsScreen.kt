package com.example.swiftpay.ui.screens.insights

import android.widget.Space
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.swiftpay.ui.navigation.Screen
import com.example.swiftpay.ui.screens.insights.components.ChartComponent
import com.example.swiftpay.ui.screens.insights.components.ExpenditureItem
import com.example.swiftpay.ui.screens.insights.components.InsightsAppBar
import com.example.swiftpay.ui.screens.insights.components.TransactionsNoComponent
import com.example.swiftpay.ui.screens.main.components.MainTopBar
import com.example.swiftpay.ui.theme.BlueGrey11
import com.example.swiftpay.ui.theme.DpDimensions
import com.example.swiftpay.ui.theme.Green67
import com.example.swiftpay.ui.theme.Red65
import com.example.swiftpay.ui.theme.SwiftPayTheme
import com.example.swiftpay.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun InsightsScreen(navController: NavController) {

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = if (useDarkIcons)
                White else BlueGrey11,
            darkIcons = useDarkIcons
        )
    }

    Scaffold(
        topBar = { InsightsAppBar(onMoreClick = { }, onLogoClick = {})}
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = DpDimensions.Normal)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            Spacer(modifier = Modifier.height(DpDimensions.Normal))

            ChartComponent(onFilterClick = {},
                modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(DpDimensions.Normal))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(DpDimensions.Small)
            ) {

                ExpenditureItem(modifier = Modifier
                    .weight(1f),
                    title = "Income",
                    lineColor = Green67,
                    value = "$3,345.34"
                    )

                ExpenditureItem(modifier = Modifier
                    .weight(1f),
                    title = "Expense",
                    lineColor = Red65,
                    value = "$1,345.34"
                    )

            }

            Spacer(modifier = Modifier.height(DpDimensions.Normal))

            TransactionsNoComponent(modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(DpDimensions.Dp20))

        }
    }

}


@Preview
@Composable
fun InsightsScreenPreview() {
    SwiftPayTheme {
        InsightsScreen(rememberNavController())
    }
}