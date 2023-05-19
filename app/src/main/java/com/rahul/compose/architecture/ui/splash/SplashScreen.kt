package com.rahul.compose.architecture.ui.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.rahul.compose.architecture.R
import com.rahul.compose.architecture.navigation.MainNavGraphScreen
import com.rahul.compose.architecture.theme.ComposeArchitectureTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
) {
    LaunchedEffect(key1 = stringResource(id = R.string.splash_screen)) {
        delay(2000)
        navController.navigate(
            route = MainNavGraphScreen.DashboardScreen.route
        )
    }
    ComposeArchitectureTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = stringResource(id = R.string.splash_screen),
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
