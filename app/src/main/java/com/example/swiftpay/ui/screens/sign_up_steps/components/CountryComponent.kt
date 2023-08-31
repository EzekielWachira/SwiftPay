package com.example.swiftpay.ui.screens.sign_up_steps.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.swiftpay.R
import com.example.swiftpay.domain.model.Country
import com.example.swiftpay.ui.theme.SwiftPayTheme

@Composable
fun CountryComponent(country: Country, onCountryClick: (Country) -> Unit) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth(),
        border = BorderStroke(
            1.dp,
            if (country.isSelected) MaterialTheme.colorScheme.onSecondary else MaterialTheme.colorScheme.inverseSurface
        ),
        onClick = { onCountryClick(country) },
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
                painter = painterResource(id = country.flag),
                contentDescription = country.name + " flag",
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .height(50.dp)
                    .width(50.dp),
                contentScale = ContentScale.Inside
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = country.name, style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.inversePrimary,
                modifier = Modifier.weight(1f)
            )

            if (country.isSelected)
                Icon(
                    painter = painterResource(id = R.drawable.done),
                    contentDescription = "Done Icon"
                )
        }
    }
}


@Preview
@Composable
fun CountryPreview() {
    SwiftPayTheme {
        CountryComponent(
            country = Country(name = "Kenya", flag = R.drawable.kenya, isSelected = true),
            onCountryClick = { }
        )
    }
}


//data class Country(
//    val name: String,
//    @DrawableRes val flag: Int,
//    var isSelected: Boolean
//)

//val countriesList = listOf(
//    Country( name = "Kenya", flag = R.drawable.kenya, false ),
//    Country( name = "Uganda", flag = R.drawable.uganda, false ),
//    Country( name = "Tanzania", flag = R.drawable.tanzania, false ),
//    Country( name = "South Africa", flag = R.drawable.south_africa, false ),
//    Country( name = "Russia", flag = R.drawable.russia, false ),
//    Country( name = "Brazil", flag = R.drawable.brazil, false ),
//    Country( name = "United Kingdom", flag = R.drawable.united_kingdom, false ),
//    Country( name = "United States of America", flag = R.drawable.usa, false ),
//    Country( name = "India", flag = R.drawable.india, false ),
//)