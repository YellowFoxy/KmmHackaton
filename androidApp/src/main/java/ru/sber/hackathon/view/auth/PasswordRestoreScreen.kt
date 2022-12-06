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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PasswordRestoreScreen() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = stringResource(R.string.forgotPassword))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = { },
            placeholder = {
                Text(text = stringResource(R.string.enterEmail))
            }
        )
        Text(text = stringResource(R.string.passwordRestoreInstruction))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { }) {
            Text(text = stringResource(R.string.restorePassword))
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