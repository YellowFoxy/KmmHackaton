package ru.sber.hackathon.data.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserCredentialsRequest(
    @SerialName("login")
    val login: String,

    @SerialName("password")
    val password: String)
