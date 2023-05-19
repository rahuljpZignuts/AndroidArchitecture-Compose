package com.rahul.compose.architecture.extension

import android.graphics.Color

fun String?.parseColor(): Int? = when {
    this.isNullOrEmpty() -> null
    else -> try {
        Color.parseColor(this)
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}
