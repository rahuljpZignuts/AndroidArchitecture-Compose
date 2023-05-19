package com.rahul.compose.architecture.network.retrofit

import android.content.Context
import com.rahul.compose.architecture.application.DateFormats
import com.rahul.compose.architecture.extension.createFile
import com.rahul.compose.architecture.extension.format
import com.rahul.compose.architecture.utils.DateTimeUtils
import okhttp3.logging.HttpLoggingInterceptor
import java.io.FileOutputStream

class FileLogger(val context: Context) : HttpLoggingInterceptor.Logger {
    override fun log(message: String) {
        val dateTime = DateTimeUtils.getCurrentDate()
        val fileName = dateTime.format(DateFormats.FORMAT_DATE_FULL_REVERSE) + ".txt"
        val file = context.createFile("Logs", fileName)
        FileOutputStream(file, true).bufferedWriter().use {
            it.write("$dateTime:\n$message\n")
        }
    }
}
