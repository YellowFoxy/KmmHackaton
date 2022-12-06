package ru.sber.hackathon.view.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import ru.sber.hackathon.android.MyApplicationTheme
import ru.sber.hackathon.android.NavigationObject
import ru.sber.hackathon.android.R
import ru.sber.hackathon.data.data.CreateSessionRequest
import ru.sber.hackathon.data.data.UserCredentialsRequest
import ru.sber.hackathon.data.users.ForgotPasswordRequest
import ru.sber.hackathon.data.users.ForgotPasswordUser
import ru.sber.hackathon.network.MainViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PasswordRestoreScreen() {
    val focusManager = LocalFocusManager.current
    var email by rememberSaveable { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val keyboardController = LocalSoftwareKeyboardController.current


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(horizontal = 16.dp)
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            },
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
            text = stringResource(R.string.passwordRestoreInstruction)
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .background(
                    shape = RoundedCornerShape(12.dp),
                    color = Color(0xFF31373B)
                ),
            onClick = {
                keyboardController?.hide()
                scope.launch {
                    if (email.isEmpty()) {
                        snackbarHostState.showSnackbar("Введите данные для восстановления")
                    } else {
                        val result = MainViewModel().forgotPassword(
                            ForgotPasswordRequest(
                                ForgotPasswordUser(email)
                            )
                        )
                        if (result.isEmpty() || result.contains("error")) {
                            snackbarHostState.showSnackbar("Ошибка при восстановлении данных")
                        } else {
                            NavigationObject.navigate("auth")
                        }
                    }
                }
            }) {
            Text(
                fontSize = 16.sp,
                text = stringResource(R.string.restorePassword)
            )
        }
    }
    SnackbarHost(
        modifier = Modifier
            .fillMaxSize(),
        hostState = snackbarHostState,
        snackbar = { snackbarData: SnackbarData ->
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 24.dp)
                        .background(
                            shape = RoundedCornerShape(12.dp),
                            color = Color(0xFF31373B)
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painterResource(id = R.drawable.snack_icon),
                        contentDescription = null,
                        tint = Color(0xFFE35502),
                        modifier = Modifier
                            .padding(horizontal = 17.dp, vertical = 12.dp),
                    )
                    Text(
                        modifier = Modifier
                            .padding(vertical = 15.dp),
                        text = snackbarData.message,
                        color = Color.White
                    )
                }
            }
        }
    )
}

@Preview
@Composable
fun PasswordRestoreScreenPreview() {
    MyApplicationTheme {
        PasswordRestoreScreen()
    }
}