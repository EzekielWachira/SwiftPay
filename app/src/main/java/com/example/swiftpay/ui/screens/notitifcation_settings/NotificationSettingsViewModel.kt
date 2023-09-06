package com.example.swiftpay.ui.screens.notitifcation_settings

import androidx.lifecycle.ViewModel
import com.example.swiftpay.ui.screens.notitifcation_settings.state.NotificationSettingsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class NotificationSettingsViewModel @Inject constructor(): ViewModel() {

    private val _notificationSettingsState = MutableStateFlow(NotificationSettingsState())
    val notificationSettingsState get() = _notificationSettingsState.asStateFlow()

    fun onStatusUpdate(isChecked: Boolean) {
        _notificationSettingsState.update {
            notificationSettingsState.value.copy(
                statusUpdate = isChecked
            )
        }
    }

    fun onFraudAlert(isChecked: Boolean) {
        _notificationSettingsState.update {
            notificationSettingsState.value.copy(
                fraudAlert = isChecked
            )
        }
    }

    fun onPaymentRequest(isChecked: Boolean) {
        _notificationSettingsState.update {
            notificationSettingsState.value.copy(
                paymentRequest = isChecked
            )
        }
    }

    fun onCardActivity(isChecked: Boolean) {
        _notificationSettingsState.update {
            notificationSettingsState.value.copy(
                cardActivity = isChecked
            )
        }
    }

    fun onSupportNotifications(isChecked: Boolean) {
        _notificationSettingsState.update {
            notificationSettingsState.value.copy(
                supportNotifications = isChecked
            )
        }
    }


    fun onAccountBalance(isChecked: Boolean) {
        _notificationSettingsState.update {
            notificationSettingsState.value.copy(
                accountBalance = isChecked
            )
        }
    }

    fun onSecurityAlert(isChecked: Boolean) {
        _notificationSettingsState.update {
            notificationSettingsState.value.copy(
                securityAlert = isChecked
            )
        }
    }

    fun onDailyWeeklySummary(isChecked: Boolean) {
        _notificationSettingsState.update {
            notificationSettingsState.value.copy(
                dailyWeeklySummary = isChecked
            )
        }
    }

    fun onAppUpdates(isChecked: Boolean) {
        _notificationSettingsState.update {
            notificationSettingsState.value.copy(
                appUpdates = isChecked
            )
        }
    }

    fun onPromotionalOffers(isChecked: Boolean) {
        _notificationSettingsState.update {
            notificationSettingsState.value.copy(
                promotionalOffers = isChecked
            )
        }
    }

    fun onSurvey(isChecked: Boolean) {
        _notificationSettingsState.update {
            notificationSettingsState.value.copy(
                survey = isChecked
            )
        }
    }

}