package ru.sber.hackathon.android

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RegistrationScreen() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Регистрация")
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = { },
            placeholder = {
                Text(text = "Логин")
            }
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = { },
            placeholder = {
                Text(text = "Email")
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
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { }) {
            Text(text = "Зарегистрироваться")
        }
    }
}

@Preview
@Composable
fun RegistrationScreenPreview() {
    MyApplicationTheme {
        RegistrationScreen()
    }
}