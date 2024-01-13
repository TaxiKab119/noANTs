package com.example.thoughtapp.ui.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thoughtapp.ui.theme.ThoughtAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThoughtTopAppBar(
    title: String,
    isAdd: Boolean = false,
    onClose: () -> Unit = {}
) {
    TopAppBar(
        title =  {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.9f)
                ) {
                    Text(
                        text = title,
                        style = TextStyle(
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Left
                        ),
                        modifier = Modifier.padding(start = 12.dp, end = 0.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    if (isAdd) {
                        Button(
                            onClick = onClose,
                            modifier = Modifier.fillMaxHeight(0.9f)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Close",
                                modifier = Modifier
                                    .fillMaxHeight()
                            )
                        }
                    }
                }
                // Bottom border
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp)
                        .background(Color.Black)
                )
            }
         },
    )
}


@Preview(showBackground = true)
@Composable
fun ThoughtTopAppBarPreview() {
    ThoughtAppTheme {
        ThoughtTopAppBar("add a thought", isAdd = true)
    }
}