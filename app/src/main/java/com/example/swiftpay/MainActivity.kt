package com.example.swiftpay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.swiftpay.ui.screens.sign_in.SignInScreen
import com.example.swiftpay.ui.screens.splash.SplashScreen
import com.example.swiftpay.ui.screens.walkthrough.GetStartedScreen
import com.example.swiftpay.ui.screens.walkthrough.OnboardingScreen
import com.example.swiftpay.ui.theme.SwiftPayTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwiftPayTheme {
                // A surface container using the 'background' color from the theme
//                OnboardingScreen()
                SignInScreen()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SwiftPayTheme {
        Greeting("Android")
    }
}