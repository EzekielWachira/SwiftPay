package com.example.swiftpay.ui.screens.request_money.request_now

import androidx.lifecycle.ViewModel
import com.example.swiftpay.ui.screens.request_money.request_now.state.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RequestNowViewModel @Inject constructor(): ViewModel() {

    private val _requestState = MutableStateFlow(RequestState())
    val requestState get() = _requestState.asStateFlow()


    fun onAmountChange(amount: String) {
        _requestState.update {
            requestState.value.copy(amount = amount)
        }
    }

    fun onNoteChange(note: String) {
        _requestState.update {
            requestState.value.copy(note = note)
        }
    }


}