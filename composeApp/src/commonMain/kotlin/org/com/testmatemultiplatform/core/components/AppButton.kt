package org.com.testmatemultiplatform.core.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.com.testmatemultiplatform.core.theme.primaryButtonColor
import org.com.testmatemultiplatform.core.theme.rubikFontFamily
import org.com.testmatemultiplatform.core.theme.titleTextColor
import org.com.testmatemultiplatform.core.theme.whiteColor

enum class ButtonState {
    DEFAULT, // Normal button state
    LOADING, // Button is in loading state
    ERROR    // Button is in error state
}


@Composable
fun AppPrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    state: ButtonState = ButtonState.DEFAULT,
    backgroundColor: Color = titleTextColor,
    errorColor: Color = Color.Red,
    textColor: Color = whiteColor,
    cornerRadius: Int = 8
) {
    Button(
        onClick = {
            if (state == ButtonState.DEFAULT) onClick()
        },
        modifier = modifier,
        enabled = state == ButtonState.DEFAULT,
        colors = ButtonDefaults.buttonColors(
            containerColor = when (state) {
                ButtonState.ERROR -> errorColor
                else -> backgroundColor
            },
            contentColor = textColor
        ),
        shape = RoundedCornerShape(cornerRadius.dp)
    ) {
        when (state) {
            ButtonState.LOADING -> {
                CircularProgressIndicator(
                    color = textColor,
                    modifier = Modifier.size(18.dp)
                )
            }

            ButtonState.ERROR -> {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Refresh,
                        contentDescription = "Error",
                        tint = textColor,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Error",
                        fontFamily = rubikFontFamily(),
                        fontWeight = FontWeight.SemiBold,
                        color = textColor,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }

            ButtonState.DEFAULT -> {
                Text(
                    text = text,
                    fontFamily = rubikFontFamily(),
                    fontWeight = FontWeight.SemiBold,
                    color = textColor,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


@Composable
fun AppSecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    borderColor: Color = primaryButtonColor,
    textColor: Color = titleTextColor
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = textColor
        ),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, borderColor)
    ) {
        Text(
            text = text,
            fontFamily = rubikFontFamily(),
            fontWeight = FontWeight.SemiBold,
            color = textColor,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }
}