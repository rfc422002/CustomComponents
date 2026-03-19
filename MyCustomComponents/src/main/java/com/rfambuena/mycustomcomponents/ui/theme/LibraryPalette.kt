package com.rfambuena.mycustomcomponents.ui.theme

import androidx.compose.ui.graphics.Color

fun setupLibraryPalette(newPalette: LibraryPalette) {
    libraryPalette = newPalette
}

internal lateinit var libraryPalette: LibraryPalette

data class LibraryPalette(
    val textColor: Color= TextColor,
    val primaryButtonColor: Color= Primary,
    val primaryButtonContentColor: Color= Color.White,
    val destructiveColor: Color= Destructive,
    val destructiveContentColor: Color= Color.White,
    val focusedContainerColor: Color= Color.White,
    val focusedContentColor: Color= TextColor,
    val disabledContainerColor: Color= Disabled,
    val disabledContentColor: Color= DisabledContent,
    val disabledColor: Color= Disabled,
    val placeholderColor: Color= PlaceholderColor,
    val disabledPlaceholderColor: Color = DisabledPlaceholderColor
)

