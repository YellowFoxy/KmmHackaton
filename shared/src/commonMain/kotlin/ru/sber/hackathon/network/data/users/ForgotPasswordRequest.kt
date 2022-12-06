package ru.sber.hackathon.data.users

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForgotPasswordRequest (
    @SerialName("user")
    val user: ForgotPasswordUser
)
