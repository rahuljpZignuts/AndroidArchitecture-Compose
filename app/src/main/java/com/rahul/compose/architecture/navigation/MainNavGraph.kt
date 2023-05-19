package com.rahul.compose.architecture.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.rahul.compose.architecture.extension.customComposable
import com.rahul.compose.architecture.navigation.MainNavGraphScreen.LoginScreen.Arguments.argumentList
import com.rahul.compose.architecture.ui.dashboard.DashboardScreen
import com.rahul.compose.architecture.ui.login.LoginScreen
import com.rahul.compose.architecture.ui.splash.SplashScreen
import com.rahul.compose.architecture.utils.Argument
import com.rahul.compose.architecture.utils.BaseArgument
import com.rahul.compose.architecture.utils.generateRoute

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainNavGraph() {
    val navController = rememberAnimatedNavController()

    AnimatedNavHost(
        navController = navController,
        startDestination = MainNavGraphScreen.SplashScreen.route
    ) {
        customComposable(
            route = MainNavGraphScreen.SplashScreen.route,
        ) {
            SplashScreen(navController)
        }

        customComposable(
            route = MainNavGraphScreen.LoginScreen.route,
            arguments = listOf(
                navArgument(MainNavGraphScreen.LoginScreen.Arguments.ID.key) {
                    type = NavType.IntType
                },
                navArgument(MainNavGraphScreen.LoginScreen.Arguments.NAME.key) {
                    type = NavType.StringType
                }
            )
        ) {
            val id = it.arguments?.getInt(
                MainNavGraphScreen.LoginScreen.Arguments.ID.key
            ) ?: 0
            val name = it.arguments?.getString(
                MainNavGraphScreen.LoginScreen.Arguments.NAME.key
            ) ?: ""
            LoginScreen(
                id = id,
                name = name
            )
        }

        customComposable(
            route = MainNavGraphScreen.DashboardScreen.route,
        ) {
            DashboardScreen(navController)
        }
    }
}

sealed class MainNavGraphScreen(val route: String) {
    object SplashScreen : MainNavGraphScreen("splash")

    object LoginScreen : MainNavGraphScreen("login${generateRoute(argumentList)}") {
        fun createRoute(id: Int, name: String): String {
            return "login/${id}/${name}"
        }

        object Arguments {
            object ID : Argument by BaseArgument("id")
            object NAME : Argument by BaseArgument("name")

            val argumentList = listOf(
                ID,
                NAME
            )
        }
    }

    object DashboardScreen : MainNavGraphScreen("dashboard")
}
