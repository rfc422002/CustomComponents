package com.rfambuena.mycustomcomponents.ui.components.radiobutton

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
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
import com.rfambuena.mycustomcomponents.ui.theme.libraryPalette

@Composable
fun CustomRadioButton(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    val tintColor = if (enabled) {
        if (checked) {
            libraryPalette.primaryButtonColor
        } else {
            libraryPalette.textColor
        }
    } else {
        libraryPalette.disabledColor
    }

    Row(
        modifier = modifier.getClickable(enabled, onCheckedChange),
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
                        R.drawable.ic_radio_button
                    } else {
                        R.drawable.ic_unselected_radio_button
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
    onCheckedChange: (Boolean) -> Unit
): Modifier {
    return if (enabled) {
        this.clickable { if (enabled) onCheckedChange.invoke(true) }
    } else {
        this
    }
}

@Preview
@Composable
fun PreviewCustomRadioButton() {
    Column {
        for (i in 1..3) {
            val checkedState = remember { mutableStateOf(false) }
            CustomRadioButton(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it },
                text = "Option $i",
                modifier = Modifier.padding(8.dp),
                enabled = i % 2 == 0
            )
        }
    }
}
