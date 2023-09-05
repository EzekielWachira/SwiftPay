package com.example.swiftpay.ui.screens.account

import androidx.lifecycle.ViewModel
import com.example.swiftpay.ui.screens.sign_in.state.SwitchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(): ViewModel(){

    private val _switchState = MutableStateFlow(SwitchState())
    val switchState get() = _switchState.asStateFlow()

    fun onCheckChange(isChecked: Boolean) {
        _switchState.update {
            switchState.value.copy(isChecked = isChecked)
        }
    }

}