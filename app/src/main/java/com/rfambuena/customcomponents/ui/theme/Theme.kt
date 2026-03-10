package com.rfambuena.customcomponents.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.rfambuena.mycustomcomponents.ui.theme.E600

private val DarkColorScheme = darkColorScheme(
    primary = Primary
)

private val LightColorScheme = lightColorScheme(
    primary = Primary,
    onPrimary = Color.White,
    secondary = Secondary,
    onSecondary = Primary,
    primaryFixed = Disabled,
    onPrimaryFixed = DisabledContent,
    background = Background,
    onBackground = TextColor,
    surfaceContainerLow = Color.Transparent,
    surfaceContainerHigh = Color.White,
    error = E600
)

@Composable
fun CustomComponentsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}