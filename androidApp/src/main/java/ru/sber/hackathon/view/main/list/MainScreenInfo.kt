package ru.sber.hackathon.view.main.list

data class MainScreenInfo(
    val text: String = "",
    val author: String = "",
    val categories: List<String> = emptyList()
)