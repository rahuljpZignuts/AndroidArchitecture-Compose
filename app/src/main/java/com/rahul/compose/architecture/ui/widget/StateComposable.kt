package com.rahul.compose.architecture.ui.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData
import com.rahul.compose.architecture.data.enums.RequestState

@Composable
fun StateComposable(
    modifier: Modifier = Modifier,
    requestState: LiveData<RequestState>,
    content: @Composable () -> Unit
) {
    val apiState: RequestState? by requestState.observeAsState()
    when (apiState) {
        RequestState.EMPTY -> EmptyStateComposable()
        RequestState.IN_PROGRESS, RequestState.FETCHING -> InProgressComposable(modifier, content)
        else -> SuccessComposable(modifier, content)
    }
}

@Composable
private fun EmptyStateComposable() {
    Text(text = "Empty State")
}

@Composable
private fun InProgressComposable(modifier: Modifier, content: @Composable () -> Unit) {
    Box(modifier = modifier) {
        content()
        Box(modifier = Modifier.fillMaxSize().clickable(enabled = false){}) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Composable
private fun SuccessComposable(modifier: Modifier, content: @Composable () -> Unit) {
    Box(modifier = modifier) {
        content()
    }
}
