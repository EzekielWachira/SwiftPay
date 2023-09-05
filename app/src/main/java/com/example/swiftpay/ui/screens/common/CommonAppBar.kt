package com.example.swiftpay.ui.screens.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.swiftpay.R
import com.example.swiftpay.ui.screens.contacts.components.showToast
import com.example.swiftpay.ui.theme.DpDimensions
import com.example.swiftpay.ui.theme.SwiftPayTheme

@Composable
fun CommonAppBar(
    modifier: Modifier = Modifier,
    isRightIconVisible: Boolean,
    toolBarTitle: String,
    onMoreClick: () -> Unit,
    onLogoClick: () -> Unit
) {

    var expanded by remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current

    Box(
        modifier = modifier.background(MaterialTheme.colorScheme.background)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(
                start = DpDimensions.Normal,
                end = DpDimensions.Normal,
                top = DpDimensions.Small,
                bottom = DpDimensions.Small,
            )
        ) {
            IconButton(onClick = { onLogoClick() }) {
                Image(
                    painter = painterResource(id = R.drawable.pay_logo_dark),
                    contentDescription = "pay logo",
                    modifier = Modifier.size(30.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Text(
                text = toolBarTitle,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.inversePrimary, modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
            )

            if (isRightIconVisible) {

                Box(
                    contentAlignment = Alignment.BottomCenter
                ) {


                    IconButton(onClick = { expanded = !expanded }) {
                        Icon(
                            painter = painterResource(id = R.drawable.more_vertical),
                            contentDescription = "notification logo",
                            modifier = Modifier.size(30.dp),
                            tint = MaterialTheme.colorScheme.inversePrimary
                        )
                    }

                    androidx.compose.animation.AnimatedVisibility(
                        visible = expanded,
                        enter = slideInVertically(initialOffsetY = { it }),
                        exit = slideOutVertically(targetOffsetY = { it })
                    ) {
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                            modifier = Modifier.background(MaterialTheme.colorScheme.background)
                        ) {
                            DropdownMenuItem(text = {
                                Text(
                                    text = "Menu Item 1",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.inversePrimary
                                )
                            }, onClick = { context.showToast("Menu Item 1") })

                            DropdownMenuItem(text = {
                                Text(
                                    text = "Menu Item 2",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.inversePrimary
                                )
                            }, onClick = { context.showToast("Menu Item 2") })

                            DropdownMenuItem(text = {
                                Text(
                                    text = "Menu Item 3",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.inversePrimary
                                )
                            }, onClick = { context.showToast("Menu Item 3") })
                        }
                    }
                }
            } else Spacer(modifier = Modifier.width(50.dp))
        }
    }

}


@Preview
@Composable
fun CommonAppBarPreview() {
    SwiftPayTheme {
        CommonAppBar(isRightIconVisible = false, onMoreClick = { },
            toolBarTitle = "Account", modifier = Modifier.fillMaxWidth()) {

        }
    }
}