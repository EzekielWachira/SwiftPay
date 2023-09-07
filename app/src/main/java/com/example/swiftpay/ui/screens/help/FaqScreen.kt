package com.example.swiftpay.ui.screens.help

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.swiftpay.R
import com.example.swiftpay.ui.screens.contacts.components.SearchComponent
import com.example.swiftpay.ui.screens.help.components.FaqItem
import com.example.swiftpay.ui.screens.help.components.FilterItem
import com.example.swiftpay.ui.screens.help.components.faqs
import com.example.swiftpay.ui.screens.help.components.filters
import com.example.swiftpay.ui.theme.DpDimensions

@Composable
fun FaqScreen() {

    val viewModel: HelpViewModel = hiltViewModel()
    val searchState by viewModel.searchState.collectAsStateWithLifecycle()
    var focusState by rememberSaveable {
        mutableStateOf(false)
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(DpDimensions.Small)
    ) {
        item {
            Column(modifier = Modifier.fillMaxWidth()) {

                Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                SearchComponent(state = searchState, onSearch = viewModel::onSearch,
                    onTextFieldFocus = { hasFocus ->
                        focusState = hasFocus
                    }, focusState = focusState,
                    onClearButtonClicked = {
                        viewModel.onSearch("")
                        focusState = false
                    },
                    text = stringResource(R.string.search)
                )

                Spacer(modifier = Modifier.height(DpDimensions.Normal))

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(DpDimensions.Small)
                ) {
                    items(filters, key = { it.title }) { filter ->
                        FilterItem(filter = filter, onClick = {})
                    }
                }

                Spacer(modifier = Modifier.height(DpDimensions.Small))
            }
        }

        items(faqs, key = { it.title }) { faq ->
            FaqItem(faq = faq, onFaqClick = { }, modifier = Modifier.fillMaxWidth())
        }
        
        item { 
            Spacer(modifier = Modifier.height(DpDimensions.Dp20))
        }

    }
}