package com.example.weathercompose.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weathercompose.ui.theme.Gray
import com.example.weathercompose.ui.theme.WeatherComposeTheme

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
