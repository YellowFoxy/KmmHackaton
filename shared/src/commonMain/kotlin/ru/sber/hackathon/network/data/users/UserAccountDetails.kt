package ru.sber.hackathon.data.users

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserAccountDetails (
    @SerialName("email")
    val email: String,

    @SerialName("private_favorites_count")
    val privateFavouritesCount: Int,

    @SerialName("active_theme_id")
    val activeThemeId: Long = 0,

    @SerialName("pro_expiration")
    val proExpiration: String = ""
)
