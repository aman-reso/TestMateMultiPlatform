package org.com.testmatemultiplatform

import android.os.Build
import org.com.testmatemultiplatform.TestMateApplication.Companion.getAppContext
import org.com.testmatemultiplatform.localstorage.AndroidTokenStorage

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

actual fun getTokenStorage(): TokenStorage {
    return AndroidTokenStorage(getAppContext()!!)
}