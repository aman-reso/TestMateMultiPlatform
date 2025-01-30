package org.com.testmatemultiplatform.core.components

import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.com.testmatemultiplatform.core.theme.greyActiveColor
import org.com.testmatemultiplatform.core.theme.greyTextColor
import org.com.testmatemultiplatform.core.theme.titleTextColor
import org.com.testmatemultiplatform.core.theme.whiteColor


@Composable
fun AppSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        colors = SwitchDefaults.colors(
            checkedThumbColor = whiteColor,
            uncheckedThumbColor = greyActiveColor,
            checkedTrackColor = titleTextColor,
            uncheckedBorderColor = titleTextColor
        )
    )
}

@Composable
fun AppCheckBox(
    checked: Boolean,
    modifier: Modifier = Modifier,
    onCheckedChange: (Boolean) -> Unit
) {
    Checkbox(
        modifier = modifier,
        checked = checked,
        onCheckedChange = onCheckedChange,
        colors = CheckboxDefaults.colors(
            checkmarkColor = whiteColor,
            uncheckedColor = titleTextColor,
            checkedColor = titleTextColor
        )
    )
}

@Composable
fun AppRadioBtn(
    selected: Boolean,
    onClick: () -> Unit
) {
    RadioButton(
        selected = selected,
        onClick = onClick,
        colors = RadioButtonDefaults.colors(
            selectedColor = titleTextColor,
            unselectedColor = greyTextColor,
            disabledSelectedColor = greyActiveColor
        )
    )
}