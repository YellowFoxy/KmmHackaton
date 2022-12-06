package ru.sber.hackathon.view.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ru.sber.hackathon.android.MyApplicationTheme
import ru.sber.hackathon.view.main.list.MainScreenListItem

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
    navController: NavController, infoList: List<MainScreenInfo> = listOf(
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

    Scaffold(
        bottomBar = { ScreenWithNav(navController) }
    ) {
        MainScreenBody(infoList)
    }
}

@Composable
fun ScreenWithNav(navController: NavController) {
    BottomNavigation {
        BottomNavItem(
            navController = navController,
            icon = { Icon(Icons.Filled.Home, contentDescription = "") },
            title = "Главная",
            route = "main"
        )
        BottomNavItem(
            navController = navController,
            icon = { Icon(Icons.Filled.Person, contentDescription = "") },
            title = "Личный кабинет",
            route = "profile"
        )
    }
}

@Composable
fun RowScope.BottomNavItem(
    navController: NavController,
    icon: @Composable () -> Unit,
    title: String,
    route: String
) {
    val currentRoute = navController.currentDestination?.route
    BottomNavigationItem(
        icon = icon,
        label = {
            Text(
                text = title,
                fontSize = 9.sp
            )
        },
        selectedContentColor = Color.Black,
        unselectedContentColor = Color.Black.copy(0.4f),
        alwaysShowLabel = true,
        selected = currentRoute == route,
        onClick = {
            navController.navigate(route) {

                navController.graph.startDestinationRoute?.let { screen_route ->
                    popUpTo(screen_route) {
                        saveState = true
                    }
                }
                launchSingleTop = true
                restoreState = true
            }
        }
    )
}

@Composable
fun MainScreenBody(infoList: List<MainScreenInfo>) {
    Column {
        Text(
            text = "Главная",
            fontSize = 24.sp,
            modifier = Modifier.padding(4.dp)
        )
        LazyColumn {
            itemsIndexed(
                infoList +

                    MainScreenInfo()
            ) { index, info ->
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
fun DefaultPreview() {
    MyApplicationTheme {
        Scaffold {
            MainScreenBody(
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
