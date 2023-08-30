package com.example.swiftpay.ui.screens.sign_up_steps

import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.lifecycle.ViewModel
import com.example.swiftpay.ui.screens.sign_up_steps.components.Country
import com.example.swiftpay.ui.screens.sign_up_steps.components.countriesList
import com.example.swiftpay.ui.screens.sign_up_steps.state.NameState
import com.example.swiftpay.ui.screens.sign_up_steps.state.ProgressState
import com.example.swiftpay.ui.screens.sign_up_steps.state.SearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SignUpStepsViewModel @Inject constructor(): ViewModel() {

    private val _nameState = MutableStateFlow(NameState())
    val nameState get() = _nameState.asStateFlow()

    private val _progressState = MutableStateFlow(ProgressState())
    val progressState get() = _progressState.asStateFlow()

    private val _searchState = MutableStateFlow(SearchState())
    val searchState get() = _searchState.asStateFlow()

    private val _countries = MutableStateFlow(countriesList)
    val countries get() = _countries.asStateFlow()


    init {
        _countries.value = countriesList
    }

    fun onNameEntered(name: String) {
        _nameState.update {
            nameState.value.copy(name = name)
        }
    }

    fun onProgress(progress: Float) {
        _progressState.update {
            progressState.value.copy(
                progress = progress
            )
        }
    }

    fun onSearch(text: String) {
        _searchState.update {
            searchState.value.copy(query = text)
        }

        _countries.update {
            countries.value.filter { it.name.contains(text) }
        }
    }

    fun onCountrySelect(country: Country, index: Int) {
        _countries.value.forEach { it.isSelected = false }
        _countries.value = countries.value.also {
            it[index].isSelected = true
        }
    }

}