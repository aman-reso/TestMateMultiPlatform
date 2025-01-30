package org.com.testmatemultiplatform.auth.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import org.com.testmatemultiplatform.core.components.BodyLargeTextView
import org.com.testmatemultiplatform.core.components.ButtonState
import org.com.testmatemultiplatform.core.components.GeneralizedBasicTextField
import org.com.testmatemultiplatform.core.components.HeadlineLargeTextView
import org.com.testmatemultiplatform.core.theme.whiteColor

@Composable
fun EnterPersonalDetailUi(callback: () -> Unit) {
    var name by remember { mutableStateOf("") }
    var emailId by remember { mutableStateOf("") }
    var buttonState by remember { mutableStateOf(ButtonState.DEFAULT) }

    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight().background(color = whiteColor)
            .padding(16.dp)
    ) {
        HeadlineLargeTextView(
            "Enter your details", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth()
        )
        BodyLargeTextView(
            "To get personalized Experience",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        AppSpacer(height = 16)

        GeneralizedBasicTextField(name, label = "Name", onValueChange = {
            name = it
        }, placeholder = "Enter your name")
        AppSpacer(height = 16)

        GeneralizedBasicTextField(emailId, onValueChange = {
            emailId = it
        }, placeholder = "Enter your Email ID", label = "Email Id")
        AppSpacer(height = 16)
        GeneralizedBasicTextField(name, label = "Age", onValueChange = {
            name = it
        }, placeholder = "Enter your age")

        AppSpacer(height = 32)
        AppPrimaryButton(
            text = "Submit",
            onClick = {
                buttonState = ButtonState.entries.random()
                callback.invoke()
            },
            modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally),
            state = buttonState
        )

    }
}