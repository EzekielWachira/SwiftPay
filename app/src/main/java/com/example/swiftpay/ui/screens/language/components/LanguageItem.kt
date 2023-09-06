package com.example.swiftpay.ui.screens.language.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
@Composable
fun LanguageItem(
    modifier: Modifier = Modifier,
    onLanguageClick: (Language) -> Unit,
    language: Language
) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .fillMaxWidth(),
        border = BorderStroke(
            1.dp,
            if (language.isSelected) MaterialTheme.colorScheme.onSecondary
            else MaterialTheme.colorScheme.inverseSurface
        ),
        onClick = { onLanguageClick(language) },
        color = MaterialTheme.colorScheme.secondaryContainer,
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
                painter = painterResource(id = language.flag),
                contentDescription = language.name + " flag",
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .height(50.dp)
                    .width(50.dp),
                contentScale = ContentScale.Inside
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = language.name, style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.inversePrimary,
                modifier = Modifier.weight(1f)
            )

            if (language.isSelected)
                Icon(
                    painter = painterResource(id = R.drawable.done),
                    contentDescription = "Done Icon"
                )
        }
    }
}


data class Language(
    @DrawableRes val flag: Int,
    val name: String,
    val isSelected: Boolean = false
)

val languages = listOf(
    Language(flag = R.drawable.usa, name = "English (US)"),
    Language(flag = R.drawable.united_kingdom, name = "English (UK)"),
    Language(flag = R.drawable.russia, name = "Russian"),
    Language(flag = R.drawable.india, name = "Hindi"),
    Language(flag = R.drawable.kenya, name = "English (Kenya)"),
    Language(flag = R.drawable.brazil, name = "Spanish (Brazil)"),
    Language(flag = R.drawable.canada, name = "English (Canada)"),
    Language(flag = R.drawable.south_africa, name = "English (South Africa)"),
    Language(flag = R.drawable.china, name = "Chinese"),
    Language(flag = R.drawable.tanzania, name = "Swahili"),
)