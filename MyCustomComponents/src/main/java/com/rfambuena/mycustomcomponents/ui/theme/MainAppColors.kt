package com.rfambuena.mycustomcomponents.ui.theme

import androidx.compose.ui.graphics.Color

lateinit var mainAppColor: MainAppColors

fun setUpMainAppColors(mainAppColors: MainAppColors) {
    mainAppColor = mainAppColors
}

data class MainAppColors(
    val primary: Color,
    val secondary: Color,
    val textColor: Color,
    val secondaryTextColor: Color,
    val disabledColor: Color,
    val disabledTextColor: Color,
    val focusedContainerColor: Color,
    val unfocusedContainerColor: Color
)
