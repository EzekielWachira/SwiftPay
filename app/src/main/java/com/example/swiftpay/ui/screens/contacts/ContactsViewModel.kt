package com.example.swiftpay.ui.screens.contacts

import androidx.lifecycle.ViewModel
import com.example.swiftpay.ui.screens.contacts.components.Contact
import com.example.swiftpay.ui.screens.contacts.components.searchContacts
import com.example.swiftpay.ui.screens.sign_up_steps.state.SearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ContactsViewModel @Inject constructor() : ViewModel() {

    private val _searchState = MutableStateFlow(SearchState())
    val searchState get() = _searchState.asStateFlow()

    private var _contacts = MutableStateFlow<List<Contact>>(emptyList())
    val contacts get() = _contacts.asStateFlow()

    fun onSearch(query: String) {
        _searchState.update {
            searchState.value.copy(query = query)
        }

        if (query.isNotBlank()) {
            _contacts.update {
                searchContacts.filter { cn ->
                    cn.name.contains(query, ignoreCase = true)
                }
            }
        } else _contacts.update { emptyList() }
    }

}