package com.example.swiftpay.ui.screens.language

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.swiftpay.R
import com.example.swiftpay.ui.screens.common.AppBarWithTwoActions
import com.example.swiftpay.ui.screens.language.components.LanguageItem
import com.example.swiftpay.ui.screens.language.components.languages
import com.example.swiftpay.ui.theme.DpDimensions
import com.example.swiftpay.ui.theme.SwiftPayTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LanguageScreen(navController: NavController) {

    val groupedLanguages =
        languages.sortedBy { it.name[0] }.groupBy { language -> language.name[0] }

    Scaffold(
        topBar = {
            AppBarWithTwoActions(
                onLeftButtonClick = { navController.popBackStack() },
                onRightButtonClick = { },
                rightIcon = Icons.Outlined.ArrowBack,
                leftIcon = Icons.Outlined.ArrowBack,
                toolbarTitle = stringResource(id = R.string.language),
                isRightIconVisible = false
            )
        }
    ) { paddingValues ->

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(DpDimensions.Small),
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(horizontal = DpDimensions.Normal)
        ) {
            groupedLanguages.forEach { (initial, languages) ->
                stickyHeader {
                    Text(text = initial.toString(), style = MaterialTheme.typography.labelSmall)
                }

                items(languages, key = { it.name }) { language ->
                    LanguageItem(language = language, onLanguageClick = {

                    }, modifier = Modifier.animateItemPlacement(tween(durationMillis = 500)))
                }
            }

            item {
                Spacer(modifier = Modifier.height(DpDimensions.Dp20))
            }
        }

    }

}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun LanguageScreenPreview() {
    SwiftPayTheme {
        LanguageScreen(rememberNavController())
    }
}