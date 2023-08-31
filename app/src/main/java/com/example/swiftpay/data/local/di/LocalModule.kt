package com.example.swiftpay.data.local.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.swiftpay.data.local.dao.CountryDao
import com.example.swiftpay.data.local.database.SwiftPayDatabase
import com.example.swiftpay.data.repository.CountryRepositoryImpl
import com.example.swiftpay.data.utils.countriesList
import com.example.swiftpay.domain.repository.CountryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Provider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideSwiftPayDatabase(
        @ApplicationContext context: Context,
        countryDao: Provider<CountryDao>
    ) = Room.databaseBuilder(
        context,
        SwiftPayDatabase::class.java,
        "swiftpay.db"
    ).fallbackToDestructiveMigration()
        .addCallback(object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                CoroutineScope(Dispatchers.IO).launch {
                    countryDao.get().upsertCountries(countriesList)
                }
            }
        }).build()

    @Provides
    @Singleton
    fun provideCountryDao(database: SwiftPayDatabase) = database.countryDao

    @Provides
    @Singleton
    fun provideCountryRepository(database: SwiftPayDatabase): CountryRepository =
        CountryRepositoryImpl(database)

}