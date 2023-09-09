package com.example.swiftpay.ui.screens.add_contact.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.swiftpay.R
import com.example.swiftpay.ui.theme.DpDimensions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAccountSuccess(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = DpDimensions.Dp20,
    bottomSheetState: SheetState,
    onDismiss: () -> Unit
) {

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        shape = RoundedCornerShape(topStart = cornerRadius, topEnd = cornerRadius),
        sheetState = bottomSheetState,
        modifier = modifier
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(DpDimensions.Normal)
                .fillMaxWidth(),
            ) {

            Box(
                modifier = Modifier
                    .border(
                        2.dp,
                        color = MaterialTheme.colorScheme.inversePrimary,
                        shape = CircleShape
                    )
                    .size(70.dp)
                    .background(MaterialTheme.colorScheme.onPrimary, CircleShape),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.done), contentDescription = null,
                    modifier = Modifier.size(30.dp),
                    tint = MaterialTheme.colorScheme.inversePrimary
                )
            }

            Spacer(modifier = Modifier.height(DpDimensions.Dp20))

            Text(text = "Saved to contacts!",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.inversePrimary)

            Spacer(modifier = Modifier.height(DpDimensions.Dp20))
            Spacer(modifier = Modifier.height(DpDimensions.Dp20))

        }
    }

}