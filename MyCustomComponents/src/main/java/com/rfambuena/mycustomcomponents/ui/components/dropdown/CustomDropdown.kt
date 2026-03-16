package com.rfambuena.mycustomcomponents.ui.components.dropdown

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rfambuena.mycustomcomponents.R
import com.rfambuena.mycustomcomponents.ui.components.divider.CustomHorizontalDivider
import com.rfambuena.mycustomcomponents.ui.components.textfield.CustomSingleLineTextField
import com.rfambuena.mycustomcomponents.ui.theme.body100
import com.rfambuena.mycustomcomponents.ui.theme.libraryPalette

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> CustomDropdown(
    value: String,
    onValueChange: (String) -> Unit,
    items: List<T>,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: String? = null,
    placeholder: String? = stringResource(R.string.write_here),
    onItemSelected: ((T) -> Unit)? = null,
) {
    val expanded = remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val expandIcon = if (expanded.value) {
        painterResource(R.drawable.ic_arrow_up)
    } else {
        painterResource(R.drawable.ic_arrow_down)
    }

    ExposedDropdownMenuBox(
        expanded = expanded.value,
        onExpandedChange = {
            expanded.value = it
        },
        modifier = modifier
    ) {
        CustomSingleLineTextField(
            value = value,
            onValueChange = {},
            label = label,
            placeholder = placeholder,
            rightIcon = expandIcon,
            modifier = Modifier
                .menuAnchor(ExposedDropdownMenuAnchorType.PrimaryEditable, true)
                .fillMaxWidth(),
            readOnly = true
        )

        if (expanded.value && items.isNotEmpty() && enabled) {
            keyboardController?.hide()
            ExposedDropdownMenu(
                expanded = expanded.value,
                onDismissRequest = { expanded.value = false },
                modifier = Modifier.background(libraryPalette.focusedContainerColor)
            ) {
                items.forEach { item ->
                    DropdownMenuItem(
                        text = { CustomDropdownItem(item.toString()) },
                        onClick = {
                            onValueChange(item.toString())
                            onItemSelected?.invoke(item)
                            expanded.value = false
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun CustomDropdownItem(itemText: String) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(
            text = itemText,
            style = body100,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        CustomHorizontalDivider()
    }
}

@Preview(showBackground = true)
@Composable
fun CustomDropdownPreview() {
    val selectedItem = remember { mutableStateOf("") }
    val items = listOf("Option 1", "Option 2", "Option 3", "Option 4", "Option 5")

    CustomDropdown(
        value = selectedItem.value,
        onValueChange = { selectedItem.value = it },
        items = items,
        label = "Select an option",
        placeholder = "Choose one",
        modifier = Modifier.fillMaxWidth()
    )
}
