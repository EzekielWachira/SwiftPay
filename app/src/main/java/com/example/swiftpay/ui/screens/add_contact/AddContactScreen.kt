package com.example.swiftpay.ui.screens.add_contact

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.swiftpay.R
import com.example.swiftpay.ui.navigation.NavDestinations
import com.example.swiftpay.ui.screens.add_contact.components.AddAccountSuccess
import com.example.swiftpay.ui.screens.common.AppBarWithTwoActions
import com.example.swiftpay.ui.screens.common.CommonTextField
import com.example.swiftpay.ui.screens.common.EmailComponent
import com.example.swiftpay.ui.screens.common.TwoButtons
import com.example.swiftpay.ui.theme.BlueGrey11
import com.example.swiftpay.ui.theme.DpDimensions
import com.example.swiftpay.ui.theme.SwiftPayTheme
import com.example.swiftpay.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddContactScreen(navController: NavController) {

    val viewModel: AddContactViewModel = hiltViewModel()
    val state by viewModel.addContact.collectAsStateWithLifecycle()
    val bottomSheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }



    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()


    SideEffect {
        systemUiController.setSystemBarsColor(
            color = if (useDarkIcons)
                White else BlueGrey11,
            darkIcons = useDarkIcons
        )
    }


    Scaffold(
        topBar = {
            AppBarWithTwoActions(
                onLeftButtonClick = { navController.popBackStack() },
                onRightButtonClick = { },
                rightIcon = Icons.Outlined.ArrowBack,
                leftIcon = Icons.Outlined.ArrowBack,
                toolbarTitle = stringResource(id = R.string.add_new_contact),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.background),
                isRightIconVisible = false
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            Column(
                modifier = Modifier.fillMaxSize()
            ) {


                Column(
                    modifier = Modifier
                        .padding(horizontal = DpDimensions.Normal)
                        .weight(1f)
                ) {

                    Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                    Text(
                        text = stringResource(R.string.account_holder_name),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.inversePrimary
                    )
                    Spacer(modifier = Modifier.height(DpDimensions.Normal))

                    CommonTextField(
                        text = state.name,
                        placeholder = "Name",
                        onTextChange = viewModel::onNameChange
                    )

                    Spacer(modifier = Modifier.height(DpDimensions.Dp20))
                    Text(
                        text = stringResource(R.string.email),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.inversePrimary
                    )
                    Spacer(modifier = Modifier.height(DpDimensions.Normal))
                    EmailComponent(email = state.email, onEmailChange = viewModel::onEmailChange)
                }


                TwoButtons(
                    leftButtonText = stringResource(R.string.cancel),
                    rightButtonText = stringResource(R.string.save_contact),
                    onLeftButtonClick = { navController.popBackStack() },
                    onRightButtonClick = { isSheetOpen = !isSheetOpen })

            }

            if (isSheetOpen) {
                AddAccountSuccess(bottomSheetState = bottomSheetState) {
                    isSheetOpen = false
                }
            }
        }

    }

}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun AddContactScreenPreview() {
    SwiftPayTheme {
        AddContactScreen(rememberNavController())
    }
}