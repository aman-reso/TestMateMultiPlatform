package org.com.testmatemultiplatform.localstorage

import org.com.testmatemultiplatform.TokenStorage


class TokenManager(private val tokenStorage: TokenStorage) {
    companion object {
        val authToken = "auth_token"
    }

    fun saveToken(token: String) {
        tokenStorage.saveToken(token)
    }

    fun getToken(): String? {
        return tokenStorage.getToken()
    }
}