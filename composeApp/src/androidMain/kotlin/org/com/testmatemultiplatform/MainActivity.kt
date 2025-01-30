package org.com.testmatemultiplatform

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.com.testmatemultiplatform.core.theme.whiteBgColor
import org.com.testmatemultiplatform.group.post.ui.GroupPostHistoryMainUi
import org.com.testmatemultiplatform.localstorage.DatabaseDriverFactory
import org.com.testmatemultiplatform.localstorage.DatabaseHelper

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val databaseHelper = DatabaseHelper(DatabaseDriverFactory(this))
        setContent {
            App(databaseHelper)
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun AppAndroidPreview() {
    GroupPostHistoryMainUi(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = whiteBgColor)
            .padding(horizontal = 16.dp), null
    )
}