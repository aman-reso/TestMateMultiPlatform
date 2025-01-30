package org.com.testmatemultiplatform.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import org.com.testmatemultiplatform.core.theme.primaryButtonColor
import org.com.testmatemultiplatform.core.theme.titleTextColor

@Composable
fun AppUpBtn(showBackground: Boolean = false, upPress: () -> Unit) {
    if (showBackground) {
        IconButton(
            onClick = upPress,
            modifier = Modifier
                .statusBarsPadding()
                .size(36.dp)
                .background(shape = CircleShape, color = titleTextColor)
        ) {
            Icon(
                imageVector = mirroringBackIcon(), tint = Color.White,
                contentDescription = "Back button"
            )
        }
    } else {
        Icon(
            imageVector = mirroringBackIcon(), tint = titleTextColor,
            contentDescription = "Back button"
        )
    }
}

@Composable
fun mirroringIcon(ltrIcon: ImageVector, rtlIcon: ImageVector): ImageVector =
    if (LocalLayoutDirection.current == LayoutDirection.Ltr) ltrIcon else rtlIcon

@Composable
fun mirroringBackIcon() = mirroringIcon(
    ltrIcon = Icons.AutoMirrored.Outlined.ArrowBack,
    rtlIcon = Icons.Outlined.ArrowForward
)

@Composable
fun mirroringUpArrowIcon() = mirroringIcon(
    ltrIcon = Icons.Outlined.KeyboardArrowUp,
    rtlIcon = Icons.Outlined.KeyboardArrowDown
)