package com.rfambuena.mycustomcomponents.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.rfambuena.mycustomcomponents.R

val soraFont = FontFamily(
    Font(R.font.sora_light, FontWeight.Light),
    Font(R.font.sora_regular, FontWeight.Normal),
    Font(R.font.sora_bold, FontWeight.Bold),
    Font(R.font.sora_semi_bold, FontWeight.SemiBold)
)

val title100 =
    TextStyle(
        fontFamily = soraFont,
        fontWeight = FontWeight.SemiBold,
        fontSize = 25.sp,
        color = libraryPalette.textColor
    )

val title200 =
    TextStyle(
        fontFamily = soraFont,
        fontWeight = FontWeight.SemiBold,
        fontSize = 28.sp,
        color = libraryPalette.textColor
    )

val title300 =
    TextStyle(
        fontFamily = soraFont,
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp,
        color = libraryPalette.textColor
    )

val body100 =
    TextStyle(
        fontFamily = soraFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = libraryPalette.textColor
    )

val body200 =
    TextStyle(
        fontFamily = soraFont,
        fontWeight = FontWeight.Normal,
        fontSize = 21.sp,
        color = libraryPalette.textColor
    )


val label100 =
    TextStyle(
        fontFamily = soraFont,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp,
        color = libraryPalette.textColor
    )
