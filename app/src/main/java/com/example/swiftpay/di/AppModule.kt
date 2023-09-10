package com.example.swiftpay.di

import android.content.Context
import com.example.swiftpay.data.repository.PreferenceRepository
import com.example.swiftpay.qr_code.BarcodeScanner
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    fun provideBarcodeScanner(@ApplicationContext appContext: Context) = BarcodeScanner(appContext)

    @Provides
    @Singleton
    fun providePreferenceRepository(@ApplicationContext appContext: Context) =
        PreferenceRepository(appContext)

}