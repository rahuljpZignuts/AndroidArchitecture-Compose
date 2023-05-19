package com.rahul.compose.architecture.data.common

data class PagingResource<M>(
    val result: List<M>,
    val prevKey: Int?,
    val nextKey: Int?,
)
