package com.example.swiftpay.ui.screens.scan

import android.Manifest
import android.content.pm.PackageManager
import android.util.Size
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.swiftpay.R
import com.example.swiftpay.qr_code.BarcodeScanner
import com.example.swiftpay.qr_code.QrCodeAnalyzer
import com.example.swiftpay.ui.navigation.NavDestinations.SendMoney.SEND_MONEY_MAIN
import com.example.swiftpay.ui.screens.common.AppBarWithTwoActions
import com.example.swiftpay.ui.screens.main.components.MainTopBar
import com.example.swiftpay.ui.theme.BlueGrey11
import com.example.swiftpay.ui.theme.DpDimensions
import com.example.swiftpay.ui.theme.SwiftPayTheme
import com.example.swiftpay.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch
import javax.inject.Inject

@Composable
fun ScanScreen(navController: NavController) {


    val context = LocalContext.current
    val barcodeScanner = BarcodeScanner(context)

    var code by remember {
        mutableStateOf("")
    }
    val lifecycleOwner = LocalLifecycleOwner.current

    val barcodeResults =
        barcodeScanner.barCodeResults.collectAsStateWithLifecycle()

    val cameraProviderFuture = remember {
        ProcessCameraProvider.getInstance(context)
    }
    var hasCamPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        )
    }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { granted ->
            hasCamPermission = granted
        }
    )

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()


    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Black,
            darkIcons = useDarkIcons
        )

        systemUiController.setNavigationBarColor(
            color = Color.Black,
            darkIcons = true
        )
    }

    LaunchedEffect(key1 = true) {
        launcher.launch(Manifest.permission.CAMERA)
    }


    Scaffold(
        topBar = {
            AppBarWithTwoActions(
                onLeftButtonClick = { navController.popBackStack() },
                onRightButtonClick = { },
                rightIcon = Icons.Outlined.Close,
                leftIcon = Icons.Outlined.Close,
                toolbarTitle = "",
                isRightIconVisible = false,
                modifier = Modifier.background(Color.Black),
                iconColor = White,
                textColor = White
            )
        },
        containerColor = Color.Black
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(all = DpDimensions.Normal)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

//            ScanBarcode(
//                barcodeScanner::startScan,
//                barcodeResults.value
//            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Scan QR Code", style = MaterialTheme.typography.titleLarge,
                color = Color.White)

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Point the camera at the QR Code to scan", style = MaterialTheme.typography.bodyMedium,
                color = Color.White)

            Spacer(modifier = Modifier.height(50.dp))


            if (hasCamPermission) {
                Column(
                    modifier = Modifier.padding(all = DpDimensions.Small)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AndroidView(
                        factory = { context ->
                            val previewView = PreviewView(context)
                            val preview = Preview.Builder().build()
                            val selector = CameraSelector.Builder()
                                .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                                .build()
                            preview.setSurfaceProvider(previewView.surfaceProvider)
                            val imageAnalysis = ImageAnalysis.Builder()
                                .setTargetResolution(
                                    Size(
                                        previewView.width,
                                        previewView.height
                                    )
                                )
                                .setBackpressureStrategy(STRATEGY_KEEP_ONLY_LATEST)
                                .build()
                            imageAnalysis.setAnalyzer(
                                ContextCompat.getMainExecutor(context),
                                QrCodeAnalyzer { result ->
                                    code = result
                                    navController.navigate(SEND_MONEY_MAIN)
                                }
                            )
                            try {
                                cameraProviderFuture.get().bindToLifecycle(
                                    lifecycleOwner,
                                    selector,
                                    preview,
                                    imageAnalysis
                                )
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                            previewView
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .clip(RoundedCornerShape(DpDimensions.Normal))
                            .border(1.dp, color = MaterialTheme.colorScheme.onPrimary,
                                RoundedCornerShape(DpDimensions.Normal) )
                    )
                    Text(
                        text = code,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()


                    )

                }

            }
        }
    }

}

@Composable
private fun ScanBarcode(
    onScanBarcode: suspend () -> Unit,
    barcodeValue: String?
) {
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(
            modifier = Modifier
                .fillMaxWidth(.85f),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            ),
            onClick = {
                scope.launch {
                    onScanBarcode()
                }
            }) {
            Text(
                text = "Scan Barcode",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.inversePrimary,
                //style = TextStyle(fontWeight = FontWeight.Bold)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = barcodeValue ?: "0000000000",
            style = MaterialTheme.typography.displayMedium
        )

    }
}

@androidx.compose.ui.tooling.preview.Preview
@Composable
fun ScanScreenPreview() {
    SwiftPayTheme {
        ScanScreen(rememberNavController())
    }
}