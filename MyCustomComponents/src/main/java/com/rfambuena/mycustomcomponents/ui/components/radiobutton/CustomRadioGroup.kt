package com.rfambuena.mycustomcomponents.ui.components.radiobutton

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun <T> CustomRadioGroup(
    items: List<T>,
    modifier: Modifier = Modifier,
    checked: T? = null,
    onItemChecked: (T?) -> Unit,
    enabled: Boolean = true,
    verticalDisplay: Boolean = true
) {
    val selection = remember { mutableStateOf(checked) }
    if (verticalDisplay) {
        Column(modifier = modifier) {
            RadioGroupContent(
                items = items,
                selection = selection,
                onItemChecked = onItemChecked,
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                enabled = enabled
            )
        }
    } else {
        Row(modifier = modifier) {
            RadioGroupContent(
                items = items,
                selection = selection,
                onItemChecked = onItemChecked,
                modifier = Modifier.weight(1f).padding(end = 4.dp),
                enabled = enabled
            )
        }
    }
}

@Composable
private fun <T> RadioGroupContent(
    items: List<T>,
    selection: MutableState<T?>,
    onItemChecked: (T?) -> Unit,
    modifier: Modifier,
    enabled: Boolean
) {
    items.forEach { item ->
        CustomRadioButton(
            checked = item == selection.value,
            onCheckedChange = {
                onItemChecked(item)
                selection.value = item
            },
            text = item.toString(),
            modifier = modifier,
            enabled = enabled
        )
    }
}

@Preview
@Composable
fun CustomRadioGroupPreview() {
    val items = listOf("Option 1", "Option 2", "Option 3", "Option 4")
    val selectedOption = remember { mutableStateOf<String?>(null) }
    CustomRadioGroup(
        items = items,
        checked = selectedOption.value,
        onItemChecked = { selectedOption.value = it },
        modifier = Modifier.fillMaxWidth(),
        enabled = true
    )
    CustomRadioGroup(
        items = items,
        checked = selectedOption.value,
        onItemChecked = { selectedOption.value = it },
        modifier = Modifier.fillMaxWidth(),
        enabled = true,
        verticalDisplay = false
    )
}