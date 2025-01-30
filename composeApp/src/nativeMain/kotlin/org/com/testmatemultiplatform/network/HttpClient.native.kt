package org.com.testmatemultiplatform.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin

actual fun provideHttpClient(): HttpClient {
    return createKtorClient(Darwin.create())
}
