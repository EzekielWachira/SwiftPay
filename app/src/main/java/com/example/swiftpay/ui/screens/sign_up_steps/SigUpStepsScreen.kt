package com.example.swiftpay.ui.screens.sign_up_steps

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerSnapDistance
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.swiftpay.ui.screens.common.AppBar
import com.example.swiftpay.ui.screens.sign_up_steps.components.AccountKindComponent
import com.example.swiftpay.ui.screens.sign_up_steps.components.LocationComponent
import com.example.swiftpay.ui.screens.sign_up_steps.components.NameComponent
import com.example.swiftpay.ui.screens.sign_up_steps.state.ProgressState
import com.example.swiftpay.ui.theme.BlueGrey11
import com.example.swiftpay.ui.theme.SwiftPayTheme
import com.example.swiftpay.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SignUpStepsScreen(navController: NavController) {

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()
    val coroutineScope = rememberCoroutineScope()

    val viewModel: SignUpStepsViewModel = hiltViewModel()
    val nameState by viewModel.nameState.collectAsStateWithLifecycle()
    val progressState by viewModel.progressState.collectAsStateWithLifecycle()
    val searchState by viewModel.searchState.collectAsStateWithLifecycle()
    val countries by viewModel.countries.collectAsStateWithLifecycle()
    val selectedCountry by viewModel.selectedCountry.collectAsStateWithLifecycle()


    val components = listOf(
        Component {
            AccountKindComponent(
                onPersonalAccountClicked = { },
                onBusinessAccountClicked = { },
                modifier = Modifier.fillMaxSize()
            )
        },
        Component {
            NameComponent(
                nameState = nameState,
                onNameEntered = { name -> viewModel.onNameEntered(name) },
                onButtonClicked = { },
                modifier = Modifier.fillMaxSize()
            )
        },
        Component {
            LocationComponent(
                state = searchState,
                onSearch = viewModel::onSearch,
                countries = countries,
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
                onCountryClick = viewModel::selectCountry,
                selectedCountry = selectedCountry,
                onButtonClick = {  }
            )
        }
    )

    val pagerState = rememberPagerState {
        components.size
    }

    val flingBehavior = PagerDefaults.flingBehavior(
        state = pagerState,
        pagerSnapDistance = PagerSnapDistance.atMost(1),
        lowVelocityAnimationSpec = tween(
            easing = FastOutLinearInEasing,
            durationMillis = 5_000
        ),
        highVelocityAnimationSpec = rememberSplineBasedDecay(),
        snapAnimationSpec = tween(
            easing = FastOutSlowInEasing,
            durationMillis = 1_000
        )
    )

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = if (useDarkIcons)
                White else BlueGrey11,
            darkIcons = useDarkIcons
        )

        viewModel.getCountries()
    }


    Scaffold(
        topBar = { AppBarWithProgress(progressState = progressState) {
            navController.popBackStack()
        } }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {


            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
            ) {
                HorizontalPager(
                    state = pagerState, userScrollEnabled = false,
                    flingBehavior = flingBehavior
                ) { page ->
                    when (page) {
                        0 -> AccountKindComponent(
                            onPersonalAccountClicked = {
                                coroutineScope.launch {
                                    withContext(Dispatchers.Main) {
                                        delay(100)
                                        pagerState.scrollToPage(
                                            pagerState.currentPage + 1
                                        )
                                    }
                                    viewModel.onProgress(progressState.progress + 0.25f)
                                }
                            },
                            onBusinessAccountClicked = { },
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        )

                        1 -> NameComponent(
                            nameState = nameState,
                            onNameEntered = { name -> viewModel.onNameEntered(name) },
                            onButtonClicked = {
                                coroutineScope.launch {
                                    withContext(Dispatchers.Main) {
                                        delay(100)
                                        pagerState.scrollToPage(
                                            pagerState.currentPage + 1
                                        )
                                    }
                                    viewModel.onProgress(progressState.progress + 0.25f)
                                }
                            },
                            modifier = Modifier.fillMaxSize()
                        )

                        2 -> LocationComponent(
                            state = searchState,
                            onSearch = viewModel::onSearch,
                            countries = countries,
                            modifier = Modifier
                                .fillMaxSize()
                                .background(MaterialTheme.colorScheme.background),
                            onCountryClick = viewModel::selectCountry,
                            selectedCountry = selectedCountry,
                            onButtonClick = {  }
                        )
                    }
                }
            }

//            AccountKindComponent(onPersonalAccountClicked = { }, onBusinessAccountClicked = {},
//                modifier = Modifier.fillMaxSize()
//            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StagePager(
    modifier: Modifier = Modifier,
    components: List<Component>,
    pagerState: PagerState
) {

    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        HorizontalPager(state = pagerState) { page ->
            Column(
                content = {
                    components[page].component
                }
            )
        }
    }

}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SignUpStepsScreenPreview() {
    SwiftPayTheme {
        SignUpStepsScreen(rememberNavController())
    }
}

@Composable
fun AppBarWithProgress(modifier: Modifier = Modifier, progressState: ProgressState,
                       onBackClicked: () -> Unit) {
    val progress by animateFloatAsState(
        targetValue = progressState.progress, label = "",
        animationSpec = tween(durationMillis = 1500, easing = FastOutSlowInEasing)
    )
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        AppBar(onBackClicked = onBackClicked)
        LinearProgressIndicator(
            modifier = Modifier
                .weight(.2f)
                .height(10.dp)
                .clip(RoundedCornerShape(10.dp)),
            progress = progress,
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.secondaryContainer,
        )

        Spacer(modifier = Modifier.width(50.dp))
    }
}

@Preview
@Composable
fun AppBarWithProgressPreview() {
    SwiftPayTheme {
        AppBarWithProgress(progressState = ProgressState()){}
    }
}