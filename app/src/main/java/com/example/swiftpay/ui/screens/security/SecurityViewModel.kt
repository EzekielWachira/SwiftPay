package com.example.swiftpay.ui.screens.security

import androidx.lifecycle.ViewModel
import com.example.swiftpay.ui.screens.security.state.SecurityState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SecurityViewModel @Inject constructor(): ViewModel() {

    private val _securityState = MutableStateFlow(SecurityState())
    val securityState get() = _securityState.asStateFlow()

    fun onBiometric(isChecked: Boolean) {
        _securityState.update {
            securityState.value.copy(biometricId = isChecked)
        }
    }

    fun onRememberMe(isChecked: Boolean) {
        _securityState.update {
            securityState.value.copy(rememberMe = isChecked)
        }
    }
    fun onFaceId(isChecked: Boolean) {
        _securityState.update {
            securityState.value.copy(faceId = isChecked)
        }
    }
    fun onSmsAuthenticator(isChecked: Boolean) {
        _securityState.update {
            securityState.value.copy(smsAuthenticator = isChecked)
        }
    }
    fun onGoogleAuthenticator(isChecked: Boolean) {
        _securityState.update {
            securityState.value.copy(googleAuthenticator = isChecked)
        }
    }

}