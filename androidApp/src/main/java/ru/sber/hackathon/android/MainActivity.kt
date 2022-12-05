package ru.sber.hackathon.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

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
