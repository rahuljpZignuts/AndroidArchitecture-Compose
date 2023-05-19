package com.rahul.compose.architecture.ui.dashboard

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.rahul.compose.architecture.lifecycle.bo.getText
import com.rahul.compose.architecture.navigation.DashboardNavGraph
import com.rahul.compose.architecture.navigation.bottomNavItems
import com.rahul.compose.architecture.theme.ComposeArchitectureTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun DashboardScreen(
    navController: NavHostController
) {
    ComposeArchitectureTheme {
        val childNavController = rememberAnimatedNavController()
        Scaffold(
            bottomBar = { BottomNavigation(childNavController) }
        ) {
            DashboardNavGraph(
                parentNavController = navController,
                navController = childNavController,
                paddingValues = it
            )
        }
    }
}

@Composable
fun BottomNavigation(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    NavigationBar {
        bottomNavItems.forEach {
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = it.title.getText()
                    )
                },
                label = {
                    Text(text = it.title.getText())
                },
                selected = navBackStackEntry?.destination?.route == it.route,
                onClick = {
                    navController.navigate(
                        route = it.route
                    ) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        }
    }
}
