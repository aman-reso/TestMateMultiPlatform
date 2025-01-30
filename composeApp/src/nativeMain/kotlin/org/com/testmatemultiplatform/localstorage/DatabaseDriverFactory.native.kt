package org.com.testmatemultiplatform.localstorage

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import org.com.testmatemultiplatform.TestMateDb

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(
            schema = TestMateDb.Schema,
            name = "testmate.db"
        )
    }
}