package ru.sber.hackathon.view.main.list

import android.annotation.SuppressLint
import android.os.Build
import android.text.Html
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineExceptionHandler
import androidx.navigation.NavController
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import ru.sber.hackathon.android.MyApplicationTheme
import ru.sber.hackathon.network.MainScreenInfo
import ru.sber.hackathon.network.MainViewModel

var job: Job? = null
var infoList by mutableStateOf(emptyList<MainScreenInfo>())

@SuppressLint("CoroutineCreationDuringComposition", "UnrememberedMutableState")
@Composable
fun ListScreen(navController: NavController? = null) {
    val scope = rememberCoroutineScope()

    ListScreenBody(infoList = infoList, navController)

    if (job == null) {
        job = scope.launch(CoroutineExceptionHandler { _, info ->
            Log.e("ListScreen", info.message ?: "error")
            infoList = listOf(
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
        }) {
            val list: List<MainScreenInfo> = MainViewModel().getQuotas()
            infoList = list
        }
    }
}

@Composable
fun ListScreenBody(infoList: List<MainScreenInfo>, navController: NavController? = null) {
    Column {
        Text(
            text = "Главная",
            fontSize = 24.sp,
            modifier = Modifier.padding(8.dp)
        )
        LazyColumn {
            itemsIndexed(infoList + MainScreenInfo()) { index, info ->
                MainScreenListItem(
                    text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        Html.fromHtml(info.text, 1).toString()
                    } else {
                        info.text
                    },
                    author = info.author,
                    categories = info.categories,
                    showDivider = index < infoList.lastIndex,
                    onClick = {
                        navController?.navigate("quoteInfo")
                    }
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
            ListScreenBody(
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
