package com.example.thoughtapp.addthought

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thoughtapp.ui.theme.ThoughtAppTheme
import com.example.thoughtapp.ui.utils.ThoughtTopAppBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddThoughtsScreen() {
    Scaffold(
        topBar = {
            ThoughtTopAppBar(
                title = "add thought",
                isAdd = true,
            ) {
                /*TODO - Implement Closing*/
            }
        }
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(it)
        ) {
            item {
                CustomTextField(
                    label = "what was the context leading up to the thought? who, what, where, when and why? (e.g., just got off the phone with my dad and was about to make dinner.)",
                    title = "situation"
                )
                CustomTextField(
                    label = "what are you feeling? emotionally? physically? (e.g., angry, sad, butterflies in stomach)",
                    title = "emotion"
                )
                CustomSlider(title = "strength of emotion")
                CustomTextField(
                    label = "what is going through your mind? (e.g., I feel like I am not good enough. Like an impostor.)",
                    title = "thought"
                )
                CustomSlider(title = "belief in thought")
                Spacer(Modifier.height(48.dp))
                CustomSectionDivider(title = "challenge the negative thought")
                Spacer(Modifier.height(12.dp))
                CustomTextField(
                    label = "give 1-3 reasons why this thought may be true",
                    title = "may be true because..."
                )
                CustomTextField(
                    label = "give 1-3 reasons why this thought may NOT be true",
                    title = "may not be true because..."
                )
                CustomTextField(
                    label = "given all the evidence, is there a better way of summing up the situation?",
                    title = "reconsider"
                )
                CustomSlider(title = "strength of belief in new thought")
                Spacer(Modifier.height(12.dp))
                TextButton(
                    onClick = { /*TODO - onSaveClick*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Text(
                        text = "save",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.secondary
                        ),
                        modifier = Modifier
                            .border(
                                width = 4.dp,
                                shape = RectangleShape,
                                color = MaterialTheme.colorScheme.secondary
                            )
                            .padding(12.dp)
                    )
                }
            }

        }
    }
}

@Composable
fun CustomSectionDivider(
    title: String
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(color = MaterialTheme.colorScheme.secondary)
        )
        Box(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.secondary,
                    shape = RoundedCornerShape(
                        topStart = 0.dp, // Square corner
                        topEnd = 0.dp, // Square corner
                        bottomEnd = 16.dp, // Rounded corner
                        bottomStart = 16.dp // Rounded corner
                    )
                )
                .wrapContentWidth(align = Alignment.CenterHorizontally)
        ) {
            Text(
                text = title,
                style = TextStyle(
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                ),
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    label: String,
    title: String,
    initialText: String = "",
    isEnabled: Boolean = true
) {
    var text by remember { mutableStateOf(initialText) }

    Column {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(start = 16.dp, top = 8.dp)
        )
        TextField(
            value = text,
            onValueChange = { newText -> text = newText },
            modifier = Modifier
                .padding(bottom = 16.dp, top = 8.dp, start = 16.dp, end = 16.dp)
                .background(color = MaterialTheme.colorScheme.primary)
                .border(color = MaterialTheme.colorScheme.secondary, width = 2.dp),
            label = {
                Text(
                    text = label,
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight.Light
                    )
                )
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Default,
                keyboardType = KeyboardType.Text
            ),
            textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
            colors = TextFieldDefaults.outlinedTextFieldColors(),
            maxLines = 5,
            enabled = isEnabled,
            shape = RectangleShape // This removes the rounded corners
        )

    }

}

@Composable
fun CustomSlider(
    modifier: Modifier = Modifier,
    title: String,
    onValueChange: (Int) -> Unit = {},
    initialSliderPosition: Float = 0f
) {
    var sliderPosition by remember { mutableFloatStateOf(initialSliderPosition) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(start = 16.dp, top = 8.dp)
                .align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "${(sliderPosition * 100).toInt() + 1}")
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = modifier
                .padding(16.dp)
                .height(40.dp)
        ) {
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .pointerInput(Unit) {
                        detectTapGestures { offset ->
                            sliderPosition = offset.x / size.width
                            val scaledValue =
                                (sliderPosition * 100).toInt() + 1 // Scale to 1-100 range
                            onValueChange(scaledValue)
                        }
                    }
            ) {
                // Draw the horizontal line (track)
                drawLine(
                    color = Color.Black,
                    start = Offset(0f, size.height / 2),
                    end = Offset(size.width, size.height / 2),
                    strokeWidth = 4.dp.toPx()
                )

                // Draw the vertical line (thumb)
                val thumbX = sliderPosition * size.width
                drawLine(
                    color = Color.Black,
                    start = Offset(thumbX, 0f),
                    end = Offset(thumbX, size.height),
                    strokeWidth = 4.dp.toPx()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddThoughtsScreenPreview() {
    ThoughtAppTheme {
        AddThoughtsScreen()
    }
}