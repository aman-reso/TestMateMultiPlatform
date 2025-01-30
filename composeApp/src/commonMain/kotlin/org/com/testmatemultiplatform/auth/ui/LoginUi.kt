package org.com.testmatemultiplatform.auth.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.com.testmatemultiplatform.core.components.AppPrimaryButton
import org.com.testmatemultiplatform.core.components.AppSpacer
import org.com.testmatemultiplatform.core.components.GeneralizedBasicTextField
import org.com.testmatemultiplatform.core.components.HeadlineLargeTextView
import org.com.testmatemultiplatform.core.theme.whiteColor
import org.com.testmatemultiplatform.getTokenStorage
import org.com.testmatemultiplatform.localstorage.TokenManager

@Composable
fun LoginUi(callback: () -> Unit) {
    var mobileNumberInput by remember { mutableStateOf("") }
    val tokenManager = TokenManager(getTokenStorage())
    tokenManager.saveToken("your-token-here")
    val token = tokenManager.getToken()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(whiteColor).padding(16.dp)
    ) {

        HeadlineLargeTextView(
            "Login",
            modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter),
            textAlign = TextAlign.Center
        )

        Column(
            modifier = Modifier.fillMaxWidth().wrapContentHeight().align(Alignment.Center)
        ) {
            GeneralizedBasicTextField(value = mobileNumberInput, onValueChange = {
                mobileNumberInput = it
            }, label = "Enter Mobile number $token", placeholder = "Mobile number")
            AppSpacer(height = 32)
            AppPrimaryButton(
                text = "Get OTP",
                onClick = {
                    callback.invoke()
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}