package com.example.swiftpay.data.repository

import com.example.swiftpay.data.local.database.SwiftPayDatabase
import com.example.swiftpay.domain.model.Country
import com.example.swiftpay.domain.repository.CountryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(private val database: SwiftPayDatabase) :
    CountryRepository {

    override fun getCountries(): Flow<List<Country>> {
        return database.countryDao.getCountries()
    }

    override fun searchCountry(name: String): Flow<List<Country>> {
        return database.countryDao.searchCountry("%$name%")
    }

    override suspend fun markCountryAsUnSelected(id: Int) {
        database.countryDao.markCountryAsUnSelected(id)
    }

    override fun getSelectedCountry(): Flow<Country?> {
        return database.countryDao.getSelectedCountry()
    }

    override suspend fun selectCountry(id: Int) {
        database.countryDao.selectCountry(id)
    }
}