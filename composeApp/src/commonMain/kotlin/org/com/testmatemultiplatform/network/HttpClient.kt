package org.com.testmatemultiplatform.network

import androidx.lifecycle.ViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.serialization.json.Json

expect fun provideHttpClient(): HttpClient

fun createKtorClient(engine: HttpClientEngine): HttpClient {
    return HttpClient(engine) {
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }
        install(Logging) {
            level = LogLevel.BODY
        }
    }
}


interface Repository {
    fun readTimestamp()
    fun saveTimestamp()
}


class HomeViewModel(private val repo: Repository) : ViewModel() {
    init {
        println("Home ViewModel initializing...")
    }

    override fun onCleared() {
        super.onCleared()
        println("Home ViewModel clearing...")
    }
}

//class DetailViewModel(private val repo: Repository) : ViewModel() {
//    private val _uiState = MutableStateFlow(0)
//    val uiState: StateFlow<Int> = _uiState.asStateFlow()
//
//    init {
//        println("Detail ViewModel initializing...")
//        xyz()
//    }
//
//    private fun xyz() {
//        var count = 0
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//        println("Detail ViewModel clearing...")
//    }
//}