package com.example.swiftpay.ui.screens.sign_in

import androidx.lifecycle.ViewModel
import com.example.swiftpay.extensions.isValidEmail
import com.example.swiftpay.extensions.isValidPassword
import com.example.swiftpay.ui.screens.sign_in.state.EmailPasswordState
import com.example.swiftpay.ui.screens.sign_in.state.SwitchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(): ViewModel(){

    private var _emailPasswordState = MutableStateFlow(EmailPasswordState())
    val emailPasswordState get() = _emailPasswordState.asStateFlow()
    private var _switchState = MutableStateFlow(SwitchState())
    val switchState get() = _switchState.asStateFlow()

    fun onEmailTextEntered(email: String) {
        _emailPasswordState.update {
            emailPasswordState.value.copy(
                isValidEmail = email.isValidEmail(),
                email = email
            )
        }
    }

    fun onPasswordEntered(password: String) {
        _emailPasswordState.update {
            emailPasswordState.value.copy(
                isValidPassword = password.isValidPassword(),
                password = password
            )
        }
    }

    fun onSwitchChecked(isChecked: Boolean) {
        _switchState.update {
            switchState.value.copy(
                isChecked = isChecked
            )
        }
    }

}