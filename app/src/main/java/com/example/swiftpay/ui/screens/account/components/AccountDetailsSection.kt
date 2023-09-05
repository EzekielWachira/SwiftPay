package com.example.swiftpay.ui.screens.account.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.swiftpay.R
import com.example.swiftpay.ui.theme.SwiftPayTheme

@Composable
fun AccountDetailsSection(
    modifier: Modifier = Modifier,
    onQrCodeClick: () -> Unit,
    user: User = User(name = "Andrew Ainsley", email = "andrew.ainsley@gmail.com")
) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = modifier,
//        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
                top = 10.dp,
                bottom = 10.dp
            )
        ) {
            Image(
                painter = painterResource(id = user.picture),
                contentDescription = "avatar",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(60.dp),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
                    .weight(1f)
            ) {
                Text(
                    text = user.name,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.inversePrimary
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = user.email,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onTertiary
                )
            }

            IconButton(onClick = { onQrCodeClick() }) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.qr_code
                    ),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp),
                    tint = MaterialTheme.colorScheme.inversePrimary
                )
            }
        }
    }
}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun AccountDetailsSectionPrev() {
    SwiftPayTheme {
        AccountDetailsSection(onQrCodeClick = {})
    }
}

data class User(
    val name: String,
    val email: String,
    @DrawableRes val picture: Int = listOf(
        R.drawable.person_1,
        R.drawable.person_2,
        R.drawable.person_3,
        R.drawable.person_4,
        R.drawable.person_5,
    ).random()
)