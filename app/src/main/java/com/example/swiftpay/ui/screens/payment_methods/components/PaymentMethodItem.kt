package com.example.swiftpay.ui.screens.payment_methods.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.swiftpay.R
import com.example.swiftpay.ui.theme.DpDimensions

@Composable
fun PaymentMethodItem(
    modifier: Modifier = Modifier,
    paymentMethod: PaymentMethod,
    onPaymentMethodClick: (PaymentMethod) -> Unit
) {

    Surface(
        onClick = { onPaymentMethodClick(paymentMethod) },
        shape = RoundedCornerShape(DpDimensions.Small),
        color = MaterialTheme.colorScheme.secondaryContainer,
        modifier = modifier,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.inverseSurface)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = DpDimensions.Normal,
                    vertical = DpDimensions.Normal
                )
        ) {

            Image(
                painter =
                painterResource(id = paymentMethod.paymentIcon),
                contentDescription = "${paymentMethod.name} Icon",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Text(
                text = paymentMethod.name,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.inversePrimary,
                modifier = Modifier.padding(horizontal = DpDimensions.Normal)
                    .weight(1f)
            )

            Text(
                text = paymentMethod.status,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.inversePrimary
            )

        }

    }

}


data class PaymentMethod(
    val name: String,
    val status: String,
    @DrawableRes val paymentIcon: Int
)


val paymentMethods = listOf(
    PaymentMethod(name = "PayPal", status = "Connected", paymentIcon = R.drawable.paypal),
    PaymentMethod(name = "Google Pay", status = "Connected", paymentIcon = R.drawable.google_pay),
    PaymentMethod(name = "Apple Pay", status = "Connected", paymentIcon = R.drawable.apple_pay),
    PaymentMethod(name = "**** **** 2736", status = "Connected", paymentIcon = R.drawable.mastercard),
    PaymentMethod(name = "**** **** 4653", status = "Connected", paymentIcon = R.drawable.visa),
)