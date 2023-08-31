package com.example.swiftpay.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.swiftpay.data.local.dao.CountryDao
import com.example.swiftpay.domain.model.Country

@Database(
    entities = [
        Country::class
    ],
    version = 1,
    exportSchema = true
)
abstract class SwiftPayDatabase: RoomDatabase() {
    abstract val countryDao: CountryDao
}
