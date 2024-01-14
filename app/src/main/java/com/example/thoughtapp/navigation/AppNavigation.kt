package com.example.thoughtapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.thoughtapp.AppViewModelProvider
import com.example.thoughtapp.allthoughts.AllThoughtsScreen
import com.example.thoughtapp.data.ThoughtRecord
import com.example.thoughtapp.allthoughts.thoughtsList
import com.example.thoughtapp.landing.LandingScreen
import com.example.thoughtapp.recordthought.RecordThoughtScreen
import com.example.thoughtapp.recordthought.RecordThoughtUiState
import com.example.thoughtapp.recordthought.RecordThoughtViewModel
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
            val viewModel: RecordThoughtViewModel = viewModel(
                factory = AppViewModelProvider.recordThoughtViewModelFactory(0)
            )
            RecordThoughtScreen(navController = navController, thoughtRecord = ThoughtRecord.default, viewModel = viewModel)
        }
        composable(
            route = NavigationItem.ViewThought.route,
            arguments = listOf(navArgument("thoughtId") {
                type = NavType.StringType
            })
            ) { backStackEntry ->
            val thoughtId: Int = backStackEntry.arguments?.getString("thoughtId")?.toInt() ?: 0
            // Create ViewModel using the factory method
            val viewModel: RecordThoughtViewModel = viewModel(
                factory = AppViewModelProvider.recordThoughtViewModelFactory(thoughtId)
            )
            val uiState: RecordThoughtUiState by viewModel.uiState.collectAsState()
            RecordThoughtScreen(navController = navController, thoughtRecord = uiState.thoughtRecord, viewModel = viewModel, isEnabled = false)
        }
    }
}