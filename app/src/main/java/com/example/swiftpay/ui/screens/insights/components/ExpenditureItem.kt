package com.example.swiftpay.ui.screens.insights.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.carlosgub.kotlinm.charts.ChartAnimation
import com.carlosgub.kotlinm.charts.line.LineChart
import com.carlosgub.kotlinm.charts.line.LineChartData
import com.carlosgub.kotlinm.charts.line.LineChartPoint
import com.carlosgub.kotlinm.charts.line.LineChartSeries
import com.example.swiftpay.ui.theme.DpDimensions
import com.example.swiftpay.ui.theme.Green67

@Composable
fun ExpenditureItem(
    modifier: Modifier = Modifier,
    title: String,
    lineColor: Color,
    value: String
) {

    val lineData = remember {
        LineChartData(
            series = listOf(
                LineChartSeries(
                    dataName = "data ",
                    lineColor = lineColor,
                    lineWidth = 2.dp,
                    listOfPoints = (1..10).map { point ->
                        LineChartPoint(
                            x = point.toLong(),
                            y = (1..15).random().toFloat(),
                        )
                    }
                )
            ),
        )
    }

    Surface(
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.inverseSurface,
        ),
        modifier = modifier,
        shape = RoundedCornerShape(DpDimensions.Small),
        color = MaterialTheme.colorScheme.background
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = DpDimensions.Small)
        ) {

            Column(modifier = Modifier.padding(start = DpDimensions.Small)) {
                Text(
                    text = title, style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.inversePrimary
                )
                Text(
                    text = value, style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.inversePrimary
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            LineChart(
                lineChartData = lineData,
                modifier = Modifier
                    .height(100.dp)
                    .padding(start = 0.dp),
                xAxisLabel = {
                },

                animation = ChartAnimation.Sequenced(),
                yAxisLabel = {
                },
                overlayDataEntryLabel = { xAxisLabel, value ->

                },
                overlayHeaderLabel = {}
            )

        }

    }

}