package com.example.weathercompose.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weathercompose.R
import com.example.weathercompose.ui.theme.Black
import com.example.weathercompose.ui.theme.WeatherComposeTheme

data class HourlyForecast(
    val description: String,
    @DrawableRes val icon: Int,
    val hour: String,
    val temperature: String
)

@Composable
fun HourlyForecastCard(
    hourlyForecast: HourlyForecast,
    modifier: Modifier = Modifier
) = Card(
    modifier = modifier,
) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = hourlyForecast.icon),
            contentDescription = hourlyForecast.description,
            modifier = Modifier.size(36.dp),
            tint = Color.Unspecified
        )
        Text(
            text = hourlyForecast.hour,
            style = MaterialTheme.typography.body2,
            color = Black
        )
        Text(
            text = hourlyForecast.temperature,
            style = MaterialTheme.typography.body1
        )

    }
}

@Preview
@Composable
fun HourlyForecastCardPreview() {
    val hourlyForecast = HourlyForecast(
        "cloudy", R.drawable.ic_cloudy,
        hour = "19:00",
        temperature = "20"
    )
    WeatherComposeTheme {
        HourlyForecastCard(hourlyForecast = hourlyForecast)
    }
}


@Preview
@Composable
fun HourlyForecastCardPreviewDark() {
    val hourlyForecast = HourlyForecast(
        "cloudy", R.drawable.ic_cloudy,
        hour = "19:00",
        temperature = "20"
    )
    WeatherComposeTheme(darkTheme = true) {
        HourlyForecastCard(hourlyForecast = hourlyForecast)
    }
}