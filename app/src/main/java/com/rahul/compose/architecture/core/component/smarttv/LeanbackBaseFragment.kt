package com.rahul.compose.architecture.core.component.smarttv

import android.view.View
import androidx.databinding.ViewDataBinding
import com.rahul.compose.architecture.core.component.DataBindingFragment
import com.rahul.compose.architecture.ui.widget.helper.TvLayoutFocusHelper

abstract class LeanbackBaseFragment<VB : ViewDataBinding> : DataBindingFragment<VB>() {
    override fun onViewInflated(root: View) {
        TvLayoutFocusHelper.setFocus(root)
    }
}
