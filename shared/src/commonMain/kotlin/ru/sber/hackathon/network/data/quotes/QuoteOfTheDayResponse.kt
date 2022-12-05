package ru.sber.hackathon.network.data.quotes

import kotlinx.serialization.SerialName

data class QuoteOfTheDayResponse(
    @SerialName("qotd_date")
    val qotdDate: String,

    @SerialName("quote")
    val quote: QuoteResponse
)
