package org.com.testmatemultiplatform.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp

actual fun provideHttpClient(): HttpClient {
    return createKtorClient(OkHttp.create())
}