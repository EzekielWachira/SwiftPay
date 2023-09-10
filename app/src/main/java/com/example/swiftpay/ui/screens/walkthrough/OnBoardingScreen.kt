package com.example.swiftpay.ui.screens.walkthrough

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.swiftpay.R
import com.example.swiftpay.ui.navigation.NavDestinations.Auth.GET_STARTED
import com.example.swiftpay.ui.theme.BlueGrey11
import com.example.swiftpay.ui.theme.Green67
import com.example.swiftpay.ui.theme.Grey62
import com.example.swiftpay.ui.theme.SwiftPayTheme
import com.example.swiftpay.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(navController: NavController) {
    val pagerState = rememberPagerState {
        onboardingItems.size
    }
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Green67,
            darkIcons = true
        )
        systemUiController.setNavigationBarColor(
            color = if (useDarkIcons) White else BlueGrey11,
            darkIcons  = true
        )
    }

    SwiftPayTheme {
        OnboardingPager(pagerState = pagerState, modifier = Modifier.fillMaxSize(), navController = navController )
    }
}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen(rememberNavController())
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingPager(
    items: List<Walkthrough> = onboardingItems,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    navController: NavController
) {

    val coroutineScope = rememberCoroutineScope()

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.background(MaterialTheme.colorScheme.onPrimary)
                    .weight(1f)
//                .padding(DpDimensions.Normal)
            ) {
                HorizontalPager(state = pagerState) { page ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Image(
                            painter = painterResource(id = items[page].image),
                            contentDescription = stringResource(id = items[page].title),
                            modifier = Modifier
                                .fillMaxWidth(),
                            contentScale = ContentScale.Crop

                        )
                    }
                }
            }

            Box(
//                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    contentColor = MaterialTheme.colorScheme.background,
                    shape = RectangleShape
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(
                                top = 20.dp,
                                start = 16.dp,
                                end = 16.dp,
                                bottom = 20.dp
                            )
                        ) {

                            Spacer(modifier = Modifier.height(30.dp))

                            Text(
                                text = stringResource(id = items[pagerState.currentPage].title),
                                style = MaterialTheme.typography.titleLarge,
                                modifier = Modifier.fillMaxWidth(),
                                color = MaterialTheme.colorScheme.onSecondary,
                                textAlign = TextAlign.Center
                            )

                            Spacer(modifier = Modifier.height(15.dp))

                            Text(
                                text = stringResource(id = items[pagerState.currentPage].description),
                                style = MaterialTheme.typography.bodySmall,
                                modifier = Modifier.fillMaxWidth(),
                                color = MaterialTheme.colorScheme.onSecondary,
                                textAlign = TextAlign.Center
                            )

                            Spacer(modifier = Modifier.height(30.dp))

                            PagerIndicator(currentPage = pagerState.currentPage, items = items)

                            Spacer(modifier = Modifier.height(30.dp))

                        }

                        Divider(color = MaterialTheme.colorScheme.inverseSurface)

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            if (pagerState.currentPage != items.size - 1) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(
                                            start = 16.dp,
                                            end = 16.dp,
                                            top = 16.dp,
                                            bottom = 20.dp
                                        )
                                ) {
                                    OutlinedButton(
                                        onClick = {navController.navigate(GET_STARTED) },
                                        modifier = Modifier
                                            .weight(1f)
                                            .height(50.dp),
                                        border = BorderStroke(
                                            1.dp,
                                            MaterialTheme.colorScheme.onPrimary
                                        )
                                    ) {
                                        Text(
                                            text = "Skip",
                                            style = MaterialTheme.typography.titleSmall,
                                            color = MaterialTheme.colorScheme.onSecondary
                                        )
                                    }

//                                Spacer(modifier = modifier.width(10.dp))

                                    Button(
                                        onClick = {
                                            coroutineScope.launch {
                                                withContext(Dispatchers.Main) {
                                                    pagerState.scrollToPage(
                                                        pagerState.currentPage + 1,
                                                        pageOffsetFraction = 0f
                                                    )
                                                }
                                            }
                                        },
                                        modifier = Modifier
                                            .weight(1f)
                                            .height(50.dp),
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = MaterialTheme.colorScheme.onPrimary
                                        )
                                    ) {
                                        Text(
                                            text = "Continue",
                                            style = MaterialTheme.typography.titleSmall,
                                            color = MaterialTheme.colorScheme.onBackground
                                        )
                                    }
                                }
                            } else {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(
                                            start = 16.dp,
                                            end = 16.dp,
                                            top = 16.dp,
                                            bottom = 20.dp
                                        )
                                ) {
                                    Button(
                                        onClick = { navController.navigate(GET_STARTED) },
                                        modifier = Modifier
                                            .fillMaxWidth(1f)
                                            .height(50.dp),
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = MaterialTheme.colorScheme.onPrimary
                                        )
                                    ) {
                                        Text(
                                            text = stringResource(id = R.string.get_started),
                                            style = MaterialTheme.typography.titleSmall,
                                            color = MaterialTheme.colorScheme.onBackground
                                        )
                                    }
                                }
                            }

                        }
                    }
                }
            }

        }
    }

}


@Composable
fun PagerIndicator(currentPage: Int, items: List<Walkthrough>) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(top = 20.dp)
    ) {
        repeat(items.size) {
            Indicator(isSelected = it == currentPage)
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean) {

    val width = animateDpAsState(
        targetValue = if (isSelected) 40.dp else 10.dp, label = "",
        animationSpec = tween(1000, easing = CubicBezierEasing(0.4f, 0.0f, 0.8f, 0.8f))
    )

    Box(
        modifier =
        Modifier
            .padding(4.dp)
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) MaterialTheme.colorScheme.onSecondary else Grey62
            )
    )
}

//@OptIn(ExperimentalFoundationApi::class)
//@Composable
//fun rememberPagerState(
//    @IntRange(from = 0) initialPage: Int = 0
//): PagerState = rememberSaveable {
//    PagerState(initialPage = initialPage, )
//}