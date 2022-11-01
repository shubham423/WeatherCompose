package com.example.weathercompose.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.weathercompose.R
import com.example.weathercompose.ui.theme.WeatherComposeTheme

sealed class Screen(
    val route: String,
    @StringRes val stringRes: Int,
    @DrawableRes val iconRes: Int,
) {
    object Home : Screen("home", R.string.nav_home, R.drawable.ic_home)
    object Calendar : Screen("calendar", R.string.nav_calendar, R.drawable.ic_calendar)
    object Settings : Screen("settings", R.string.nav_settings, R.drawable.ic_settings)
}

val screens = listOf(
    Screen.Home,
    Screen.Calendar,
    Screen.Settings
)

@Composable
fun Navigation(
    modifier: Modifier = Modifier
) = BottomNavigation(modifier) {

    CompositionLocalProvider(LocalContentColor provides MaterialTheme.colors.onSurface) {
        screens.forEach { screen ->
            BottomNavigationItem(
                selected = screen == Screen.Home,
                onClick = {},
                icon = {
                    Icon(
                        painter = painterResource(id = screen.iconRes),
                        contentDescription = "home icon"
                    )
                },
                label = {
                    Text(text = stringResource(id = screen.stringRes))
                },
                alwaysShowLabel = false,
                unselectedContentColor = Color.LightGray
            )
        }
    }
}

@Preview
@Composable
fun BottomNavigationPreview() {
    WeatherComposeTheme {
        Navigation()
    }
}


@Preview()
@Composable
fun BottomNavigationDarkPreview() {
    WeatherComposeTheme(darkTheme = true) {
        Navigation()
    }
}