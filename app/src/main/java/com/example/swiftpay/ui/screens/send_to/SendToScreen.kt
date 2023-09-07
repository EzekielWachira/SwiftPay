package com.example.swiftpay.ui.screens.send_to

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.swiftpay.R
import com.example.swiftpay.ui.navigation.NavDestinations.SendMoney.SEND_MONEY_MAIN
import com.example.swiftpay.ui.navigation.Screen
import com.example.swiftpay.ui.screens.common.AppBarWithTwoActions
import com.example.swiftpay.ui.screens.contacts.ContactsScreen
import com.example.swiftpay.ui.screens.contacts.ContactsViewModel
import com.example.swiftpay.ui.screens.contacts.components.ContactItem
import com.example.swiftpay.ui.screens.contacts.components.ContactsAppBar
import com.example.swiftpay.ui.screens.contacts.components.SearchComponent
import com.example.swiftpay.ui.screens.contacts.components.contacts
import com.example.swiftpay.ui.screens.contacts.components.favoriteContacts
import com.example.swiftpay.ui.screens.home.components.TransactionsStickyHeader
import com.example.swiftpay.ui.screens.home.components.transactions
import com.example.swiftpay.ui.theme.BlueGrey11
import com.example.swiftpay.ui.theme.DpDimensions
import com.example.swiftpay.ui.theme.Green67
import com.example.swiftpay.ui.theme.SwiftPayTheme
import com.example.swiftpay.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SendToScreen(navController: NavController) {

    val viewModel: ContactsViewModel = hiltViewModel()
    val searchState by viewModel.searchState.collectAsStateWithLifecycle()
    val searchContacts by viewModel.contacts.collectAsStateWithLifecycle()
    var tabIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    var focusState by rememberSaveable {
        mutableStateOf(false)
    }
    val tabTitles = listOf(
        stringResource(R.string.all_contacts),
//        stringResource(R.string.phone_contacts),
        stringResource(R.string.favorites),
    )

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()


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
        topBar = {
            AppBarWithTwoActions(
                onLeftButtonClick = { navController.popBackStack() },
                onRightButtonClick = { },
                rightIcon = Icons.Outlined.ArrowBack,
                leftIcon = Icons.Outlined.ArrowBack,
                toolbarTitle = stringResource(id = R.string.send_to),
                isRightIconVisible = false
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { },
                containerColor = MaterialTheme.colorScheme.onPrimary
            ) {
                Icon(imageVector = Icons.Outlined.Add
                    , contentDescription = "add icon",
                    tint = Color.Black)
            }
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
            SearchComponent(state = searchState, onSearch = viewModel::onSearch,
                onTextFieldFocus = { hasFocus ->
                    focusState = hasFocus
                }, focusState = focusState,
                onClearButtonClicked = {
                    viewModel.onSearch("")
                    focusState = false
                },
                text = stringResource(R.string.search_contact))

            Spacer(modifier = Modifier.height(DpDimensions.Small))

            if (focusState) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(2.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {

                    item {
                        Spacer(modifier = Modifier.height(20.dp))
                    }

                    searchContacts.groupBy { it.name[0] }.forEach { (char, contacts) ->
                        stickyHeader {
                            TransactionsStickyHeader(
                                text = char.toString(), modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 16.dp, end = 16.dp)
                            )
                        }

                        itemsIndexed(contacts, key = { id, con -> "$id" + con.email }) {index, contact ->
                            ContactItem(contact = contact, onContactClick = {
                                navController.navigate(SEND_MONEY_MAIN)
                            })
                        }
                    }
                }
            } else {

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
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(2.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                        ) {

                            item {
                                Spacer(modifier = Modifier.height(20.dp))
                            }

                            contacts.groupBy { it.name[0] }.forEach { (char, contacts) ->
                                stickyHeader {
                                    TransactionsStickyHeader(
                                        text = char.toString(), modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 16.dp, end = 16.dp)
                                    )
                                }

                                itemsIndexed(contacts, key = { id, con -> "$id" + con.email }) {index, contact ->
                                    ContactItem(contact = contact, onContactClick = {
                                        navController.navigate(SEND_MONEY_MAIN)
                                    })
                                }
                            }
                        }
                    }

                    1 -> {
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(2.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                        ) {

                            item {
                                Spacer(modifier = Modifier.height(20.dp))
                            }

                            favoriteContacts.groupBy { it.name[0] }.forEach { (char, contacts) ->
                                stickyHeader {
                                    TransactionsStickyHeader(
                                        text = char.toString(), modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 16.dp, end = 16.dp)
                                    )
                                }

                                itemsIndexed(contacts, key = { id, con -> "$id" + con.email }) {index, contact ->
                                    ContactItem(contact = contact, onContactClick = {
                                        navController.navigate(SEND_MONEY_MAIN)
                                    })
                                }
                            }
                        }
                    }
                }
            }

        }
    }

}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ContactsScreenPreview() {
    SwiftPayTheme {
        SendToScreen(rememberNavController())
    }
}