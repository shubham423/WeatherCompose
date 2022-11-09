package com.example.weathercompose.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weathercompose.R
import com.example.weathercompose.ui.components.*
import com.example.weathercompose.ui.theme.DarkGray
import com.example.weathercompose.ui.theme.LightGray
import com.example.weathercompose.ui.theme.WeatherComposeTheme

data class HomeScreenState(
    val currentWeather: CurrentWeather,
    val currentConditions: List<CurrentCondition>,
    val hourlyForecast: List<HourlyForecast>
)

@Composable
fun HomeScreen(
    state: HomeScreenState,
    modifier: Modifier = Modifier
) {
    val gradientColors = if (isSystemInDarkTheme()) {
        listOf(
            DarkGray,
            Color.Black.copy(alpha = 0.5f)
        )
    } else {
        listOf(
            Color.White,
            LightGray
        )
    }
    Scaffold(
        modifier = modifier.background(brush = Brush.verticalGradient(colors = gradientColors)),
        bottomBar = { Navigation() },
        backgroundColor = Color.Unspecified
    ) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            CurrentWeatherField(currentWeather = state.currentWeather)
            CurrentConditionsRow(
                currentConditions = state.currentConditions,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            HourlyForecastSheet(
                hourlyForecast = state.hourlyForecast,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    val state = HomeScreenState(
        currentWeather = CurrentWeather(
            "New york",
            "Today 12 july",
            R.drawable.ic_sunnycloudy,
            "Lightly Cloudy"
        ),
        currentConditions = listOf(
            CurrentCondition("Wind", "234"),
            CurrentCondition("Temp", "23"),
            CurrentCondition("Humidity", "34%"),
        ),
        hourlyForecast = List(7) {
            HourlyForecast(
                "cloudy", R.drawable.ic_cloudy,
                hour = "19:00",
                temperature = "20"
            )
        }
    )
    WeatherComposeTheme {
        HomeScreen(state = state)
    }
}