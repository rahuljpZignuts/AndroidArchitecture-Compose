package com.rahul.compose.architecture.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.rahul.compose.architecture.R

val FontFamily = FontFamily(
    listOf(
        Font(R.font.pop_thin, FontWeight.Thin),
        Font(R.font.pop_extralight, FontWeight.ExtraLight),
        Font(R.font.pop_light, FontWeight.Light),
        Font(R.font.pop_regular, FontWeight.Normal),
        Font(R.font.pop_medium, FontWeight.Medium),
        Font(R.font.pop_semibold, FontWeight.SemiBold),
        Font(R.font.pop_bold, FontWeight.Bold),
        Font(R.font.pop_extrabold, FontWeight.ExtraBold),
        Font(R.font.pop_black, FontWeight.Black),
    )
)
