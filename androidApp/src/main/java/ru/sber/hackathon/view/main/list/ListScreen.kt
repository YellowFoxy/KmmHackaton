package ru.sber.hackathon.view.main.list

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.sber.hackathon.android.MyApplicationTheme

@Composable
fun ListScreen(
    infoList: List<MainScreenInfo> = listOf(
        MainScreenInfo(
            text = "Новаторы не всегда в чести. Поначалу.",
            author = "Джон Эдгар Гувер",
            categories = listOf(
                "жизненные цитаты", "новаторство"
            )
        ),
        MainScreenInfo(
            text = "Все сочувствуют несчастьям своих друзей," +
                "и лишь немногие - радуются их успехам.",
            author = "Оскар Уайльд",
            categories = listOf(
                "жизненные цитаты", "друзья, дружба"
            )
        ),
        MainScreenInfo(
            text = "Задумчивая душа склоняется к одиночеству.",
            author = "Омар Хайям",
            categories = listOf(
                "цитаты со смыслом", "душа", "одиночество"
            )
        ),
        MainScreenInfo(
            text = "Хорошие друзья, хорошие книги и спящая совесть - вот идеальная жизнь",
            author = "Омар Хайям",
            categories = listOf(
                "цитаты со смыслом", "душа", "одиночество", "жизненные цитаты", "друзья, дружба"
            )
        ),
        MainScreenInfo(
            text = "Новаторы не всегда в чести. Поначалу.",
            author = "Джон Эдгар Гувер",
            categories = listOf(
                "жизненные цитаты", "новаторство"
            )
        ),
        MainScreenInfo(
            text = "Все сочувствуют несчастьям своих друзей," +
                "и лишь немногие - радуются их успехам.",
            author = "Оскар Уайльд",
            categories = listOf(
                "жизненные цитаты", "друзья, дружба"
            )
        ),
        MainScreenInfo(
            text = "Задумчивая душа склоняется к одиночеству.",
            author = "Омар Хайям",
            categories = listOf(
                "цитаты со смыслом", "душа", "одиночество"
            )
        ),
        MainScreenInfo(
            text = "Хорошие друзья, хорошие книги и спящая совесть - вот идеальная жизнь",
            author = "Омар Хайям",
            categories = listOf(
                "цитаты со смыслом", "душа", "одиночество", "жизненные цитаты", "друзья, дружба"
            )
        )
    )
) {
    Column {
        Text(
            text = "Главная",
            fontSize = 24.sp,
            modifier = Modifier.padding(4.dp)
        )
        LazyColumn {
            itemsIndexed(infoList + MainScreenInfo()) { index, info ->
                MainScreenListItem(
                    text = info.text,
                    author = info.author,
                    categories = info.categories,
                    showDivider = index < infoList.lastIndex
                )
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview
@Composable
fun ListScreenPreview() {
    MyApplicationTheme {
        Scaffold {
            ListScreen(
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
}
