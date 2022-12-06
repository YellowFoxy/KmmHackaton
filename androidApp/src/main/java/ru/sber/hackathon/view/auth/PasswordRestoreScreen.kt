package ru.sber.hackathon.view.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.sber.hackathon.android.MyApplicationTheme
import ru.sber.hackathon.android.NavigationObject
import ru.sber.hackathon.android.R

@Composable
fun PasswordRestoreScreen() {
    var email by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            modifier = Modifier.padding(vertical = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            text = stringResource(R.string.forgotPassword)
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .border(1.dp, Color.Transparent, CircleShape),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                disabledTextColor = Color.Transparent,
                backgroundColor = Color(0x14000000),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            value = email,
            onValueChange = { email = it },
            placeholder = {
                Text(text = stringResource(R.string.enterEmail))
            }
        )
        Text(
            modifier = Modifier.padding(bottom = 26.dp),
            fontSize = 12.sp,
            text = stringResource(R.string.passwordRestoreInstruction))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .background(
                    shape = RoundedCornerShape(12.dp),
                    color = Color(0xFF31373B)
                ),
            onClick = {
                NavigationObject.navigate("main")
            }) {
            Text(
                fontSize = 16.sp,
                text = stringResource(R.string.restorePassword)
            )
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