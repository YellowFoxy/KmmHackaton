package ru.sber.hackathon.view.main.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.sber.hackathon.android.MainActivity
import ru.sber.hackathon.android.NavigationObject
import ru.sber.hackathon.data.users.GetUserResponse
import ru.sber.hackathon.network.MainScreenInfo
import ru.sber.hackathon.network.MainViewModel
import ru.sber.hackathon.view.main.list.MainScreenListItem

var userLogin by mutableStateOf(GetUserResponse("", "", 0, 0, 0, false, null))

@SuppressLint("CoroutineCreationDuringComposition", "UnrememberedMutableState", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileScreen() {
    val scope = rememberCoroutineScope()
    val login = MainActivity.currentUserLogin
    val session = MainActivity.currentUserSession
    val snackbarHostState = remember { SnackbarHostState() }

    scope.launch {
        val result = MainViewModel().getUser(login, session)
        if (result.login.isEmpty() || result.login == "error") {
            snackbarHostState.showSnackbar("Пользователь не найден")
        } else {
            withContext(Dispatchers.Main) {
                userLogin = result
            }
        }
    }

    Column {
            Text(
                text = "Добро пожаловать,\n" + userLogin.login,
                fontSize = 24.sp,
                modifier = Modifier.padding(4.dp)
            )
    }
}
