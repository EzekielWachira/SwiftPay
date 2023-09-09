package com.example.swiftpay.ui.screens.contact_details

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.swiftpay.R
import com.example.swiftpay.ui.screens.common.AppBarWithTwoActions
import com.example.swiftpay.ui.screens.common.TwoButtons
import com.example.swiftpay.ui.screens.contact_details.components.DeleteContactConfirmation
import com.example.swiftpay.ui.screens.contact_details.components.DeleteContactSuccess
import com.example.swiftpay.ui.theme.BlueGrey11
import com.example.swiftpay.ui.theme.DpDimensions
import com.example.swiftpay.ui.theme.SwiftPayTheme
import com.example.swiftpay.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactDetailsScreen(navController: NavController) {

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()

    val coroutineScope = rememberCoroutineScope()

    val bottomSheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }

    var isDeleteSuccessSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }


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
                rightIcon = Icons.Outlined.StarOutline,
                leftIcon = Icons.Outlined.ArrowBack,
                toolbarTitle = stringResource(id = R.string.contact),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.background),
                isRightIconVisible = true
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            Column(
                modifier = Modifier.fillMaxSize()
            ) {


                Column(
                    modifier = Modifier
                        .padding(horizontal = DpDimensions.Normal)
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.person_6),
                        contentDescription = null,
                        modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                    Text(
                        text = "Charlotte Hanlin",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.inversePrimary
                    )

                    Spacer(modifier = Modifier.height(DpDimensions.Normal))

                    Text(
                        text = "charlotte.hanlin@gmail.com",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.inversePrimary
                    )

                    Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                    Text(
                        text = stringResource(R.string.swiftpay_account),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onTertiary
                    )

                    Spacer(modifier = Modifier.height(50.dp))
                    Divider(color = MaterialTheme.colorScheme.inverseSurface)
                    Spacer(modifier = Modifier.height(50.dp))

                    OutlinedButton(
                        onClick = { isSheetOpen = !isSheetOpen },
                        modifier = Modifier
                            .height(50.dp),
                        border = BorderStroke(1.dp, Color.Red)
                    ) {
                        Text(
                            text = stringResource(R.string.delete_contact),
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onSecondary
                        )
                    }

                }

                TwoButtons(
                    leftButtonText = stringResource(R.string.request_money),
                    rightButtonText = stringResource(R.string.send_money_2),
                    onLeftButtonClick = { },
                    onRightButtonClick = { })

            }

            if (isSheetOpen) {
               AnimatedVisibility(
                    visible = isSheetOpen,
                    enter = slideInVertically(initialOffsetY = { it }),
                    exit = slideOutVertically(targetOffsetY = { it })
                ) {
                    DeleteContactConfirmation(
                        bottomSheetState = bottomSheetState,
                        onDismiss = { isSheetOpen = false },
                        onDelete = {
                            coroutineScope.launch {
                                isSheetOpen = false
                                delay(1_000)
                                isDeleteSuccessSheetOpen = true
                            }
                        }
                    ) {
                        isSheetOpen = false
                    }
                }
            }

            if (isDeleteSuccessSheetOpen) {
                AnimatedVisibility(
                    visible = isDeleteSuccessSheetOpen,
                    enter = slideInVertically(initialOffsetY = { it }),
                    exit = slideOutVertically(targetOffsetY = { it })
                ) {
                    DeleteContactSuccess(bottomSheetState = bottomSheetState) {
                        isDeleteSuccessSheetOpen = false
                    }
                }
            }
        }

    }

}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ContactDetailsScreenPreview() {
    SwiftPayTheme {
        ContactDetailsScreen(rememberNavController())
    }
}