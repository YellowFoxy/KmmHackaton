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
fun PasswordRestoreScreen() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Забыли пароль?")
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = { },
            placeholder = {
                Text(text = "Укажите email")
            }
        )
        Text(text = "На данную электронную почту отправим ссылку для вопсстановления пароля")
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { }) {
            Text(text = "Восстановить пароль")
        }
    }
}

@Preview
@Composable
fun PasswordRestoreScreenPreview() {
    MyApplicationTheme {
        PasswordRestoreScreen()
    }
}