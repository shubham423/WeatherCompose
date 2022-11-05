package com.example.weathercompose.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weathercompose.R
import com.example.weathercompose.ui.theme.Black
import com.example.weathercompose.ui.theme.WeatherComposeTheme

data class CurrentWeather(
    val location: String,
    val date: String,
    @DrawableRes val weatherIcon: Int,
    val weatherDescription: String,
)

@Composable
fun CurrentWeatherField(
    currentWeather: CurrentWeather,
    modifier: Modifier = Modifier
) = Column(modifier = modifier.padding(16.dp)) {

    val textColor = if (isSystemInDarkTheme()) {
        Color.White
    } else {
        Black
    }

    CompositionLocalProvider(LocalContentColor provides textColor) {

        Text(
            text = currentWeather.location,
            style = MaterialTheme.typography.h5.copy(
                fontWeight = FontWeight.Medium
            )
        )
        Text(
            text = currentWeather.date,
            style = MaterialTheme.typography.subtitle2.copy(
                fontWeight = FontWeight.Normal
            )
        )
        Icon(
            painter = painterResource(id = currentWeather.weatherIcon),
            contentDescription = null,
            tint = Color.Unspecified
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = currentWeather.weatherDescription,
            style = MaterialTheme.typography.h4.copy(
                fontWeight = FontWeight.Medium
            )
        )
    }
}

@Preview(showBackground = true,
    backgroundColor = 0xfffff)
@Composable
fun CurrentWeatherFieldPreview() {
    WeatherComposeTheme {
        CurrentWeatherField(
            currentWeather = CurrentWeather(
                "New York",
                "Today, 12 July",
                R.drawable.ic_sunnycloudy,
                "Sunny Cloudy"
            )
        )
    }
}