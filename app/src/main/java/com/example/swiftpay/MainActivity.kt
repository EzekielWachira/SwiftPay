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
import com.example.swiftpay.ui.screens.main.MainScreen
import com.example.swiftpay.ui.screens.reset_password.ResetPasswordScreen
import com.example.swiftpay.ui.screens.sign_in.SignInScreen
import com.example.swiftpay.ui.screens.sign_up_steps.SignUpStepsScreen
import com.example.swiftpay.ui.screens.splash.SplashMain
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
                SplashMain()
            }
        }
    }
}
