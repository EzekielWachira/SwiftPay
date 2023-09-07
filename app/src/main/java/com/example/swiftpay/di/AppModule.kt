package com.example.swiftpay.di

import android.content.Context
import com.example.swiftpay.qr_code.BarcodeScanner
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    fun provideBarcodeScanner(@ApplicationContext appContext: Context) = BarcodeScanner(appContext)

}