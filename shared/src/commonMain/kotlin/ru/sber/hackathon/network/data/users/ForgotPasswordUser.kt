package ru.sber.hackathon.data.users

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForgotPasswordUser (
    @SerialName("email")
    val email: String
)
