package ru.sber.hackathon.view.main

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.sber.hackathon.view.main.list.ListScreen
import ru.sber.hackathon.view.main.profile.ProfileScreen

var selectedTab by mutableStateOf("list")

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navControllerBottomBar = rememberNavController()

    Scaffold(
        bottomBar = { ScreenWithNav(navControllerBottomBar) }
    ) {
        NavHost(
            navController = navControllerBottomBar,
            startDestination = "list",
            route = "bbr"
        ) {
            composable("list") { ListScreen() }
            composable("profile") { ProfileScreen() }
        }
    }
}

@Composable
fun ScreenWithNav(navController: NavController) {
    BottomNavigation {
        BottomNavItem(
            navController = navController,
            icon = { Icon(Icons.Filled.Home, contentDescription = "") },
            title = "Главная",
            route = "list"
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
        selected = selectedTab == route,
        modifier = Modifier.background(Color.White),
        onClick = {
            navController.navigate(route) {
                selectedTab = route
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
