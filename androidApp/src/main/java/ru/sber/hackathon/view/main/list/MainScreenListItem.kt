package ru.sber.hackathon.view.main.list

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.sber.hackathon.android.MyApplicationTheme

@Composable
fun MainScreenListItem(
    text: String,
    author: String,
    categories: List<String>,
    showDivider: Boolean = false
) = Box {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text,
            fontSize = 24.sp,
            modifier = Modifier.padding(4.dp)
        )
        Text(
            text = author,
            fontSize = 20.sp,
            color = Color.Gray,
            modifier = Modifier.padding(4.dp)
        )

        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
                .padding(4.dp)
        ) {
            categories.forEach { category ->
                Box( modifier = Modifier
                    .padding(2.dp)
                    .background(Color.Gray, shape = CircleShape)) {
                    Text(
                        text = category,
                        fontSize = 20.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
        if (showDivider) {
            Divider(startIndent = 8.dp, thickness = 1.dp, color = Color.Gray)
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        MainScreenListItem(
            text = "This is very clever and very very very very very very long phrase",
            author = "Alexey Nesmelov",
            categories = listOf("Category1", "Category2", "Category3", "Category4", "Category5")
        )
    }
}