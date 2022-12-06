package ru.sber.hackathon.network

import ru.sber.hackathon.data.data.CreateSessionRequest
import ru.sber.hackathon.data.users.CreateUserRequest
import ru.sber.hackathon.data.users.ForgotPasswordRequest

class MainViewModel {
    private val client = KtorClient()

    suspend fun createSession(request: CreateSessionRequest) =
        client.createSession(request)

    suspend fun getQuotas() = client.getQuotesList()

    suspend fun createUser(request: CreateUserRequest) = client.createUser(request)

    suspend fun forgotPassword(request: ForgotPasswordRequest) = client.forgotPassword(request)
}