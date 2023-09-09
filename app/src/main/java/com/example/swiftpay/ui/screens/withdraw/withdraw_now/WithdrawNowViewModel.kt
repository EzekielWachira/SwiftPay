package com.example.swiftpay.ui.screens.withdraw.withdraw_now

import androidx.lifecycle.ViewModel
import com.example.swiftpay.ui.screens.withdraw.withdraw_now.state.WithdrawState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class WithdrawNowViewModel @Inject constructor() : ViewModel() {

    private val _withdraw = MutableStateFlow(WithdrawState())
    val withdraw get() = _withdraw.asStateFlow()


    fun onAmountChange(amount: String) {
        _withdraw.update {
            withdraw.value.copy(amount = amount)
        }
    }

    fun onNoteChange(note: String) {
        _withdraw.update {
            withdraw.value.copy(note = note)
        }
    }

}