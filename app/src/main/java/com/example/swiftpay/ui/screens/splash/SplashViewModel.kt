package com.example.swiftpay.ui.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swiftpay.data.repository.PreferenceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val preferenceRepository: PreferenceRepository
): ViewModel() {

    val isLoggedIn = preferenceRepository.isUserLoggedIn

    fun saveIsLoggedIn(isLoggedIn: Boolean) {
        viewModelScope.launch {
            preferenceRepository.saveUserLoggedInStatus(isLoggedIn)
        }
    }

}