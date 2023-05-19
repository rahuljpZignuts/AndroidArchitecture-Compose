package com.rahul.compose.architecture.utils

interface Argument {
    val key: String
}

data class BaseArgument(override val key: String) : Argument

fun generateRoute(argumentList: List<Argument>): String {
    val route = StringBuilder()
    argumentList.forEach {
        route.append("/{${it.key}}")
    }
    return route.toString()
}
