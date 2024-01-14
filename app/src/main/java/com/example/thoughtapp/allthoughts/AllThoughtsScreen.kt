package com.example.thoughtapp.allthoughts

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.thoughtapp.ui.theme.ThoughtAppTheme
import com.example.thoughtapp.ui.utils.BottomNavItem
import com.example.thoughtapp.ui.utils.CustomBottomNavigation
import com.example.thoughtapp.ui.utils.ThoughtTopAppBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllThoughtsScreen(
    thoughtsList: List<ThoughtRecord>,
    navController: NavController = rememberNavController(),
    onClickItem: (Int) -> Unit = {},
) {
    var currentScreen by remember { mutableStateOf(BottomNavItem.AllThoughts) }
    Scaffold(
        topBar = {
            ThoughtTopAppBar(
                title = "all thoughts",
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
        val listState = rememberLazyListState()
        LazyColumn(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = it,
            state = listState,

            ) {
            items(thoughtsList) { thought ->
                ThoughtItem(
                    thoughtNumber = thought.id,
                    onClickItem = { thoughtId ->
                        onClickItem(thoughtId)
                    }
                )
            }
        }
    }
}

@Composable
fun ThoughtItem(
    thoughtNumber: Int,
    modifier: Modifier = Modifier,
    onClickItem: (Int) -> Unit = {},
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .background(MaterialTheme.colorScheme.primary)
            .padding(horizontal = 24.dp)
    ) {
        Text(
            text = "thought number $thoughtNumber",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            ),
            modifier = Modifier.clickable {
                onClickItem(thoughtNumber)
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun AllThoughtsScreenPreview() {
    ThoughtAppTheme {
        AllThoughtsScreen(thoughtsList = thoughtsList)
    }
}

val thoughtsList = listOf<ThoughtRecord>(
    ThoughtRecord(
        id = 1,
        emotion = "Sad",
        emotionIntensity = 4,
        thought = "I will never be good enough.",
        thoughtBelief = 3,
        situation = "sitting coding on a saturday afternoon."
    ),
    ThoughtRecord(
        id = 2,
        emotion = "Sad",
        emotionIntensity = 4,
        thought = "I will never be good enough.",
        thoughtBelief = 3,
        situation = "sitting coding on a saturday afternoon."
    ),
    ThoughtRecord(
        id = 3,
        emotion = "Sad",
        emotionIntensity = 4,
        thought = "I will never be good enough.",
        thoughtBelief = 3,
        situation = "sitting coding on a saturday afternoon."
    ),
    ThoughtRecord(
        id = 4,
        emotion = "Sad",
        emotionIntensity = 4,
        thought = "I will never be good enough.",
        thoughtBelief = 3,
        situation = "sitting coding on a saturday afternoon."
    ),
    ThoughtRecord(
        id = 5,
        emotion = "Sad",
        emotionIntensity = 4,
        thought = "I will never be good enough.",
        thoughtBelief = 3,
        situation = "sitting coding on a saturday afternoon."
    )
)