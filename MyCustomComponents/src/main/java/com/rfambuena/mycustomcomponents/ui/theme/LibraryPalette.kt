package com.rfambuena.mycustomcomponents.ui.theme

import androidx.compose.ui.graphics.Color

lateinit var libraryPalette: LibraryPalette

data class LibraryPalette(
    val textColor: Color,
    val primaryButtonColor: Color,
    val primaryButtonContentColor: Color,
    val destructiveColor: Color,
    val destructiveContentColor: Color,
    val disabledContainerColor: Color,
    val disabledContentColor: Color,
    val focusedContainerColor: Color,
    val focusedContentColor: Color,
    val disabledColor: Color,
    val placeholderColor: Color,
    val disabledPlaceholderColor: Color
)