package com.example.redact.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RedactionSettingScreen(
    reviewRedactionOnClick: () -> Unit,
) {
    var sliderPosition by remember { mutableStateOf(0f) }
    var redactData by remember {
        mutableStateOf("")
    }
    var redactValues = remember {
        mutableStateListOf(
            "Ayush J Ch.",
            "Ayush King",
            "Sparsh L.",
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F6F6)),
    ) {
        Spacer(modifier = Modifier.height(28.dp))
        Spacer(modifier = Modifier.height(28.dp))
        Column {
            RedactionProgressSetting()
            Column(
                modifier = Modifier
                    .padding(start = 12.dp, end = 12.dp, top = 30.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFFFFFFF))
                    .fillMaxWidth()
            )
            {
                Text(
                    modifier = Modifier.padding(top = 15.dp, start = 10.dp),
                    text = "Set Redaction Level",
                    fontSize = 22.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                )
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp, top = 20.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .clickable {
//                        onClick()
                        },
                    border = BorderStroke(1.dp, Color(0xFFEEEEEE)),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF6F6F6)),
                ) {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column {
                            Slider(
                                modifier = Modifier
                                    .height(60.dp)
                                    .padding(start = 10.dp, end = 10.dp, top = 25.dp),
                                value = sliderPosition,
                                onValueChange = { newValue ->
                                    sliderPosition = newValue
                                },
                                valueRange = 1f..3f,
                                steps = 1,
                                colors = SliderDefaults.colors(
                                    thumbColor = Color(0xFFFA3030),
                                    activeTrackColor = Color(0xFFF23535),
                                    inactiveTrackColor = Color(0xFFE9E9E9),
                                ),
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 15.dp, end = 15.dp, bottom = 28.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                for (i in 1..3) {
                                    Text(
                                        text = if (i == 1) {
                                            "Low"
                                        } else if (i == 2) {
                                            "Medium"
                                        } else {
                                            "High"
                                        },
                                        fontSize = 16.sp,
                                        color = Color.Black,
                                        fontWeight = FontWeight.Medium,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
                    }
                }

                Row(
                    modifier = Modifier.padding(10.dp, 24.dp, 10.dp, 24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Divider(
                        color = Color(0xFFEEEEEE),
                        thickness = 1.dp,
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 4.dp)

                    )
                    Text(
                        text = "OR",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFFB0B0B0)
                    )
                    Divider(
                        color = Color(0xFFEEEEEE),
                        thickness = 1.dp,
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 4.dp)

                    )
                }

                Text(
                    modifier = Modifier.padding(start = 10.dp),
                    text = "Add custom redaction",
                    fontSize = 22.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                )
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp, top = 20.dp, bottom = 10.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .clickable {
//                        onClick()
                        },
                    border = BorderStroke(1.dp, Color(0xFFEEEEEE)),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF6F6F6)),
                ) {
                    Text(
                        modifier = Modifier
                            .padding(start = 5.dp, top = 16.dp, end = 5.dp)
                            .fillMaxWidth(),
                        text = "Enter the data that needs to be redacted separately.",
                        fontSize = 16.sp,
                        color = Color(0xFF5D5D5D),
                        fontWeight = FontWeight.Medium,
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                top = 16.dp,
                                start = 5.dp,
                                end = 5.dp,
                                bottom = 40.dp
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Card(
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .width(240.dp)
                                .height(50.dp),
                            border = BorderStroke(1.dp, Color(0xFFE7E7E7)),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            TextField(
                                modifier = Modifier,
                                value = redactData,
                                onValueChange = {
                                    redactData = it
                                },
                                singleLine = true,
                                placeholder = {
                                    Text(
                                        text = "Ex. 8077058864",
                                        fontSize = 14.sp,
                                        color = Color(0xFF6D6D6D),
                                        fontWeight = FontWeight.Medium
                                    )
                                },
                                textStyle = TextStyle(
                                    color = Color.White,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Normal
                                ),
                                colors = TextFieldDefaults.colors(
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedContainerColor = Color.Transparent,
                                    focusedContainerColor = Color.Transparent,
                                    cursorColor = Color(0xFF01A74B),
                                    unfocusedIndicatorColor = Color.Transparent
                                ),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                            )
                        }

                        Button(
                            modifier = Modifier
                                .height(50.dp),
                            onClick = { /*TODO*/ },
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(Color(0xFFFF2D2D))

                        ) {
                            Text(
                                text = "Add",
                                fontSize = 14.sp,
                                color = Color(0xFFFFFFFF),
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
//                redactValues.forEachIndexed { index, s ->
//                    RedactDataChip(text = s)
//                }
//                LazyVerticalStaggeredGrid(
//                    columns = StaggeredGridCells.Fixed(),
//                    modifier = Modifier.fillMaxWidth(),
//                    contentPadding = PaddingValues(16.dp),
//                    horizontalArrangement = Arrangement.spacedBy(16.dp),
//                    verticalItemSpacing = 16.dp
//                ) {
//                    items(redactValues) { item ->
//                        RedactDataChip(
//                            item
//                        )
//                    }
//                }
                }
                Spacer(modifier = Modifier.height(64.dp))
                NextButton(text = "Review Redaction") {
                    reviewRedactionOnClick()
                }
                Spacer(modifier = Modifier.height(64.dp))
            }
        }
    }
}


@Composable
fun RedactionProgressSetting() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Circle(
            isSelected = true,
            label = "Upload document",
            modifier = Modifier.weight(1f)
        )
        Circle(
            isSelected = true,
            label = "Select Redaction Level",
            modifier = Modifier.weight(1f)
        )
        Circle(isSelected = false, label = "Review", modifier = Modifier.weight(1f))
    }
}

@Preview
@Composable
private fun RDPreview() {
    RedactionSettingScreen() {

    }
}