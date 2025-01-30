package org.com.testmatemultiplatform

actual fun getTokenStorage(): TokenStorage {
    return IOSTokenStorage()
}