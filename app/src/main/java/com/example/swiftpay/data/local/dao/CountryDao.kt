package com.example.swiftpay.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.example.swiftpay.domain.model.Country
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDao {

    @Upsert
    suspend fun upsertCountries(countries: List<Country>)

    @Query("SELECT * FROM `Country` ORDER BY `id` ASC")
    fun getCountries(): Flow<List<Country>>

    @Query("SELECT * FROM `Country` WHERE NAME LIKE :name ORDER BY `id` ASC")
    fun searchCountry(name: String): Flow<List<Country>>

    @Query("UPDATE `Country` SET `isSelected` = 0")
    suspend fun unSelectAllCountries()

    @Query("UPDATE `Country` SET `isSelected` = 1 WHERE `id` = :id")
    suspend fun markCountryAsSelected(id: Int)

    @Query("UPDATE `Country` SET `isSelected` = 0 WHERE `id` = :id")
    suspend fun markCountryAsUnSelected(id: Int)

    @Query("SELECT * FROM `Country` WHERE `isSelected` = 1")
    fun getSelectedCountry(): Flow<Country?>

    @Transaction
    suspend fun selectCountry(id: Int) {
        unSelectAllCountries()
        markCountryAsSelected(id)
    }

}