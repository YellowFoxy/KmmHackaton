package ru.sber.hackathon.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.sber.hackathon.view.auth.AuthScreen
import ru.sber.hackathon.view.auth.PasswordRestoreScreen
import ru.sber.hackathon.view.auth.RegistrationScreen
import ru.sber.hackathon.view.main.MainScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavigationObject.navController = navController
            MyApplicationTheme {
                Scaffold {
                    it.calculateTopPadding()
                    NavHost(
                        navController = navController,
                        startDestination = "auth"
                    ) {
                        composable("auth") { AuthScreen() }
                        composable("registration") { RegistrationScreen() }
                        composable("restorePassword") { PasswordRestoreScreen() }
                        composable("main") { MainScreen() }
                    }
                }
            }
        }
    }

    companion object {
        var currentUserLogin: String = ""
        var currentUserSession: String = ""
    }
}
