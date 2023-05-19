package com.rahul.compose.architecture.ui.widget

import android.widget.Toast
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rahul.compose.architecture.lifecycle.bo.getText
import com.rahul.compose.architecture.lifecycle.observable.UIEvent
import com.rahul.compose.architecture.lifecycle.observable.UIEventType

@Composable
fun UIEventComposable(
    uiEvent: LiveData<UIEvent> = MutableLiveData(),
    onNavigationEventReceived: (UIEventType.Navigate) -> Unit = {},
    content: @Composable () -> Unit
) {
    val event: UIEvent? by uiEvent.observeAsState()
    val show = remember { mutableStateOf(false) }

    when (val type = event?.getEvent()) {
        is UIEventType.Alert -> show.value = true
        is UIEventType.Navigate -> onNavigationEventReceived(type)
        is UIEventType.Toast -> ShowToast(type)
        else -> {}
    }
    Surface {
        if (show.value) {
            ShowAlert(
                show = show,
                event = (event?.peekEvent() as UIEventType.Alert)
            )
        }
        content()
    }
}

@Composable
private fun ShowAlert(show: MutableState<Boolean>, event: UIEventType.Alert) {
    AlertDialog(
        onDismissRequest = { show.value = false },
        confirmButton = {
            TextButton(onClick = { show.value = false })
            { event.positiveButtonText?.getText()?.let { Text(text = it) } }
        },
        dismissButton = {
            TextButton(onClick = { show.value = false })
            { event.negativeButtonText?.getText()?.let { Text(text = it) } }
        },
        title = { event.title?.getText()?.let { Text(text = it) } },
        text = { event.message?.getText()?.let { Text(text = it) } }
    )
}

@Composable
private fun ShowToast(event: UIEventType.Toast) {
    Toast.makeText(LocalContext.current, event.message?.getText(), Toast.LENGTH_SHORT).show()
}
