package ru.sber.hackathon.data.users

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class UpdateUserResponse(
    @SerialName("login")
    val login: String,

    @SerialName("email")
    val email: String,

    @SerialName("password")
    val password: String,

    @SerialName("twitter_username")
    val twitterUsername: String,

    @SerialName("facebook_username")
    val facebookUsername: String,

    @SerialName("pic")
    val pic: String,

    @SerialName("profanity_filter")
    val profanityFilter: Boolean,

    @SerialName("public_themes")
    val publicThemes: Boolean
)
