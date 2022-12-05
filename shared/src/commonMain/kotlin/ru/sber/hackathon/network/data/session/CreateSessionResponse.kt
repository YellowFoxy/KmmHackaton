package ru.sber.hackathon.data.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateSessionResponse(
    @SerialName("User-Token")
    val userToken: String,

    @SerialName("login")
    val login: String,

    @SerialName("password")
    val password: String)
