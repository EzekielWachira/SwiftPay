package com.example.swiftpay.ui.screens.add_contact

import androidx.lifecycle.ViewModel
import com.example.swiftpay.ui.screens.add_contact.state.AddContactState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class AddContactViewModel @Inject constructor() : ViewModel() {

    private val _addContact = MutableStateFlow(AddContactState())
    val addContact get() = _addContact.asStateFlow()


    fun onNameChange(name: String) {
        _addContact.update {
            addContact.value.copy(name = name)
        }
    }

    fun onEmailChange(email: String) {
        _addContact.update {
            addContact.value.copy(email = email)
        }
    }

}