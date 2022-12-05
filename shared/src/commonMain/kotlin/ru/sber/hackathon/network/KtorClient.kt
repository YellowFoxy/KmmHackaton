package ru.sber.hackathon.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class KtorClient {

    private val client = HttpClient()

    suspend fun getData(): String {
        val response = client.get("https://ktor.io/docs/")
        return response.bodyAsText()
    }
}