package org.com.testmatemultiplatform.auth.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.com.testmatemultiplatform.core.app_extensions.KeyboardAware
import org.com.testmatemultiplatform.core.components.AppPrimaryButton
import org.com.testmatemultiplatform.core.components.AppUpBtn
import org.com.testmatemultiplatform.core.components.BodyMediumTextView
import org.com.testmatemultiplatform.core.components.GeneralizedBasicTextField
import org.com.testmatemultiplatform.core.components.HeadlineLargeTextView
import org.com.testmatemultiplatform.core.components.HeadlineMediumTextView
import org.com.testmatemultiplatform.core.components.HeadlineSmallTextView
import org.com.testmatemultiplatform.core.components.TitleMediumTextView
import org.com.testmatemultiplatform.core.theme.whiteColor
import org.jetbrains.compose.resources.painterResource
import testmatemultiplatform.composeapp.generated.resources.Res
import testmatemultiplatform.composeapp.generated.resources.cuate

@Composable
fun VerifyOtpUi(callback: () -> Unit) {
    var otpInput by remember { mutableStateOf("") }
    val keyboardHeight = WindowInsets.ime.getBottom(LocalDensity.current)
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
//                .windowInsetsPadding(WindowInsets.safeContent.only(WindowInsetsSides.Bottom + WindowInsetsSides.Top))

    LaunchedEffect(key1 = keyboardHeight) {
        coroutineScope.launch {
            scrollState.scrollBy(keyboardHeight.toFloat())
        }
    }

    KeyboardAware {
        Column(
            modifier = Modifier.fillMaxWidth()
                .background(color = whiteColor)
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(horizontal = 16.dp),
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                AppUpBtn {

                }
                HeadlineLargeTextView(
                    "Verify",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
            Image(
                painter = painterResource(Res.drawable.cuate),
                contentDescription = "Description of the image",
                modifier = Modifier.fillMaxWidth().height(200.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(24.dp))
            HeadlineMediumTextView(
                "Enter OTP",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            TitleMediumTextView(
                "An 4 digit OTP has been sent to", modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            HeadlineSmallTextView(
                "+91 7564062907", modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(12.dp))
            GeneralizedBasicTextField(value = otpInput, onValueChange = {
                otpInput = it
            }, modifier = Modifier.imePadding(), placeholder = "Enter 4 digit OTP")

            Spacer(modifier = Modifier.height(16.dp))

            AppPrimaryButton(
                text = "Verify OTP", onClick = {
                    callback.invoke()
                }, modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            BodyMediumTextView(
                text = "Resend OTP",
                modifier = Modifier.fillMaxWidth().clickable {

                },
                textAlign = TextAlign.Center
            )
        }

    }
}

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    textFieldValue: String,
    onValueChange: (String) -> Unit,
) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = textFieldValue,
        onValueChange = onValueChange,
        label = {
            Text(text = "Enter a song")
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedTextColor = Color.Black,
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Black,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
        ),
        shape = RoundedCornerShape(12.dp),
    )
}
