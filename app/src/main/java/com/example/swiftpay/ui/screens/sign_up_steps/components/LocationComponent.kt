package com.example.swiftpay.ui.screens.sign_up_steps.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.swiftpay.R
import com.example.swiftpay.domain.model.Country
import com.example.swiftpay.ui.screens.sign_up_steps.state.NameState
import com.example.swiftpay.ui.screens.sign_up_steps.state.SearchState
import com.example.swiftpay.ui.theme.Green54
import com.example.swiftpay.ui.theme.SwiftPayTheme


@Composable
fun LocationComponent(
    modifier: Modifier = Modifier,
    state: SearchState,
    onSearch: (String) -> Unit,
    countries: List<Country>,
    onCountryClick: (Country) -> Unit,
    selectedCountry: Country?,
    onButtonClick: () -> Unit
) {
    Column(
        modifier = modifier
    ) {

        Column (
            modifier = Modifier
                .padding(16.dp)
                .weight(1f)
        ) {
            Text(
                text = stringResource(id = R.string.where_do_you_come_from),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.inversePrimary,
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = stringResource(R.string.select_country),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.inversePrimary
            )

            Spacer(modifier = Modifier.height(25.dp))

            SearchSection(state = state, onSearch = onSearch, modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(25.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(countries.size) { index ->
                    val country = countries[index]
                    CountryComponent(country = country, onCountryClick = {
                        onCountryClick(it)
                    })
                }
            }
        }

        ButtonSection(text = stringResource(id = R.string.continue_), selectedCountry = selectedCountry, onButtonClick = { onButtonClick() } )

    }
}

@Preview
@Composable
fun SearchComponentPreview() {
    SwiftPayTheme {
        LocationComponent(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            state = SearchState(),
            onSearch = {},
            countries = com.example.swiftpay.data.utils.countriesList,
            onCountryClick = {}, selectedCountry = null,
            onButtonClick = {  })
    }
}

@Composable
fun SearchSection(
    modifier: Modifier = Modifier,
    state: SearchState,
    onSearch: (String) -> Unit
) {
    Surface(
        color = MaterialTheme.colorScheme.secondaryContainer,
        shape = RoundedCornerShape(10.dp),
        modifier = modifier.height(60.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 10.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "search icon",
                modifier = Modifier.size(
                    24.dp
                ),
                tint = MaterialTheme.colorScheme.onTertiary
            )

            TextField(
                value = state.query, onValueChange = { value ->
                    onSearch(value)
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.search_country),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onTertiary
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    cursorColor = MaterialTheme.colorScheme.inversePrimary
                ),
                modifier = Modifier.weight(1f),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                textStyle = MaterialTheme.typography.bodySmall
            )
        }
    }
}


@Composable
fun ButtonSection(
    modifier: Modifier = Modifier,
    text: String,
    onButtonClick: () -> Unit,
    selectedCountry: Country?
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {

        Divider(color = MaterialTheme.colorScheme.inverseSurface)

        Box(
            modifier = modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = 30.dp
                )
        ) {

            Button(
                onClick = { onButtonClick() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary,
                    disabledContainerColor = Green54
                ),
                enabled = selectedCountry != null
            ) {

                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}
