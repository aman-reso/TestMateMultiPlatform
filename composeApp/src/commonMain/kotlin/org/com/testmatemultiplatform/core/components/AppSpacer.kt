package org.com.testmatemultiplatform.core.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppSpacer(modifier: Modifier = Modifier, height: Int = 0, width: Int = 0) {
    Spacer(modifier.height(height.dp).width(width.dp))
}

@Composable
fun CustomAppSpacer(modifier: Modifier = Modifier) {
    Spacer(modifier)
}