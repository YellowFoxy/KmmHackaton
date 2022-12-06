package ru.sber.hackathon.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import ru.sber.hackathon.data.data.CreateSessionRequest
import ru.sber.hackathon.data.data.UserCredentialsRequest
import ru.sber.hackathon.data.users.CreateUserRequest
import ru.sber.hackathon.data.users.CreateUserResponse
import ru.sber.hackathon.data.users.ForgotPasswordRequest
import ru.sber.hackathon.data.users.UpdateUserResponse
import ru.sber.hackathon.network.data.quotes.QuoteOfTheDayResponse
import ru.sber.hackathon.network.data.session.CreateSessionResponse

class KtorClient {

    private val userCredentialsRequest = UserCredentialsRequest(
        "alexey.golygin@gmail.com",
        "fdsaqwert"
    )

    private val localCreateSessionRequest = CreateSessionRequest(
        userCredentialsRequest
    )

    private val client = HttpClient() {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun getQuote(): QuoteOfTheDayResponse {
        return try {
            client.get("https://favqs.com/api/qotd") {
                headers {
                    append(HttpHeaders.ContentType, "application/json")
                }
            }.body()
        } catch (ex: Exception) {
            QuoteOfTheDayResponse(qotd_date = ex.message ?: "error", quote = null)
        }
    }

    suspend fun getQuotesList(): List<QuoteOfTheDayResponse> =
        client.get("https://favqs.com/api/quotes") {
            headers {
                append(HttpHeaders.ContentType, "application/json")
                append(HttpHeaders.Authorization, "Token token=\"3ea3dbf2c2aa70fc882c575f9059f035\"")
            }
        }.body()

    suspend fun createSession(request: CreateSessionRequest): CreateSessionResponse {
        return try {
            client.post("https://favqs.com/api/session") {
                url {
                    headers {
                        append(HttpHeaders.ContentType, "application/json")
                        append(HttpHeaders.Authorization, "Token token=\"3ea3dbf2c2aa70fc882c575f9059f035\"")
                    }
                    setBody(request)
                }
            }.body()
        } catch (ex: Exception) {
            CreateSessionResponse("error", request.credentials.login, request.credentials.password)
        }
    }

    suspend fun createUser(request: CreateUserRequest): CreateUserResponse {
       return try {
           client.post("https://favqs.com/api/users") {
               url {
                   headers {
                       append(HttpHeaders.ContentType, "application/json")
                       append(HttpHeaders.Authorization, "Token token=\"3ea3dbf2c2aa70fc882c575f9059f035\"")
                   }
                   setBody(request)
               }
           }.body()
       } catch (ex: Exception){
           CreateUserResponse("error", request.user.login)
       }
    }

    suspend fun getUser(): String =
        client.get("https://favqs.com/api/users") {
            url {
                headers {
                    append(HttpHeaders.ContentType, "application/json")
                    append(HttpHeaders.Authorization, "Token token=\"3ea3dbf2c2aa70fc882c575f9059f035\"")
                }
                parameters.append("login", "borrmaskin")
            }
        }.body()

    suspend fun updateUser(): String =
        client.post("https://favqs.com/api/session") {
            url {
                headers {
                    append(HttpHeaders.ContentType, "application/json")
                    append(HttpHeaders.Authorization, "Token token=\"3ea3dbf2c2aa70fc882c575f9059f035\"")
                }
                parameters.append("login", "alexey.golygin@gmail.com")
                setBody(
                    UpdateUserResponse(
                        "vasya",
                        "vasya",
                        "vasya@vasya.ru",
                        "vasya",
                        "vasya",
                        "vasya",
                        profanityFilter = false,
                        publicThemes = false
                    )
                )
            }
        }.body()

    suspend fun forgotPassword(request: ForgotPasswordRequest): String {
        return try {
            client.post("https://favqs.com/api/users/forgot_password") {
                url {
                    headers {
                        append(HttpHeaders.ContentType, "application/json")
                        append(
                            HttpHeaders.Authorization,
                            "Token token=\"3ea3dbf2c2aa70fc882c575f9059f035\""
                        )
                    }
                    setBody(request)
                }
            }.body()
        } catch (ex: Exception) {
            "error"
        }
    }
}
