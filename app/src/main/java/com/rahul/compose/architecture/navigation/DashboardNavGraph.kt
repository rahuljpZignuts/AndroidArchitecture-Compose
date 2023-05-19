package com.rahul.compose.architecture.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.rahul.compose.architecture.R
import com.rahul.compose.architecture.extension.customComposable
import com.rahul.compose.architecture.lifecycle.bo.StringResource
import com.rahul.compose.architecture.ui.grid.GridScreen
import com.rahul.compose.architecture.ui.vertical.VerticalScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun DashboardNavGraph(
    parentNavController: NavHostController,
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = DashboardNavGraphScreen.VerticalScreen.route,
        modifier = Modifier.padding(
            top = paddingValues.calculateTopPadding(),
            start = paddingValues.calculateStartPadding(LayoutDirection.Ltr),
            end = paddingValues.calculateEndPadding(LayoutDirection.Ltr)
        ),
    ) {
        customComposable(
            route = DashboardNavGraphScreen.VerticalScreen.route
        ) {
            VerticalScreen(
                parentNavController = parentNavController,
            )
        }

        customComposable(
            route = DashboardNavGraphScreen.GridScreen.route
        ) {
            GridScreen(
                parentNavController = parentNavController,
            )
        }
    }
}

sealed class DashboardNavGraphScreen(val route: String) {
    object VerticalScreen : DashboardNavGraphScreen("vertical")
    object GridScreen : DashboardNavGraphScreen("grid")
}

sealed class DashboardBottomNavItems(
    val title: StringResource,
    val icon: ImageVector,
    val route: String
) {
    object Vertical : DashboardBottomNavItems(
        title = StringResource.create(resId = R.string.vertical_screen),
        icon = Icons.Filled.VerifiedUser,
        route = DashboardNavGraphScreen.VerticalScreen.route
    )

    object Grid : DashboardBottomNavItems(
        title = StringResource.create(resId = R.string.vertical_screen),
        icon = Icons.Filled.AccountBalance,
        route = DashboardNavGraphScreen.GridScreen.route
    )

}

val bottomNavItems = listOf(
    DashboardBottomNavItems.Vertical,
    DashboardBottomNavItems.Grid,
)
