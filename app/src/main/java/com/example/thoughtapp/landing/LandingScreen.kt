package com.example.thoughtapp.landing

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.thoughtapp.ui.utils.BottomNavItem
import com.example.thoughtapp.ui.utils.CustomBottomNavigation
import com.example.thoughtapp.ui.utils.ThoughtTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LandingScreen(
    navController: NavController = rememberNavController(),
    viewModel: LandingViewModel
) {
    val count by viewModel.thoughtsCount.collectAsState()
    var currentScreen by remember { mutableStateOf(BottomNavItem.Landing) }
    Scaffold(
        topBar = {
            ThoughtTopAppBar(
                title = "stop negative thoughts",
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("record thought")
                },
                shape = RectangleShape,
                containerColor = MaterialTheme.colorScheme.primary,

                ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "add",
                    modifier = Modifier.size(48.dp)
                )

            }
        },
        bottomBar = {
            CustomBottomNavigation(
                currentScreen = currentScreen,
                onItemSelected = { selected ->
                    currentScreen = selected
                    navController.navigate(selected.title)
                }
            )
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            Text(
                /*TODO - Change # to # recorded thoughts*/
                text = "You have recorded $count total automatic negative thoughts.",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                ),
                modifier = Modifier
                    .padding(horizontal = 24.dp)
            )
        }
    }
}