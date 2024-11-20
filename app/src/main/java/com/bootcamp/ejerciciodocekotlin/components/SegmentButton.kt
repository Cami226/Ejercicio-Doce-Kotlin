package com.bootcamp.ejerciciodocekotlin.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Space(size: Dp = 16.dp) {
    Spacer(modifier = Modifier.height(size))
}




@Composable
fun MultiButtonSegmented(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.LightGray, RoundedCornerShape(16.dp)),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        options.forEach { option ->
            TextButton(
                onClick = { onOptionSelected(option) },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.textButtonColors(
                    containerColor = if (selectedOption == option) Color.Gray else Color.Transparent
                )
            ) {
                Text(
                    text = option,
                    style = TextStyle(
                        color = if (selectedOption == option) Color.White else Color.Black
                    )
                )
            }
        }
    }
}
