package ru.sber.hackathon.network.data.session

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateSessionResponse(
    @SerialName("User-Token")
    val userToken: String,

    @SerialName("login")
    val login: String,

    @SerialName("email")
    val email: String)
