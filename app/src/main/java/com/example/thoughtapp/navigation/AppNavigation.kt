package com.example.thoughtapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.thoughtapp.allthoughts.AllThoughtsScreen
import com.example.thoughtapp.data.ThoughtRecord
import com.example.thoughtapp.allthoughts.thoughtsList
import com.example.thoughtapp.landing.LandingScreen
import com.example.thoughtapp.recordthought.RecordThoughtScreen
import com.example.thoughtapp.ui.AboutScreen

enum class Screen {
    LANDING,
    ALL_THOUGHTS,
    ADD_THOUGHT,
    VIEW_THOUGHT,
    ABOUT,
}

sealed class NavigationItem(val route: String) {
    object Landing : NavigationItem("add thought")
    object AllThoughts : NavigationItem("all thoughts")
    object About : NavigationItem("about")
    object AddThought : NavigationItem("record thought")
    object ViewThought : NavigationItem("view thought/{thoughtId}")
}

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Landing.route,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Landing.route) {
            LandingScreen(navController)
        }
        composable(NavigationItem.AllThoughts.route) {
            AllThoughtsScreen(navController)
        }
        composable(NavigationItem.About.route) {
            AboutScreen(navController)
        }
        composable(NavigationItem.AddThought.route) {
            RecordThoughtScreen(navController = navController, thoughtRecord = ThoughtRecord.default)
        }
        composable(
            route = NavigationItem.ViewThought.route,
            arguments = listOf(navArgument("thoughtId") {
                type = NavType.StringType
            })
            ) { backStackEntry ->
            val thoughtId: Int = backStackEntry.arguments?.getString("thoughtId")?.toInt() ?: 0
            RecordThoughtScreen(navController = navController, thoughtRecord = thoughtsList[thoughtId - 1], isEnabled = false)
        }
    }
}