package com.example.swiftpay.ui.screens.insights.components

import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.carlosgub.kotlinm.charts.ChartAnimation
import com.carlosgub.kotlinm.charts.bar.BarChart
import com.carlosgub.kotlinm.charts.bar.BarChartCategory
import com.carlosgub.kotlinm.charts.bar.BarChartColors
import com.carlosgub.kotlinm.charts.bar.BarChartConfig
import com.carlosgub.kotlinm.charts.bar.BarChartData
import com.carlosgub.kotlinm.charts.bar.BarChartEntry
import com.example.swiftpay.R
import com.example.swiftpay.ui.theme.DpDimensions
import com.example.swiftpay.ui.theme.Green67
import com.example.swiftpay.ui.theme.Red65
import com.example.swiftpay.ui.theme.SwiftPayTheme
import com.patrykandpatrick.vico.compose.axis.horizontal.rememberBottomAxis
import com.patrykandpatrick.vico.compose.axis.vertical.rememberStartAxis
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.line.lineChart
import com.patrykandpatrick.vico.core.entry.entryModelOf

@Composable
fun ChartComponent(modifier: Modifier = Modifier) {
    val chartEntryModel = entryModelOf(4f, 12f, 8f, 16f)
    Chart(
        chart = lineChart(), model = chartEntryModel,
        startAxis = rememberStartAxis(),
        bottomAxis = rememberBottomAxis(),
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    )
}

@Composable
fun ChartComponent(
    modifier: Modifier = Modifier,
    onFilterClick: (String) -> Unit
) {


    var expanded by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current

    val barChartData = BarChartData(
        categories = listOf(
            BarChartCategory(
                name = "17",
                entries = listOf(
                    BarChartEntry(
                        x = "primary",
                        y = 17f,
                        color = Green67,
                    ),
                    BarChartEntry(
                        x = "secondary",
                        y = 39f,
                        color = Red65,
                    ),
                )
            ),
            BarChartCategory(
                name = "18",
                entries = listOf(
                    BarChartEntry(
                        x = "primary",
                        y = 5f,
                        color = Green67,
                    ),
                    BarChartEntry(
                        x = "secondary",
                        y = 24f,
                        color = Red65,
                    ),
                )
            ),
            BarChartCategory(
                name = "19",
                entries = listOf(
                    BarChartEntry(
                        x = "primary",
                        y = 17f,
                        color = Green67,
                    ),
                    BarChartEntry(
                        x = "secondary",
                        y = 30f,
                        color = Red65,
                    ),
                )
            ),
            BarChartCategory(
                name = "20",
                entries = listOf(
                    BarChartEntry(
                        x = "primary",
                        y = 23f,
                        color = Green67,
                    ),
                    BarChartEntry(
                        x = "secondary",
                        y = 32f,
                        color = Red65,
                    ),
                )
            ),
            BarChartCategory(
                name = "21",
                entries = listOf(
                    BarChartEntry(
                        x = "primary",
                        y = 23f,
                        color = Green67,
                    ),
                    BarChartEntry(
                        x = "secondary",
                        y = 38f,
                        color = Red65,
                    ),
                )
            ),
            BarChartCategory(
                name = "22",
                entries = listOf(
                    BarChartEntry(
                        x = "primary",
                        y = 34f,
                        color = Green67,
                    ),
                    BarChartEntry(
                        x = "secondary",
                        y = 45f,
                        color = Red65,
                    ),
                )
            ),
        )
    )


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
            modifier = Modifier.padding(DpDimensions.Small)
        ) {

            Spacer(modifier = Modifier.height(DpDimensions.Small))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Show Chart in",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    modifier = Modifier.weight(1f)
                )


                Box(
                    contentAlignment = Alignment.BottomEnd,
                    modifier = Modifier
                        .border(
                            1.dp, color = MaterialTheme.colorScheme.inverseSurface,
                            shape = RoundedCornerShape(DpDimensions.Dp20)
                        )
                        .clip(RoundedCornerShape(DpDimensions.Dp20))
                        .clickable { expanded = !expanded }
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(
                            horizontal = DpDimensions.Normal,
                            vertical = DpDimensions.Small
                        )
                    ) {
                        Text(
                            text = "Last 7 days",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.inversePrimary,
                        )

                        Spacer(modifier = Modifier.width(DpDimensions.Small))

                        Icon(
                            painter = painterResource(
                                id = if (expanded) R.drawable.chevron_up
                                else R.drawable.chevron_down
                            ),
                            contentDescription = null,
                            modifier = Modifier.size(DpDimensions.Normal)
                        )
                    }

                    androidx.compose.animation.AnimatedVisibility(
                        visible = expanded,
                        enter = slideInVertically(initialOffsetY = { it }),
                        exit = slideOutVertically(targetOffsetY = { it })
                    ) {
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                            modifier = Modifier.background(MaterialTheme.colorScheme.background)
                        ) {
                            DropdownMenuItem(text = {
                                Text(
                                    text = "Menu Item 1",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.inversePrimary
                                )
                            }, onClick = { context.showToast("Menu Item 1") })

                            DropdownMenuItem(text = {
                                Text(
                                    text = "Menu Item 2",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.inversePrimary
                                )
                            }, onClick = { context.showToast("Menu Item 2") })

                            DropdownMenuItem(text = {
                                Text(
                                    text = "Menu Item 3",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.inversePrimary
                                )
                            }, onClick = { context.showToast("Menu Item 3") })

                            DropdownMenuItem(text = {
                                Text(
                                    text = "Menu Item 4",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.inversePrimary
                                )
                            }, onClick = { context.showToast("Menu Item 4") })

                            DropdownMenuItem(text = {
                                Text(
                                    text = "Menu Item 5",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.inversePrimary
                                )
                            }, onClick = { context.showToast("Menu Item 5") })

                            DropdownMenuItem(text = {
                                Text(
                                    text = "Menu Item 6",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.inversePrimary
                                )
                            }, onClick = { context.showToast("Menu Item 6") })
                        }
                    }

                }
            }

            Spacer(modifier = Modifier.height(DpDimensions.Normal))

            Divider(color = MaterialTheme.colorScheme.inverseSurface)

            Spacer(modifier = Modifier.height(DpDimensions.Normal))



            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        MaterialTheme.colorScheme.background,
                    )
                    .height(250.dp)
            ) {
                BarChart(
                    data = barChartData,
                    config = BarChartConfig(
                        thickness = 10.dp,
                        cornerRadius = 7.dp,
                    ),
                    modifier = Modifier.height(230.dp),
                    animation = ChartAnimation.Sequenced(),
                    colors = BarChartColors(
                        grid = MaterialTheme.colorScheme.background,
                        surface = MaterialTheme.colorScheme.background,
                    )
                )
            }

        }

    }

}


@Preview
@Composable
fun ChartComponentPreview() {
    SwiftPayTheme {
        ChartComponent(onFilterClick = {})
    }
}