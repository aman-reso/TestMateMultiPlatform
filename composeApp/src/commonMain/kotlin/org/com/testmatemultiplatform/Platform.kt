package org.com.testmatemultiplatform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform


expect fun getTokenStorage(): TokenStorage

interface TokenStorage {
    fun saveToken(token: String)
    fun getToken(): String?
}