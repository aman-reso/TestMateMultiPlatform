package org.com.testmatemultiplatform

import platform.Foundation.NSUserDefaults

class IOSTokenStorage : TokenStorage {
    private val userDefaults = NSUserDefaults.standardUserDefaults()
    private val authTokenKey = "authTokenKey"

    override fun saveToken(token: String) {
        userDefaults.setObject(token, forKey = authTokenKey)
    }

    override fun getToken(): String? {
        return userDefaults.stringForKey(authTokenKey)
    }
}