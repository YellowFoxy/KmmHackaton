package ru.sber.hackathon.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.sber.hackathon.view.auth.AuthScreen
import ru.sber.hackathon.view.auth.RegistrationScreen
import ru.sber.hackathon.view.main.MainScreen
import ru.sber.hackathon.view.main.MainScreenInfo

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
                        composable("main") {
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
                    //  val scope = rememberCoroutineScope()
                    //  var text by remember { mutableStateOf("Loading") }
                    //  LaunchedEffect(true) {
                    //      scope.launch {
                    //          text = try {
                    //              KtorClient().getData()
                    //          } catch (e: Exception) {
                    //              e.localizedMessage ?: "error"
                    //          }
                    //      }
                    //  }
                    // GreetingView(text)
                }
            }
        }
    }
}
