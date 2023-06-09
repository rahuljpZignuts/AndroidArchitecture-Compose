package com.rahul.compose.architecture.extension

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.map
import com.rahul.compose.architecture.data.enums.RequestState
import com.rahul.compose.architecture.data.enums.isLoading
import com.rahul.compose.architecture.lifecycle.observable.UIEvent
import com.rahul.compose.architecture.lifecycle.observer.PredicateEventObserver
import com.rahul.compose.architecture.lifecycle.observer.SingleEventObserver
import com.rahul.compose.architecture.lifecycle.observer.UIEventListener
import com.rahul.compose.architecture.lifecycle.observer.UIEventObserver

fun <Owner> LiveData<UIEvent>.observe(owner: Owner) where Owner : LifecycleOwner, Owner : UIEventListener {
    observe(owner, UIEventObserver(owner))
}

fun <Owner> LiveData<UIEvent>.observe(owner: Owner) where Owner : Fragment, Owner : UIEventListener {
    observe(owner.viewLifecycleOwner, UIEventObserver(owner))
}

fun <Owner> LiveData<UIEvent>.observeActivity(owner: Owner) where Owner : Fragment {
    observe(owner.viewLifecycleOwner, UIEventObserver(owner.requireActivity() as UIEventListener))
}

fun <T> LiveData<T>.observeOnce(observer: Observer<T>, owner: LifecycleOwner? = null) {
    val listener = object : SingleEventObserver<T>(source = this) {
        override fun onChangeReceived(data: T) {
            observer.onChanged(data)
        }
    }
    if (owner == null) {
        this.observeForever(listener)
    } else {
        this.observe(owner, listener)
    }
}

fun <T> LiveData<T>.observeOnly(
    observer: Observer<T>,
    owner: LifecycleOwner? = null,
    predicate: (T?) -> Boolean,
) {
    val listener = object : PredicateEventObserver<T>(source = this, predicate = predicate) {
        override fun onChangeReceived(data: T) {
            observer.onChanged(data)
        }
    }
    if (owner == null) {
        this.observeForever(listener)
    } else {
        this.observe(owner, listener)
    }
}

fun LiveData<Boolean>.transformToRequestState() = map {
    return@map if (it) RequestState.IN_PROGRESS else RequestState.SUCCESS
}

fun LiveData<RequestState>.transformFromRequestState() = map {
    return@map it.isLoading()
}
