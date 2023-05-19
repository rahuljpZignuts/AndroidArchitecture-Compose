package com.rahul.compose.architecture.extension

import com.rahul.compose.architecture.application.AlphabeticChars
import com.rahul.compose.architecture.state.Language
import com.rahul.compose.architecture.state.StateBus
import java.text.NumberFormat

val Int.localisedString: String get() = NumberFormat.getInstance().format(this)

fun Int.toAlphabeticChar(language: Language = StateBus.language): String {
    val chars = when (language) {
        Language.ARABIC -> AlphabeticChars.ARABIC.toCharArray().filter { it != ' ' }
        else -> AlphabeticChars.ENGLISH.toCharArray().filter { it != ' ' }
    }
    return chars.getOrNull(this)?.toString()?.trim() ?: this.localisedString
}
