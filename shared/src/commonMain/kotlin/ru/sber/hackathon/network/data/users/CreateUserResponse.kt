package ru.sber.hackathon.data.users

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateUserResponse(
    @SerialName("User-Token")
    val userToken: String,

    @SerialName("login")
    val login: String)
