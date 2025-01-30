package org.com.testmatemultiplatform.localstorage

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import org.com.testmatemultiplatform.TestMateApplication.Companion.getAppContext
import org.com.testmatemultiplatform.TestMateDb

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = TestMateDb.Schema,
            context = getAppContext() ?: context,
            name = "testmate.db"
        )
    }
}