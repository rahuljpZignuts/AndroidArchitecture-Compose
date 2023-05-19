package com.rahul.compose.architecture.network.meta

data class Result<T>(
    val data: T? = null,
    val error: String? = null,
)
