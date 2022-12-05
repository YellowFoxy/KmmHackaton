package ru.sber.hackathon.view.main

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ru.sber.hackathon.android.MyApplicationTheme
import ru.sber.hackathon.view.main.list.MainScreenListItem

@Composable
fun MainScreen(infoList: List<MainScreenInfo>) {
    LazyColumn {
        itemsIndexed(infoList) { index, info ->
            MainScreenListItem(
                text = info.text,
                author = info.author,
                categories = info.categories,
                showDivider = index != infoList.lastIndex
            )
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        MainScreen(
            listOf(
                MainScreenInfo(
                    text = "Text 1",
                    author = "Author 1",
                    categories = listOf(
                        "Category1", "Category2", "Category3", "Category4", "Category5"
                    )
                ),
                MainScreenInfo(
                    text = "Text 2",
                    author = "Author 2",
                    categories = listOf(
                        "Category6", "Category7", "Category8", "Category9", "Category10"
                    )
                )
            )
        )
    }
}
