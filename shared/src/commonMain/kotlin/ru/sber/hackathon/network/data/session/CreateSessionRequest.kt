package ru.sber.hackathon.data.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateSessionRequest(
    @SerialName("user")
    val credentials: UserCredentialsRequest,
)
