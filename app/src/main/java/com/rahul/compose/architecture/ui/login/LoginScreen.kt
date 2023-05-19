package com.rahul.compose.architecture.ui.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.rahul.compose.architecture.R
import com.rahul.compose.architecture.data.model.Public
import com.rahul.compose.architecture.data.proto.Authentication
import com.rahul.compose.architecture.theme.ComposeArchitectureTheme
import com.rahul.compose.architecture.theme.bodyStandardMedium
import com.rahul.compose.architecture.theme.h4Bold
import com.rahul.compose.architecture.ui.widget.StateComposable
import com.rahul.compose.architecture.ui.widget.UIEventComposable

@Composable
fun LoginScreen(
    id: Int,
    name: String,
    viewModel: LoginViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = stringResource(id = R.string.login_screen)) {
        viewModel.login()
    }

    ComposeArchitectureTheme {
        UIEventComposable(
            uiEvent = viewModel.uiEvent
        ) {
            val token: Authentication? by viewModel.userToken.observeAsState()
            val entries: Public? by viewModel.entries.observeAsState()
            val scrollState = rememberLazyListState()
            StateComposable(
                requestState = viewModel.requestState,
                modifier = Modifier.fillMaxSize()
            ) {
                Column {
                    Text(
                        text = "$id -- $name",
                        style = MaterialTheme.typography.bodyStandardMedium
                    )
                    Text(
                        text = token?.accessToken.toString(),
                        modifier = Modifier.clickable {
                            viewModel.getEntries()
                            viewModel.login()
                        },
                        style = MaterialTheme.typography.h4Bold
                    )
                    entries?.let { public ->
                        LazyColumn(state = scrollState) {
                            items(public.count) {
                                Text(text = public.entries[it].api)
                            }
                        }
                    }
                }
            }
        }
    }
}
