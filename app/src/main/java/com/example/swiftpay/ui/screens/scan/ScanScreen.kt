package com.example.swiftpay.ui.screens.scan

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.swiftpay.ui.screens.main.components.MainTopBar

@Composable
fun ScanScreen(navController: NavController) {

    Scaffold { paddingValues ->
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(paddingValues).fillMaxSize()) {

            Text(text = "Scan", style = MaterialTheme.typography.titleMedium)

        }
    }

}