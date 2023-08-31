package com.example.swiftpay.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.swiftpay.R
import com.example.swiftpay.ui.screens.main.components.MainTopBar

@Composable
fun HomeScreen(navController: NavController) {

    Scaffold(
        topBar = { MainTopBar(onNotificationClick = { }, onLogoClick = { }) }
    ) { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.onPrimary)
            ) {

                Spacer(modifier = Modifier.height(20.dp))

                Row {
                    Text(
                        text = "3,343.34", style = MaterialTheme.typography.titleLarge,
                        fontSize = 35.sp, color = Color.Black
                    )

                    Text(
                        text = "$",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Black
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Available balance",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(60.dp)
                                .clip(CircleShape)
                                .border(1.dp, Color.Black, CircleShape)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.send),
                                contentDescription = "Business icon",
                                modifier = Modifier.size(25.dp),
                                tint = Color.Black
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Send", style = MaterialTheme.typography.titleSmall,
                            color = Color.Black
                        )

                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(60.dp)
                                .clip(CircleShape)
                                .border(1.dp, Color.Black, CircleShape)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.receive_1),
                                contentDescription = "Business icon",
                                modifier = Modifier.size(25.dp),
                                tint = Color.Black
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Request", style = MaterialTheme.typography.titleSmall,
                            color = Color.Black
                        )

                    }


                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(60.dp)
                                .clip(CircleShape)
                                .border(1.dp, Color.Black, CircleShape)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.top_up),
                                contentDescription = "Business icon",
                                modifier = Modifier.size(25.dp),
                                tint = Color.Black
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Top Up", style = MaterialTheme.typography.titleSmall,
                            color = Color.Black
                        )

                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(60.dp)
                                .clip(CircleShape)
                                .border(1.dp, Color.Black, CircleShape)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.withdraw),
                                contentDescription = "Business icon",
                                modifier = Modifier.size(25.dp),
                                tint = Color.Black
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Withdraw", style = MaterialTheme.typography.titleSmall,
                            color = Color.Black
                        )

                    }

                }

                Spacer(modifier = Modifier.height(30.dp))
            }

        }
    }

}