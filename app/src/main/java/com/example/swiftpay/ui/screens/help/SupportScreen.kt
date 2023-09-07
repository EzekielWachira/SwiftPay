package com.example.swiftpay.ui.screens.help

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.swiftpay.R
import com.example.swiftpay.ui.screens.help.components.ContactItem
import com.example.swiftpay.ui.theme.DpDimensions
import com.example.swiftpay.ui.theme.SwiftPayTheme

@Composable
fun SupportScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = DpDimensions.Dp20)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(DpDimensions.Normal)
    ) {


        ContactItem(title = "Customer Service", icon = R.drawable.support_2) {

        }

        ContactItem(title = "WhatsApp", icon = R.drawable.whatsapp) {

        }

        ContactItem(title = "Website", icon = R.drawable.website) {

        }

        ContactItem(title = "Facebook", icon = R.drawable.facebook) {

        }

        ContactItem(title = "Twitter", icon = R.drawable.twitter) {

        }

        ContactItem(title = "Instagram", icon = R.drawable.instagram) {

        }
    }
}

@Preview
@Composable
fun SupportScreenPreview() {
    SwiftPayTheme {
        SupportScreen()
    }
}