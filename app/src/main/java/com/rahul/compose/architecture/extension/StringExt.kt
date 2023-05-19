package com.rahul.compose.architecture.extension

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.util.Patterns
import androidx.annotation.StringRes
import androidx.core.text.bold
import java.net.URL
import java.util.Locale

fun String.toDigits(): String = this.filter { it.isDigit() }

fun String?.toBoolean(): Boolean = when {
    this.equals("false", true) -> false
    else -> true
}

fun String.toBoldStyle(): Spannable = SpannableStringBuilder()
    .bold { append(this@toBoldStyle) }

fun String.copyToClipBoard(context: Context, @StringRes toastMessage: Int) {
    val manager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    manager.setPrimaryClip(ClipData.newPlainText("", this))
    context.showToast(context.getString(toastMessage))
}

fun String.capitalise(locale: Locale = Locale.getDefault()): String {
    return this.replaceFirstChar { if (it.isLowerCase()) it.titlecase(locale) else it.toString() }
}

val String.toUrl get() = if (this.isValidUrl) URL(this) else null

val String.isValidUrl get() = Patterns.WEB_URL.matcher(this).matches()