package ru.sber.hackathon.view.main.list

import android.annotation.SuppressLint
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
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import ru.sber.hackathon.android.MyApplicationTheme
import ru.sber.hackathon.network.MainScreenInfo
import ru.sber.hackathon.network.MainViewModel

var job: Job? = null
var infoList by mutableStateOf(emptyList<MainScreenInfo>())

@SuppressLint("CoroutineCreationDuringComposition", "UnrememberedMutableState")
@Composable
fun ListScreen() {
    val scope = rememberCoroutineScope()

    ListScreenBody(infoList = infoList)

    if (job == null) {
        job = scope.launch {
            val list: List<MainScreenInfo> = MainViewModel().getQuotas()
            infoList = list
        }
    }
}

@Composable
fun ListScreenBody(infoList: List<MainScreenInfo>) {
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
