package com.rahul.compose.architecture.ui.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.rahul.compose.architecture.data.model.Public
import com.rahul.compose.architecture.data.proto.Authentication
import com.rahul.compose.architecture.theme.ComposeArchitectureTheme

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = "login") {
        viewModel.login()
    }

    ComposeArchitectureTheme {
        Surface {
            Column {
                val token: Authentication? by viewModel.userToken.observeAsState()
                val entries: Public? by viewModel.entries.observeAsState()
                Text(
                    text = token?.accessToken.toString(),
                    modifier = Modifier.clickable {
                        viewModel.getEntries()
                    },
                )
                entries?.let { public ->
                    LazyColumn {
                        items(public.count) {
                            Text(text = public.entries[it].api)
                        }
                    }
                }
            }
        }
    }
}
