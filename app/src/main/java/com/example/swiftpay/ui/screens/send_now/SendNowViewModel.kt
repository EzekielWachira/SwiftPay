package com.example.swiftpay.ui.screens.send_now

import androidx.lifecycle.ViewModel
import com.example.swiftpay.ui.screens.send_now.state.SendMoneyState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SendNowViewModel @Inject constructor(): ViewModel() {

    private val _sendMoneyState = MutableStateFlow(SendMoneyState())
    val sendMoneyState get() = _sendMoneyState.asStateFlow()


    fun onAmountChange(amount: String) {
        _sendMoneyState.update {
            sendMoneyState.value.copy(amount = amount)
        }
    }

    fun onNoteChange(note: String) {
        _sendMoneyState.update {
            sendMoneyState.value.copy(note = note)
        }
    }


}