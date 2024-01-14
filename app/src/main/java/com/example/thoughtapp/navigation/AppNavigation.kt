package com.example.thoughtapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.thoughtapp.allthoughts.AllThoughtsScreen
import com.example.thoughtapp.allthoughts.thoughtsList
import com.example.thoughtapp.landing.LandingScreen
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
    object ViewThought : NavigationItem("view thought")
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
            AllThoughtsScreen(thoughtsList = thoughtsList, navController)
        }
        composable(NavigationItem.About.route) {
            AboutScreen(navController)
        }

    }
}