package com.rahul.compose.architecture.injection

import javax.inject.Qualifier

/**
 * Repository coroutine dispatcher to dispatch repository operations like caching, parsing and
 * data manipulations.
 */
@Qualifier
@Retention(AnnotationRetention.BINARY)
internal annotation class RepositoryDispatcher
