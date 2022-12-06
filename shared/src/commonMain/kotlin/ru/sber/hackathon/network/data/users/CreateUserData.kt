package ru.sber.hackathon.data.users

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateUserData(
    @SerialName("login")
    val login: String,

    @SerialName("email")
    val email: String,

    @SerialName("password")
    val password: String)
