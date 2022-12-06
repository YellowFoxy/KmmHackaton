package ru.sber.hackathon.view.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.SnackbarData
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import ru.sber.hackathon.android.MyApplicationTheme
import ru.sber.hackathon.android.NavigationObject
import ru.sber.hackathon.android.R
import ru.sber.hackathon.data.users.CreateUserData
import ru.sber.hackathon.data.users.CreateUserRequest
import ru.sber.hackathon.data.users.CreateUserResponse
import ru.sber.hackathon.network.MainViewModel

@Composable
fun RegistrationScreen() {

    var login by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            text = stringResource(R.string.registration)
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
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
            value = login,
            onValueChange = { login = it },
            placeholder = {
                Text(text = stringResource(R.string.login))
            }
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
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
                Text(text = stringResource(R.string.email))
            }
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
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
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            value = password,
            onValueChange = { password = it },
            placeholder = {
                Text(text = stringResource(R.string.password))
            }
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(
                    shape = RoundedCornerShape(12.dp),
                    color = Color(0xFF31373B)
                ),
            onClick = {
                scope.launch {
                    val result: CreateUserResponse = MainViewModel().createUser(
                        CreateUserRequest(
                            CreateUserData(
                                login, email, password
                            )
                        )
                    )
                    if (result.userToken.isEmpty() || result.userToken == "error") {
                        snackbarHostState.showSnackbar("Введите данные для регистрации")
                        login = ""
                        password = ""
                        email = ""
                    } else {
                        NavigationObject.navigate("main")
                    }
                }
            }) {
            Text(
                fontSize = 16.sp,
                text = stringResource(R.string.createRegistration)
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
fun RegistrationScreenPreview() {
    MyApplicationTheme {
        RegistrationScreen()
    }
}