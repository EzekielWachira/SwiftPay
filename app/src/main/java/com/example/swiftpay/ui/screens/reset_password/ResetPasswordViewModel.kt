package com.example.swiftpay.ui.screens.reset_password

import androidx.lifecycle.ViewModel
import com.example.swiftpay.extensions.isValidEmail
import com.example.swiftpay.ui.screens.reset_password.state.EmailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ResetPasswordViewModel @Inject constructor(): ViewModel() {

    private val _emailState = MutableStateFlow(EmailState())
    val emailState get() = _emailState.asStateFlow()

    fun onEmailEntered(email: String) {
        _emailState.update {
            emailState.value.copy(
                email = email,
                isValidEmail = email.isValidEmail()
            )
        }
    }

}