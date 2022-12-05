package ru.sber.hackathon.data.users

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class GetUserResponse(
    @SerialName("login")
    val login: String,

    @SerialName("pic_url")
    val picUrl: String,

    @SerialName("public_favorites_count")
    val publicFavouritesCount: Int,

    @SerialName("followers")
    val followers: Int,

    @SerialName("following")
    val following: Int,

    @SerialName("pro")
    val pro: Boolean,

    @SerialName("account_details")
    val accountDetails: UserAccountDetails?
)
