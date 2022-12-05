package ru.sber.hackathon.android

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun AuthScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Добро пожаловать")
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = { },
            placeholder = {
                Text(text = "Логин или email")
            }
        )
        TextField(
            value = "",
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { },
            placeholder = {
                Text(text = "Пароль")
            }
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    onClick = {

                    }) {
                    Text(text = "Вход")
                }
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    onClick = { navController.navigate("registration") }) {
                    Text(text = "Регистрация")
                }
            }
            Button(onClick = { }) {
                Text(text = "Забыли пароль?")
            }
        }
    }
}

@Preview
@Composable
fun AuthScreenPreview() {
    MyApplicationTheme {
        //AuthScreen()
    }
}