package com.example.swiftpay.ui.screens.top_up.top_up_now

import androidx.lifecycle.ViewModel
import com.example.swiftpay.ui.screens.top_up.top_up_now.state.TopUpState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TopUpNowViewModel @Inject constructor() : ViewModel() {

    private val _topUpState = MutableStateFlow(TopUpState())
    val topUpState get() = _topUpState.asStateFlow()


    fun onAmountChange(amount: String) {
        _topUpState.update {
            topUpState.value.copy(amount = amount)
        }
    }

    fun onNoteChange(note: String) {
        _topUpState.update {
            topUpState.value.copy(note = note)
        }
    }

}