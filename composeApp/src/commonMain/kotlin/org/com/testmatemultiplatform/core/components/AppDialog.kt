package org.com.testmatemultiplatform.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import org.com.testmatemultiplatform.core.theme.whiteColor

@Composable
fun CustomDialog(
    titleText: String = "",
    subTitleText: String = "",
    labelText: String = "",
    actionButtonText: String = "",
    onDismiss: () -> Unit,
) {
    Dialog(onDismissRequest = { onDismiss() }) {
        Box(
            modifier = Modifier.fillMaxWidth().background(
                    color = whiteColor, shape = RoundedCornerShape(16.dp)
                )
        ) {
            IconButton(onClick = { onDismiss() }, modifier = Modifier.align(Alignment.TopEnd)) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close",
                    tint = Color.Gray
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                HeadlineMediumTextView(
                    text = "This is a custom dialog", color = Color.Black
                )
            }
        }
    }
}