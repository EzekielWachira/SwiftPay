package com.example.swiftpay.domain.repository

import com.example.swiftpay.domain.model.Country
import kotlinx.coroutines.flow.Flow

interface CountryRepository {

    fun getCountries(): Flow<List<Country>>
    fun searchCountry(name: String): Flow<List<Country>>
    suspend fun markCountryAsUnSelected(id: Int)
    fun getSelectedCountry(): Flow<Country?>
    suspend fun selectCountry(id: Int)

}