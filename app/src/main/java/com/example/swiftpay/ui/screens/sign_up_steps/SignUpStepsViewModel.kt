package com.example.swiftpay.ui.screens.sign_up_steps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.swiftpay.domain.model.Country
import com.example.swiftpay.domain.repository.CountryRepository
import com.example.swiftpay.ui.screens.sign_up_steps.state.NameState
import com.example.swiftpay.ui.screens.sign_up_steps.state.ProgressState
import com.example.swiftpay.ui.screens.sign_up_steps.state.SearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpStepsViewModel @Inject constructor(
    private val countryRepository: CountryRepository
) : ViewModel() {

    private val _nameState = MutableStateFlow(NameState())
    val nameState get() = _nameState.asStateFlow()

    private val _progressState = MutableStateFlow(ProgressState())
    val progressState get() = _progressState.asStateFlow()

    private val _searchState = MutableStateFlow(SearchState())
    val searchState get() = _searchState.asStateFlow()

    private val _countries =
        MutableStateFlow<List<Country>>(emptyList())
    val countries get() = _countries.asStateFlow()

    val selectedCountry =
        countryRepository.getSelectedCountry()
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(),
                null
            )



    fun getCountries() {
        viewModelScope.launch {
            countryRepository.getCountries().collectLatest {
                _countries.emit(it)
            }
        }
    }

    private fun searchCountry(query: String) {
        viewModelScope.launch {
            countryRepository.searchCountry(query).collectLatest {
                _countries.emit(it)
            }
        }
    }

    fun selectCountry(country: Country) {
        viewModelScope.launch {
            countryRepository.selectCountry(country.id)
        }
    }


    fun unSelectCountry(country: Country) {
        viewModelScope.launch {
            countryRepository.markCountryAsUnSelected(country.id)
        }
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

        if (text.isEmpty()) getCountries()
        else searchCountry(text)
    }

    fun onCountrySelect(country: Country, index: Int) {
        _countries.value.forEach { it.isSelected = false }
        _countries.value = countries.value.also {
            it[index].isSelected = true
        }
    }

}