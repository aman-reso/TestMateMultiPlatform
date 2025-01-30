package org.com.testmatemultiplatform

import android.app.Application
import android.content.Context
import org.com.testmatemultiplatform.di.initializeKoin
import java.lang.ref.WeakReference

class TestMateApplication : Application() {

    companion object {
        var context: WeakReference<Context>? = null
        fun getAppContext(): Context? {
            return context?.get()
        }
    }

    override fun onCreate() {
        super.onCreate()
        if (context == null) {
            context = WeakReference(this)
        }
        initializeKoin()
    }

    override fun getApplicationContext(): Context {
        return super.getApplicationContext()
    }

}