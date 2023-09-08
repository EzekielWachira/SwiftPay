package com.example.swiftpay.ui.screens.insights.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.swiftpay.ui.theme.DpDimensions

@Composable
fun ExpenditureItem(
    modifier: Modifier = Modifier,
) {

    Surface(
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.inverseSurface,
        ),
        modifier = modifier,
        shape = RoundedCornerShape(DpDimensions.Small),
        color = MaterialTheme.colorScheme.background
    ) {

    }

}