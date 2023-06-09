package com.rahul.compose.architecture.lifecycle.observer

import androidx.lifecycle.LiveData

/**
 * [PredicateEventObserver] extension that received only the first value.
 */
abstract class SingleEventObserver<T>(
    source: LiveData<T>,
) : PredicateEventObserver<T>(source, { true })
