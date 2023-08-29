package com.example.swiftpay.ui.screens.otp

import androidx.lifecycle.ViewModel
import com.example.swiftpay.ui.screens.otp.state.OtpState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class OtpViewModel @Inject constructor(): ViewModel() {

    private val _otpState = MutableStateFlow(OtpState())
    val otpState get() = _otpState.asStateFlow()

    fun onOtpEntered(index: Int, value: String) {
        _otpState.update {
            otpState.value.copy(

            )
        }
    }

}