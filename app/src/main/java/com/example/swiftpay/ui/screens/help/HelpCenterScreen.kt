package com.example.swiftpay.ui.screens.help

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.swiftpay.R
import com.example.swiftpay.ui.screens.common.AppBarWithTwoActions
import com.example.swiftpay.ui.theme.BlueGrey11
import com.example.swiftpay.ui.theme.DpDimensions
import com.example.swiftpay.ui.theme.SwiftPayTheme
import com.example.swiftpay.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun HelpCenterScreen(navController: NavController) {

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()

    var tabIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    val tabTitles = listOf(
        stringResource(R.string.faq),
        stringResource(R.string.contact_support),
    )


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
                rightIcon = Icons.Outlined.ArrowBack,
                leftIcon = Icons.Outlined.ArrowBack,
                toolbarTitle = stringResource(id = R.string.help_center),
                isRightIconVisible = false
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(
                    start = DpDimensions.Normal,
                    end = DpDimensions.Normal,
                    top = DpDimensions.Small
                )
                .fillMaxSize()
        ) {

            TabRow(selectedTabIndex = tabIndex,
                modifier = Modifier.fillMaxWidth(),
                divider = {
                    Divider(color = MaterialTheme.colorScheme.inverseSurface)
                },
                containerColor = MaterialTheme.colorScheme.background,
                indicator = { tabPositions ->
                    Box(
                        modifier = Modifier
                            .tabIndicatorOffset(tabPositions[tabIndex])
                            .height(4.dp)
                            .clip(RoundedCornerShape(8.dp)) // clip modifier not working
                            .padding(horizontal = 60.dp)
                            .background(
                                color = MaterialTheme.colorScheme.onPrimary,
                                shape = RoundedCornerShape(8.dp)
                            )
                    )
                }
            ) {

                tabTitles.forEachIndexed { index, title ->
                    Tab(
                        selected = tabIndex == index,
                        onClick = { tabIndex = index },
                        text = {
                            Text(
                                text = title,
                                color = MaterialTheme.colorScheme.inversePrimary,
                                style = MaterialTheme.typography.titleMedium,
                            )
                        },
                        selectedContentColor = MaterialTheme.colorScheme.onPrimary
                    )
                }

            }


            when (tabIndex) {
                0 -> {
                    FaqScreen()
                }

                1 -> {
                    SupportScreen()
                }
            }


        }

    }

}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun HelpCenterScreenPreview() {
    SwiftPayTheme {
        HelpCenterScreen(rememberNavController())
    }
}