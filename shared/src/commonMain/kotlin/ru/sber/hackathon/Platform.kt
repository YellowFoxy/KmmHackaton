package ru.sber.hackathon

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform