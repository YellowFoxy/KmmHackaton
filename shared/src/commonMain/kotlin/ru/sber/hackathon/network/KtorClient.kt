package ru.sber.hackathon.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.*

class KtorClient {

    private val client = HttpClient() {
        install(ContentNegotiation) {
            json()
        }
    }

    suspend fun getData(): String {
        val response = client.get("https://ktor.io/docs/")
        return response.bodyAsText()
    }
}