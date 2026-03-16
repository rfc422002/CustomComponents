package com.rfambuena.mycustomcomponents.ui.components.autocomplete

import androidx.annotation.IntRange
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rfambuena.mycustomcomponents.R
import com.rfambuena.mycustomcomponents.ui.components.divider.CustomHorizontalDivider
import com.rfambuena.mycustomcomponents.ui.components.textfield.CustomSingleLineTextField
import com.rfambuena.mycustomcomponents.ui.theme.body100

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> CustomAutoCompleteTextField(
    value: String,
    onValueChange: (String) -> Unit,
    suggestions: List<T>,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: String? = null,
    placeholder: String? = stringResource(R.string.write_here),
    leftIcon: Painter? = null,
    rightIcon: Painter? = null,
    onSuggestionSelected: ((T) -> Unit)? = null,
    @IntRange(from = 0) minQueryLength: Int = 0,
) {
    val expanded = remember { mutableStateOf(false) }

    val filteredSuggestions = suggestions.filter {
        it.toString().contains(value, ignoreCase = true)
    }

    ExposedDropdownMenuBox(
        expanded = expanded.value,
        onExpandedChange = { expanded.value = it },
        modifier = modifier
    ) {
        CustomSingleLineTextField(
            value = value,
            onValueChange = {
                onValueChange(it)
                expanded.value = true
            },
            label = label,
            placeholder = placeholder,
            leftIcon = leftIcon,
            rightIcon = rightIcon,
            enabled = enabled,
            modifier = Modifier
                .menuAnchor(ExposedDropdownMenuAnchorType.PrimaryEditable, true)
                .fillMaxWidth()
        )

        if (
            expanded.value &&
            value.length >= minQueryLength &&
            filteredSuggestions.isNotEmpty() &&
            enabled
        ) {
            ExposedDropdownMenu(
                expanded = expanded.value,
                onDismissRequest = { expanded.value = false },
                modifier = Modifier.background(MaterialTheme.colorScheme.surfaceContainerHigh)
            ) {
                filteredSuggestions.forEach { suggestion ->
                    DropdownMenuItem(
                        text = { CustomAutoCompleteItem(suggestion.toString()) },
                        onClick = {
                            onValueChange(suggestion.toString())
                            onSuggestionSelected?.invoke(suggestion)
                            expanded.value = false
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun CustomAutoCompleteItem(suggestion: String) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(
            text = suggestion,
            style = body100,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        CustomHorizontalDivider()
    }
}

@Preview(showBackground = true)
@Composable
fun CustomAutoCompleteTextFieldPreview() {
    val text = remember { mutableStateOf("") }
    val suggestions = listOf("Apple", "Banana", "Cherry", "Date", "Grape", "Lemon", "Orange")

    CustomAutoCompleteTextField(
        value = text.value,
        onValueChange = { text.value = it },
        suggestions = suggestions,
        label = "Fruits",
        placeholder = "Search for a fruit",
        modifier = Modifier.fillMaxWidth(),
        minQueryLength = 2
    )
}
