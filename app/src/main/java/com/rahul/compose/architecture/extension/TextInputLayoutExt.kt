package com.rahul.compose.architecture.extension

import androidx.annotation.StringRes
import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.validate(@StringRes errorResId: Int?) {
    if (errorResId == null) error = null
    else validate(context.getString(errorResId))
}

fun TextInputLayout.validate(errorMessage: String?) {
    error = if (errorMessage.isNullOrBlank()) null
    else errorMessage
}
