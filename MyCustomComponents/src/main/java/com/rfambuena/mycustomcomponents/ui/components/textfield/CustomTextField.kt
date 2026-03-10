package com.rfambuena.mycustomcomponents.ui.components.textfield

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rfambuena.mycustomcomponents.R
import com.rfambuena.mycustomcomponents.ui.components.shapes.Shape
import com.rfambuena.mycustomcomponents.ui.theme.body100
import com.rfambuena.mycustomcomponents.ui.theme.label100

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: String? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    singleLine: Boolean = false,
    maxLines: Int = 4,
    minLines: Int = 1,
    leftIcon: Painter? = null,
    rightIcon: Painter? = null
) {
    Column(modifier = modifier) {
        label?.let {
            Text(
                text = label,
                style = label100,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
        OutlinedTextField(
            value = value,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = onValueChange,
            textStyle = body100,
            enabled = enabled,
            keyboardOptions = keyboardOptions,
            singleLine = singleLine,
            maxLines = maxLines,
            minLines = minLines,
            leadingIcon = leftIcon?.let { { Icon(it, null) } },
            trailingIcon = rightIcon?.let { { Icon(it, null) } },
            colors = TextFieldDefaults.colors(
                disabledContainerColor = MaterialTheme.colorScheme.primaryFixed,
                disabledTextColor = MaterialTheme.colorScheme.onBackground,
                unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainerLow,
                focusedTextColor = MaterialTheme.colorScheme.onBackground,
                focusedContainerColor = MaterialTheme.colorScheme.surfaceContainerHigh
            ),
            shape = Shape.small
        )
    }
}

@Composable
fun CustomSingleLineTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: String? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    leftIcon: Painter? = null,
    rightIcon: Painter? = null
) {
    CustomTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        label = label,
        keyboardOptions = keyboardOptions,
        singleLine = true,
        leftIcon = leftIcon,
        rightIcon = rightIcon,
        maxLines = 1,
        minLines = 1
    )
}

@Composable
fun SearchCustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    searchIcon: Painter = painterResource(R.drawable.ic_search)
){
    CustomSingleLineTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        leftIcon = searchIcon
    )
}

@Preview
@Composable
fun CustomTextFieldPreview() {
    val text = remember { mutableStateOf("hello my good friend") }
    Row {
        CustomTextField(
            value = text.value,
            onValueChange = { text.value = it },
            label = "Label",
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview
@Composable
fun CustomSingleLineTextFieldPreview() {
    val text = remember { mutableStateOf("hello my good friend") }
    Row {
        CustomSingleLineTextField(
            value = text.value,
            onValueChange = { text.value = it },
            label = "Label",
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview
@Composable
fun SearchCustomTextFieldPreview() {
    val text = remember { mutableStateOf("hello my good friend") }
    Row {
        SearchCustomTextField(
            value = text.value,
            onValueChange = { text.value = it },
            modifier = Modifier.weight(1f)
        )
        SearchCustomTextField(
            value = text.value,
            onValueChange = { text.value = it },
            modifier = Modifier.weight(1f)
        )
    }
}