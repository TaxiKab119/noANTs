package com.example.thoughtapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.thoughtapp.recordthought.CustomSectionDivider
import com.example.thoughtapp.ui.utils.BottomNavItem
import com.example.thoughtapp.ui.utils.CustomBottomNavigation
import com.example.thoughtapp.ui.utils.ThoughtTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(
    navController: NavController = rememberNavController()
) {
    var currentScreen by remember { mutableStateOf(BottomNavItem.About) }
    Scaffold(
        topBar = {
            ThoughtTopAppBar(
                title = "about",
            )
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
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            item {
                CustomSectionDivider(title = "what is cognitive behavioral therapy (cbt)?")
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "central to cbt is the principle that psychological problems are based, in part, on faulty/unhelpful thinking and behavior patterns. people suffering from psychological problems can learn better ways of coping with them, thereby relieving their symptoms and becoming more effective in their lives.",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                    ),
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )
                Text(
                    text = "cbt treatment often involves efforts to change thinking patterns and challenge distorted thinking, thereby enhancing problem-solving and allowing individuals to feel empowered to improve their mental health. ",

                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                    ),
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )
                Spacer(modifier = Modifier.height(24.dp))
                CustomSectionDivider(title = "what is an automatic negative thought?")
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "catastrophizing: expecting the worst-case scenario, e.g., \"if i make a mistake at work, i will definitely get fired.",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                    ),
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )
                Text(
                    text = "personalization: blaming oneself for things beyond one's control, e.g., \"my friend didn't smile at me today; it must be because i did something wrong.\"",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                    ),
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )
                Text(
                    text = "overgeneralization: drawing broad, negative conclusions based on a single event, e.g., \"i failed this test, so i'm bad at everything.\"",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                    ),
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )
                Text(
                    text = "all-or-nothing thinking: seeing things in black and white categories, e.g., \"if i'm not perfect, then i am a total failure.\"",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                    ),
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )
                Text(
                    text = "mind reading: assuming you know what others are thinking, usually negatively, e.g., \"everyone at this party thinks i'm boring.\"",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                    ),
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )
                Spacer(modifier = Modifier.height(24.dp))
                CustomSectionDivider(title = "how can this app help you?")
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "deigned by a former neuroscientist turned software developer, the techniques for automatic thought tracking and thought challenging are informed by research and made accessible for you to keep track of your mental health. whether you want to keep these insights to yourself to look back on or share them with your support network, i hope that you can benefit from challenging those automatic negative thoughts!",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                    ),
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )

            }
        }
    }
}
