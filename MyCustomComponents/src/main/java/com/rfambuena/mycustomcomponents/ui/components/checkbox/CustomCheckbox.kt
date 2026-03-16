package com.rfambuena.mycustomcomponents.ui.components.checkbox

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rfambuena.mycustomcomponents.R
import com.rfambuena.mycustomcomponents.ui.theme.label100

@Composable
fun CustomCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    val tintColor = if (enabled) {
        if (checked) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.onBackground
        }
    } else {
        MaterialTheme.colorScheme.primaryFixed
    }

    Row(
        modifier = modifier.getClickable(
            enabled = enabled,
            checked = checked,
            onCheckedChange = onCheckedChange
        ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        IconToggleButton(
            checked = checked,
            onCheckedChange = onCheckedChange,
            modifier = Modifier.size(24.dp),
            enabled = enabled
        ) {
            Icon(
                painter = painterResource(
                    if (checked) {
                        R.drawable.ic_checkbox_checked
                    } else {
                        R.drawable.ic_checkbox_unchecked
                    }
                ),
                contentDescription = null,
                tint = tintColor
            )
        }
        Text(
            text = text,
            style = label100,
            color = tintColor,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

private fun Modifier.getClickable(
    enabled: Boolean,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
): Modifier {
    return if (enabled) {
        this.clickable { if (enabled) onCheckedChange.invoke(!checked) }
    } else {
        this
    }
}

@Preview
@Composable
fun CustomCheckboxPreview() {
    val checkedState = remember { mutableStateOf(true) }
    Row {
        CustomCheckbox(
            checked = checkedState.value,
            text = "Custom Checkbox",
            onCheckedChange = { checkedState.value = it }
        )
        CustomCheckbox(
            checked = checkedState.value,
            text = "Custom Checkbox Disabled",
            enabled = false,
            onCheckedChange = { checkedState.value = it },
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}
