package com.example.swiftpay.ui.screens.amount

import androidx.lifecycle.ViewModel
import com.example.swiftpay.ui.screens.amount.state.AmountState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class AmountViewModel @Inject constructor() : ViewModel() {

    private val _amountState = MutableStateFlow(AmountState())
    val amountState get() = _amountState.asStateFlow()

    fun onAmountChange(value: String) {
        if (amountState.value.amount.contains(".") &&
            amountState.value.amount.substring(
                amountState.value.amount.indexOf(".") + 1
            ).length == 2
        )
            return
//        if (value == "." && amountState.value.amount.contains("."))
//            return
//
//        if (amountState.value.amount.isBlank() && value == ".")
//            return
//
//        if (amountState.value.amount.isBlank() && value == "0")
//            return

        _amountState.update {
            amountState.value.copy(
                amount = amountState.value.amount + value
            )
        }
    }

    fun onDelete(initial: String) {
        _amountState.update {
            amountState.value.copy(
                amount = removeLastChar(initial)
            )
        }
    }

    private fun removeLastChar(s: String?): String {
        if (s.isNullOrEmpty()) {
            return s!!
        }
        return s.substring(0, s.length - 1)
    }


}