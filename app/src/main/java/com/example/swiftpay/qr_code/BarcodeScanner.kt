package com.example.swiftpay.qr_code

import android.content.Context
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.tasks.await

class BarcodeScanner(
    appContext: Context
) {

    /**
     * From the docs: If you know which barcode formats you expect to read, you can improve the
     * speed of the barcode detector by configuring it to only detect those formats.
     */
    private val options = GmsBarcodeScannerOptions.Builder()
        .setBarcodeFormats(
            Barcode.FORMAT_QR_CODE
        )
        .build()

    private val scanner = GmsBarcodeScanning.getClient(appContext, options)
    val barCodeResults = MutableStateFlow<String?>(null)

    suspend fun startScan() {
        try {
            val result = scanner.startScan().await()
            barCodeResults.value = result.rawValue
        } catch (e: Exception) {
        }
    }

    /* alt:
    scanner.startScan()
    .addOnSuccessListener { barcode ->
        // Task completed successfully
    }
    .addOnCanceledListener {
        // Task canceled
    }
    .addOnFailureListener { e ->
        // Task failed with an exception
    }*/

}