package org.com.testmatemultiplatform.auth

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.Serializable

class AuthRepository(private val httpClient: HttpClient) {
    suspend fun loginUser(request: LoginRequest): LoginResponse {
        return httpClient.post("https://dummyjson.com/auth/login") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }
}

@Serializable
data class LoginRequest(
    val username: String,
    val password: String,
    val expiresInMins: Int = 60
)

@Serializable
data class LoginResponse(
    val token: String,
    val expiresIn: Int,
    val userId: Int
)