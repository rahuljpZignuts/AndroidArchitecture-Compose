package com.rahul.compose.architecture.ui.vertical

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.rahul.compose.architecture.R
import com.rahul.compose.architecture.theme.ComposeArchitectureTheme
import com.rahul.compose.architecture.ui.widget.StateComposable
import com.rahul.compose.architecture.ui.widget.UIEventComposable

@Composable
fun VerticalScreen(
    parentNavController: NavHostController
) {
    ComposeArchitectureTheme {
        UIEventComposable {
            StateComposable(
                modifier = Modifier.fillMaxSize()
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = stringResource(id = R.string.vertical_screen),
                        modifier = Modifier
                            .align(Alignment.Center)
                            .clickable {
                                parentNavController.navigateUp()
                            },
                    )
                }
            }
        }
    }
}
