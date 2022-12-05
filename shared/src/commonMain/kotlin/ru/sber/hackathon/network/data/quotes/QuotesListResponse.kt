package ru.sber.hackathon.network.data.quotes

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class QuotesListResponse(
    @SerialName("page")
    val page: Int,

    @SerialName("last_page")
    val lastPage: Boolean,

    @SerialName("quotes")
    val quotes: List<QuoteResponse>
)
