package com.example.swiftpay.ui.screens.help.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.swiftpay.R
import com.example.swiftpay.ui.theme.DpDimensions
import com.example.swiftpay.ui.theme.SwiftPayTheme

@Composable
fun FaqItem(modifier: Modifier = Modifier, faq: Faq, onFaqClick: (Faq) -> Unit) {

    var expanded by rememberSaveable {
        mutableStateOf(false)
    }

    Surface(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier,
        border = BorderStroke(
            1.dp,
            MaterialTheme.colorScheme.inverseSurface
        ),
        onClick = { onFaqClick(faq) },
        color = MaterialTheme.colorScheme.secondaryContainer,
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = DpDimensions.Normal, vertical = DpDimensions.Small),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,

            ) {
                Text(
                    text = faq.title,
                    modifier = Modifier
                        .weight(1f)
                        ,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    fontSize = 14.sp
                )

                IconButton(onClick = { expanded = !expanded }) {
                    if (expanded)
                        Icon(
                            painter = painterResource(id = R.drawable.chevron_up),
                            contentDescription = "up icon",
                            modifier = Modifier.size(DpDimensions.Dp20),
                            tint = MaterialTheme.colorScheme.inversePrimary
                        )
                    else
                        Icon(
                            painter = painterResource(id = R.drawable.chevron_down),
                            contentDescription = "up icon",
                            modifier = Modifier.size(DpDimensions.Dp20),
                            tint = MaterialTheme.colorScheme.inversePrimary
                        )
                }
            }

            if (expanded) {
                AnimatedVisibility(
                    visible = expanded,
                    enter = slideInVertically(initialOffsetY = { it },
                        animationSpec = tween(3_000)
                    ),
                    exit = slideOutVertically(targetOffsetY = { it },
                        animationSpec = tween(3_000))
                ) {

                    Column(modifier = Modifier.fillMaxWidth()
                        .padding(bottom = DpDimensions.Normal)) {
                        Divider(color = MaterialTheme.colorScheme.inverseSurface)
                        Spacer(modifier = Modifier.height(DpDimensions.Small))

                        Text(
                            text = faq.content,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onTertiary
                        )
                    }

                }
            }
        }

    }
}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun FaqItemPreview() {
    SwiftPayTheme {
        FaqItem(faq = faqs[0], onFaqClick = {},
            modifier =  Modifier.fillMaxWidth())
    }
}

data class Faq(
    val title: String,
    val content: String,
)

val faqs = listOf(
    Faq(title = "What is SwiftPay?", content  = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"),
    Faq(title = "How do I set up my account?", content  = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"),
    Faq(title = "How long does a transfer take?", content  = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"),
    Faq(title = "Are there any fees?", content  = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"),
    Faq(title = "How do I request money?", content  = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"),
    Faq(title = "Can I transfer money globally?", content  = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"),
    Faq(title = "How can I reverse a transaction?", content  = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"),
)