package com.rahul.compose.architecture.core.component

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.databinding.ViewDataBinding
import com.rahul.compose.architecture.extension.addSystemBarsVisibilityListener
import com.rahul.compose.architecture.helper.FullScreenActivityCallback
import com.rahul.compose.architecture.helper.FullScreenFragmentCallback
import com.rahul.compose.architecture.state.StateBus
import com.rahul.compose.architecture.state.UserState

abstract class FullScreenActivity<VB : ViewDataBinding> : DataBindingActivity<VB>(),
    FullScreenActivityCallback {

    protected var fullScreenFragmentCallback: FullScreenFragmentCallback? = null

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViews()
        setupObservers()
    }

    @CallSuper
    protected open fun setupViews() {
        fadeSystemBars()
        addSystemBarsVisibilityListener { visible ->
            fullScreenFragmentCallback?.onSystemBarsVisibilityChanged(visible)
        }
    }

    @CallSuper
    protected open fun setupObservers() {
        StateBus.userStateObservable.observe(this) { state ->
            if (!isFinishing && state != UserState.AUTHORIZED) {
                finish()
            }
        }
    }

    @CallSuper
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) fadeSystemBars()
    }

    abstract fun fadeSystemBars()
}
