package org.com.testmatemultiplatform.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.VisualTransformation.Companion.None
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.com.testmatemultiplatform.core.theme.borderColor
import org.com.testmatemultiplatform.core.theme.hintColor
import org.com.testmatemultiplatform.core.theme.titleTextColor

@Composable
fun GeneralizedEditText(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "",
    placeholder: String = "",
    isPassword: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    onImeAction: (() -> Unit)? = null,
    visualTransformation: VisualTransformation = if (isPassword) PasswordVisualTransformation() else None,
    isError: Boolean = false,
    errorText: String? = null,
    borderColor: Color = Color(0xFF1F41BB), // Default color: #1F41BB
    cornerRadius: Int = 8
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { if (label.isNotEmpty()) Text(label) },
        placeholder = { if (placeholder.isNotEmpty()) Text(placeholder) },
        modifier = modifier.fillMaxWidth(),
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onDone = { onImeAction?.invoke() }
        ),
        isError = isError,
        shape = RoundedCornerShape(cornerRadius.dp)
    )
    if (isError && errorText != null) {
        Text(
            text = errorText,
            color = Color.Red,
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Composable
fun GeneralizedBasicTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "",
    placeholder: String = "",
    isPassword: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    onImeAction: (() -> Unit)? = null,
    visualTransformation: VisualTransformation = if (isPassword) PasswordVisualTransformation() else None,
    isError: Boolean = false,
    errorText: String? = null,
    borderColorName: Color = borderColor,
    cornerRadius: Int = 10
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        Column {
            if (label.isNotEmpty()) {
                LabelMediumTextView(
                    label,
                    fontWeight = FontWeight.Normal,
                    color = titleTextColor
                )
            }
            Spacer(modifier = Modifier.height(4.dp))

            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                visualTransformation = visualTransformation,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = keyboardType,
                    imeAction = imeAction
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        onImeAction?.invoke()
                        keyboardController?.hide()
                    }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, borderColorName, shape = RoundedCornerShape(8.dp))
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                textStyle = MaterialTheme.typography.titleLarge,
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        if (value.isEmpty()) {
                            LabelMediumTextView(placeholder, color = hintColor)
                        }
                        innerTextField()
                    }
                }
            )

            if (isError && errorText != null) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = errorText,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Red
                )
            }
        }
    }
}


@Composable
fun OtpCell(
    modifier: Modifier,
    value: Char?,
    isCursorVisible: Boolean = false,
    obscureText: String?
) {
    val scope = rememberCoroutineScope()
    val (cursorSymbol, setCursorSymbol) = remember { mutableStateOf("") }

    LaunchedEffect(key1 = cursorSymbol, isCursorVisible) {
        if (isCursorVisible) {
            scope.launch {
                delay(350)
                setCursorSymbol(if (cursorSymbol.isEmpty()) "|" else "")
            }
        }
    }

    Box(
        modifier = modifier
    ) {
        Text(
            text = if (isCursorVisible) cursorSymbol else if (!obscureText.isNullOrBlank() && value?.toString()
                    .isNullOrBlank().not()
            ) obscureText else value?.toString() ?: "",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PinInput(
    modifier: Modifier = Modifier,
    cellModifier: Modifier = Modifier
        .size(width = 45.dp, height = 45.dp)
        .clip(MaterialTheme.shapes.large)
        .background(
            MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
            shape = RoundedCornerShape(3.dp)
        ),
    spacerModifier: Modifier = Modifier.size(8.dp),
    length: Int = 4,
    value: String = "",
    disableKeypad: Boolean = false,
    obscureText: String? = "*",
    cursorVisibleOnlyOnFocus: Boolean = true,
    onValueChanged: (String) -> Unit
) {
    val focusRequester = remember { FocusRequester() }
    val keyboard = LocalSoftwareKeyboardController.current
    val isFocused = remember { mutableStateOf(false) }
    val isFirstLaunch = remember { mutableStateOf(true) }

    TextField(
        readOnly = disableKeypad,
        value = value,
        onValueChange = { newValue ->
            if (newValue.length <= length) {
                if (newValue.all { c -> c in '0'..'9' }) {
                    onValueChanged(newValue)
                }
                if (newValue.length >= length) {
                    keyboard?.hide()
                }
            }
        },
        modifier = Modifier
            .size(1.dp)
            .focusRequester(focusRequester)
            .onFocusChanged {
                isFocused.value = it.isFocused
            },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        )
    )

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(length) { index ->
            OtpCell(
                modifier = cellModifier.clickable {
                    focusRequester.requestFocus()
                    keyboard?.show()
                },
                value = value.getOrNull(index),
                isCursorVisible = !disableKeypad && (isFocused.value || !cursorVisibleOnlyOnFocus) && value.length == index,
                obscureText = obscureText
            )

            LaunchedEffect(key1 = isFirstLaunch.value, key2 = index) {
                if (isFirstLaunch.value && index == 0) {
                    focusRequester.requestFocus()
                    isFirstLaunch.value = false
                }
            }

            if (index != length - 1)
                Spacer(modifier = spacerModifier)
        }
    }
}