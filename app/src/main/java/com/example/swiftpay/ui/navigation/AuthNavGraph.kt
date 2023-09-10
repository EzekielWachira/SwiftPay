package com.example.swiftpay.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.swiftpay.ui.navigation.NavDestinations.Account.PERSONAL_INFO
import com.example.swiftpay.ui.navigation.NavDestinations.Account.PERSONAL_INFO_SCREEN
import com.example.swiftpay.ui.navigation.NavDestinations.Auth.AUTH_MAIN
import com.example.swiftpay.ui.navigation.NavDestinations.Auth.CREATE_ACCOUNT
import com.example.swiftpay.ui.navigation.NavDestinations.Auth.FORGOT_PASSWORD
import com.example.swiftpay.ui.navigation.NavDestinations.Auth.GET_STARTED
import com.example.swiftpay.ui.navigation.NavDestinations.Auth.LOGIN
import com.example.swiftpay.ui.navigation.NavDestinations.Auth.SIGNUP_STEPS
import com.example.swiftpay.ui.navigation.NavDestinations.Auth.SPLASH
import com.example.swiftpay.ui.navigation.NavDestinations.Auth.WALKTHROUGH
import com.example.swiftpay.ui.personal_info.PersonalInfoScreen
import com.example.swiftpay.ui.screens.reset_password.ResetPasswordScreen
import com.example.swiftpay.ui.screens.sign_in.SignInScreen
import com.example.swiftpay.ui.screens.sign_up.SignUpScreen
import com.example.swiftpay.ui.screens.sign_up_steps.SignUpStepsScreen
import com.example.swiftpay.ui.screens.splash.SplashScreen
import com.example.swiftpay.ui.screens.walkthrough.GetStartedScreen
import com.example.swiftpay.ui.screens.walkthrough.OnboardingScreen

fun NavGraphBuilder.authNavGraph(navController: NavController) {
    navigation(
        startDestination = WALKTHROUGH,
        route = AUTH_MAIN
    ) {

        composable(route = WALKTHROUGH,
            enterTransition = {
                slideInVertically(
                    animationSpec = tween(700),
                    initialOffsetY = { it }
                )
            },
            exitTransition = {
                slideOutVertically (
                    animationSpec = tween(700),
                    targetOffsetY = { it }
                )
            }) {
            OnboardingScreen(navController)
        }

        composable(route = GET_STARTED,
            enterTransition = {
                slideInVertically(
                    animationSpec = tween(700),
                    initialOffsetY = { it }
                )
            },
            exitTransition = {
                slideOutVertically (
                    animationSpec = tween(700),
                    targetOffsetY = { it }
                )
            }) {
            GetStartedScreen(navController)
        }

        composable(route = LOGIN,
            enterTransition = {
                slideInVertically(
                    animationSpec = tween(700),
                    initialOffsetY = { it }
                )
            },
            exitTransition = {
                slideOutVertically (
                    animationSpec = tween(700),
                    targetOffsetY = { it }
                )
            }) {
            SignInScreen(navController)
        }

        composable(route = FORGOT_PASSWORD,
            enterTransition = {
                slideInVertically(
                    animationSpec = tween(700),
                    initialOffsetY = { it }
                )
            },
            exitTransition = {
                slideOutVertically (
                    animationSpec = tween(700),
                    targetOffsetY = { it }
                )
            }) {
            ResetPasswordScreen(navController)
        }

        composable(route = CREATE_ACCOUNT,
            enterTransition = {
                slideInVertically(
                    animationSpec = tween(700),
                    initialOffsetY = { it }
                )
            },
            exitTransition = {
                slideOutVertically (
                    animationSpec = tween(700),
                    targetOffsetY = { it }
                )
            }) {
            SignUpScreen(navController)
        }

        composable(route = SIGNUP_STEPS,
            enterTransition = {
                slideInVertically(
                    animationSpec = tween(700),
                    initialOffsetY = { it }
                )
            },
            exitTransition = {
                slideOutVertically (
                    animationSpec = tween(700),
                    targetOffsetY = { it }
                )
            }) {
            SignUpStepsScreen(navController)
        }


    }
}