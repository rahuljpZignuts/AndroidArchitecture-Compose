package com.rahul.compose.architecture.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType

val Typography.bodyExtraSmall: TextStyle
    get() = TextStyle(
        lineHeight = TextUnit(15f, TextUnitType.Sp),
        fontSize = TextUnit(10f, TextUnitType.Sp),
        fontStyle = FontStyle.Normal,
    )

val Typography.myBodySmall: TextStyle
    get() = TextStyle(
        lineHeight = TextUnit(18f, TextUnitType.Sp),
        fontSize = TextUnit(12f, TextUnitType.Sp),
        fontStyle = FontStyle.Normal,
    )

val Typography.bodyStandard: TextStyle
    get() = TextStyle(
        lineHeight = TextUnit(21f, TextUnitType.Sp),
        fontSize = TextUnit(14f, TextUnitType.Sp),
        fontStyle = FontStyle.Normal,
    )

val Typography.h1: TextStyle
    get() = TextStyle(
        lineHeight = TextUnit(60f, TextUnitType.Sp),
        fontSize = TextUnit(48f, TextUnitType.Sp),
        fontStyle = FontStyle.Normal,
    )

val Typography.h2: TextStyle
    get() = TextStyle(
        lineHeight = TextUnit(50f, TextUnitType.Sp),
        fontSize = TextUnit(40f, TextUnitType.Sp),
        fontStyle = FontStyle.Normal,
    )

val Typography.h3: TextStyle
    get() = TextStyle(
        lineHeight = TextUnit(40f, TextUnitType.Sp),
        fontSize = TextUnit(32f, TextUnitType.Sp),
        fontStyle = FontStyle.Normal,
    )

val Typography.h4: TextStyle
    get() = TextStyle(
        lineHeight = TextUnit(36f, TextUnitType.Sp),
        fontSize = TextUnit(24f, TextUnitType.Sp),
        fontStyle = FontStyle.Normal,
    )

val Typography.h5: TextStyle
    get() = TextStyle(
        lineHeight = TextUnit(30f, TextUnitType.Sp),
        fontSize = TextUnit(20f, TextUnitType.Sp),
        fontStyle = FontStyle.Normal,
    )

val Typography.h6: TextStyle
    get() = TextStyle(
        lineHeight = TextUnit(24f, TextUnitType.Sp),
        fontSize = TextUnit(16f, TextUnitType.Sp),
        fontStyle = FontStyle.Normal,
    )
