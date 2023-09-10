package com.example.swiftpay.ui.screens.help.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.swiftpay.ui.theme.DpDimensions
import com.example.swiftpay.ui.theme.SwiftPayTheme

@Composable
fun FilterItem(modifier: Modifier = Modifier, filter: Filter, onClick: (Filter) -> Unit) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(DpDimensions.Dp20),
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.inverseSurface),
        onClick = { onClick(filter) },
        color = if (filter.isSelected) MaterialTheme.colorScheme.onPrimary
        else MaterialTheme.colorScheme.background
    ) {
        Text(
            modifier = Modifier.padding(
                vertical = DpDimensions.Small,
                horizontal = DpDimensions.Normal
            ),
            text = filter.title, style = MaterialTheme.typography.bodyMedium,
            color = if (filter.isSelected) {
                Color.Black
            } else MaterialTheme.colorScheme.inversePrimary
        )
    }
}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun FilterItemPreview() {
    SwiftPayTheme {
        FilterItem(filter = Filter(title = "General", isSelected = true), onClick = {})
    }
}

data class Filter(
    val title: String,
    val isSelected: Boolean
)


val filters = listOf(
    Filter(title = "General", isSelected = true),
    Filter(title = "Account", isSelected = false),
    Filter(title = "Payment", isSelected = false),
    Filter(title = "Balance", isSelected = false),
)

val transactionFilters = listOf(
    Filter(title = "All", isSelected = true),
    Filter(title = "Income", isSelected = false),
    Filter(title = "Sent", isSelected = false),
    Filter(title = "Request", isSelected = false),
    Filter(title = "Withdraw", isSelected = false)
)
