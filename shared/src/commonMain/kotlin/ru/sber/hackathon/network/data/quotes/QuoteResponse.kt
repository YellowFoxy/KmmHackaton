package ru.sber.hackathon.network.data.quotes

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class QuoteResponse(
    @SerialName("id")
    val id: Long,

    @SerialName("favorites_count")
    val favoritesCounty: Int,

    @SerialName("dialogue")
    val dialogue: Boolean,

    @SerialName("private")
    val private: Boolean,

    @SerialName("tags")
    val tags: List<String>,

    @SerialName("url")
    val url: String,

    @SerialName("upvotes_count")
    val upvotesCount: Int,

    @SerialName("downvotes_count")
    val downvotesCount: Int,

    @SerialName("author")
    val author: String,

    @SerialName("author_permalink")
    val authorPermalink: String,

    @SerialName("body")
    val body: String
)
