package com.example.swiftpay.ui.screens.security

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.swiftpay.R
import com.example.swiftpay.ui.screens.common.AppBarWithTwoActions
import com.example.swiftpay.ui.screens.common.TextWithRightChevron
import com.example.swiftpay.ui.screens.security.components.SecurityItem
import com.example.swiftpay.ui.theme.DpDimensions
import com.example.swiftpay.ui.theme.SwiftPayTheme

@Composable
fun SecurityScreen(navController: NavController) {
    val viewModel: SecurityViewModel = hiltViewModel()

    val securityState by viewModel.securityState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            AppBarWithTwoActions(
                onLeftButtonClick = { navController.popBackStack() },
                onRightButtonClick = { },
                rightIcon = Icons.Outlined.ArrowBack,
                leftIcon = Icons.Outlined.ArrowBack,
                toolbarTitle = stringResource(id = R.string.security),
                isRightIconVisible = false
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = DpDimensions.Normal)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(DpDimensions.Small)
        ) {

            SecurityItem(
                onCheckChange = viewModel::onRememberMe,
                isChecked = { securityState.rememberMe },
                text = stringResource(id = R.string.remember_me)
            )

            SecurityItem(
                onCheckChange = viewModel::onBiometric,
                isChecked = { securityState.biometricId },
                text = stringResource(id = R.string.biometric_id)
            )
            SecurityItem(
                onCheckChange = viewModel::onFaceId,
                isChecked = { securityState.faceId },
                text = stringResource(id = R.string.face_id)
            )
            SecurityItem(
                onCheckChange = viewModel::onSmsAuthenticator,
                isChecked = { securityState.smsAuthenticator },
                text = stringResource(
                    id = R.string.sms_authenticator
                )
            )
            SecurityItem(
                onCheckChange = viewModel::onGoogleAuthenticator,
                isChecked = { securityState.googleAuthenticator },
                text = stringResource(id = R.string.google_authenticator)
            )
            TextWithRightChevron(
                icon = R.drawable.chevron_right,
                title = stringResource(R.string.device_management)
            ) { }

            Spacer(modifier = Modifier.height(DpDimensions.Dp20))

            OutlinedButton(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.onPrimary)
            ) {
                Text(
                    text = stringResource(R.string.change_password),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSecondary
                )
            }

        }
    }

}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SecurityScreenPreview() {
    SwiftPayTheme {
        SecurityScreen(rememberNavController())
    }
}