package org.com.testmatemultiplatform

import androidx.compose.ui.window.ComposeUIViewController
import org.com.testmatemultiplatform.localstorage.DatabaseDriverFactory
import org.com.testmatemultiplatform.localstorage.DatabaseHelper
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    val databaseHelper = DatabaseHelper(DatabaseDriverFactory())
    return ComposeUIViewController { App(databaseHelper) }
}