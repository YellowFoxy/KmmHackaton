package ru.sber.hackathon.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.sber.hackathon.view.main.MainScreen
import ru.sber.hackathon.view.main.MainScreenInfo

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MyApplicationTheme {
                NavHost(
                    navController = navController,
                    startDestination = "auth"
                ) {
                    composable("main") {
                        MainScreen(
                            navController,
                            listOf(
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
                        )
                    }
                    composable("auth") { AuthScreen(navController) }
                    composable("registration") { RegistrationScreen() }
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
