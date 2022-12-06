package ru.sber.hackathon.network.data.quotes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuoteOfTheDayResponse(
    @SerialName("qotd_date")
    val qotd_date: String = "",

    @SerialName("quote")
    val quote: QuoteResponse? = null
)
