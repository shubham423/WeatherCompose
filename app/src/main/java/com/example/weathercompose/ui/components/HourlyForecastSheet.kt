package com.example.weathercompose.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weathercompose.R
import com.example.weathercompose.ui.theme.Gray
import com.example.weathercompose.ui.theme.WeatherComposeTheme

@Composable
fun HourlyForecastSheet(
    hourlyForecast: List<HourlyForecast>,
    modifier: Modifier = Modifier
) = Card(
    modifier = Modifier.fillMaxWidth(),
    backgroundColor = MaterialTheme.colors.primary,
    shape = RoundedCornerShape(
        topStart = CornerSize(16.dp),
        topEnd = CornerSize(16.dp),
        bottomStart = CornerSize(0.dp),
        bottomEnd = CornerSize(0.dp),
    )
) {
    Column(modifier = Modifier.padding(top = 16.dp, bottom = 32.dp)) {
        TopRow()
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(hourlyForecast) { forecast ->
                HourlyForecastCard(hourlyForecast = forecast)
            }
        }
    }
}

@Composable
fun CurrentConditionCard(
    currentConditions: CurrentCondition,
    modifier: Modifier = Modifier
) = Card(
    modifier = modifier,
    backgroundColor = MaterialTheme.colors.primary
) {
    Column(
        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = currentConditions.conditionTitle,
            style = MaterialTheme.typography.caption,
            color = Gray.copy(alpha = 0.5f)
        )

        Text(
            text = currentConditions.conditionValue,
            style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.SemiBold),
            color = MaterialTheme.colors.onSurface
        )
    }
}

data class CurrentCondition(
    val conditionTitle: String,
    val conditionValue: String,
)

@Composable
fun CurrentConditionsRow(
    currentConditions: List<CurrentCondition>,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.fillMaxWidth()) {
        currentConditions.forEach {
            Spacer(modifier = Modifier.width(16.dp))
            CurrentConditionCard(
                currentConditions = it,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}

@Composable
fun TopRow(modifier: Modifier = Modifier) = Row(
    modifier = modifier
        .fillMaxWidth()
        .padding(start = 16.dp, end = 16.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
) {
    Text(
        text = stringResource(id = R.string.today),
        style = MaterialTheme.typography.h6.copy(fontSize = 16.sp)
    )
    Text(
        text = stringResource(id = R.string.next_7_days),
        style = MaterialTheme.typography.subtitle2.copy(fontSize = 12.sp)
    )
}

@Preview
@Composable
fun HourlyForecastSheetPreview() {
    val forecast = List(7) {
        HourlyForecast(
            "cloudy", R.drawable.ic_cloudy,
            hour = "19:00",
            temperature = "20"
        )
    }
    WeatherComposeTheme {
        HourlyForecastSheet(hourlyForecast = forecast)
    }
}

@Preview
@Composable
fun PreviewCurrentConditionsCard() {
    WeatherComposeTheme {
        CurrentConditionCard(currentConditions = CurrentCondition("Wind", "250"))
    }
}


@Preview
@Composable
fun PreviewCurrentConditionsRow() {
    val currentConditions = listOf(
        CurrentCondition("Wind", "234"),
        CurrentCondition("Temp", "16"),
        CurrentCondition("Humidity", "23%"),
    )
    WeatherComposeTheme {
        CurrentConditionsRow(currentConditions = currentConditions)
    }
}
