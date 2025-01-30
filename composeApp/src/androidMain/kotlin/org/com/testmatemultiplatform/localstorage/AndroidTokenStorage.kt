package org.com.testmatemultiplatform.localstorage

import android.content.Context
import android.content.SharedPreferences
import org.com.testmatemultiplatform.TokenStorage

class AndroidTokenStorage(context: Context) : TokenStorage {
    private val authTokenKey = "authTokenKey"
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

    override fun saveToken(token: String) {
        sharedPreferences.edit().putString(authTokenKey, token).apply()
    }

    override fun getToken(): String? {
        return sharedPreferences.getString(authTokenKey, null)
    }
}