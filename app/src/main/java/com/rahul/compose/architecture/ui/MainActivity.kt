package com.rahul.compose.architecture.ui

import android.os.Bundle
import android.util.SparseArray
import android.widget.Toast
import androidx.activity.viewModels
import com.rahul.compose.architecture.R
import com.rahul.compose.architecture.core.component.DataBindingActivity
import com.rahul.compose.architecture.databinding.ActivityMainBinding
import com.rahul.compose.architecture.extension.observe
import com.rahul.compose.architecture.lifecycle.bo.getText
import com.rahul.compose.architecture.lifecycle.observable.UIEventType
import com.rahul.compose.architecture.lifecycle.observer.NonNullObserver
import com.rahul.compose.architecture.lifecycle.observer.UIEventListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : DataBindingActivity<ActivityMainBinding>(), UIEventListener {
    private val viewModel: LoginViewModel by viewModels()

    override val viewResourceId: Int
        get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupData()
        setupViews()
        setupObservers()
    }

    private fun setupViews() {
        binding.apply {
            stateLayout.setupWithRequestState(this@MainActivity, viewModel.requestState)
            token.setOnClickListener {
                viewModel.getEntries()
            }
        }
    }

    private fun setupData() {
        viewModel.login()
    }

    private fun setupObservers() {
        viewModel.uiEvent.observe(this)
        viewModel.userToken.observe(this) {
            binding.token.text = it.accessToken.toString()
        }
        viewModel.entries.observe(this, NonNullObserver {
            binding.entries.text = it.entries.toString()
        })
    }

    override fun onShowAlertEventReceived(event: UIEventType.Alert, extras: SparseArray<Any?>?) {
        super.onShowAlertEventReceived(event, extras)
        Toast.makeText(
            requireContext(),
            event.message?.getText(requireContext()),
            Toast.LENGTH_LONG
        ).show()
    }
}
