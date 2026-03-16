package com.rfambuena.customcomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rfambuena.customcomponents.ui.theme.CustomComponentsTheme
import com.rfambuena.mycustomcomponents.ui.components.autocomplete.CustomAutoCompleteTextFieldPreview
import com.rfambuena.mycustomcomponents.ui.components.button.PreviewCustomButton
import com.rfambuena.mycustomcomponents.ui.components.button.PreviewCustomIconButton
import com.rfambuena.mycustomcomponents.ui.components.checkbox.CustomCheckboxPreview
import com.rfambuena.mycustomcomponents.ui.components.divider.CustomHorizontalDivider
import com.rfambuena.mycustomcomponents.ui.components.divider.CustomHorizontalDividerWithText
import com.rfambuena.mycustomcomponents.ui.components.dropdown.CustomDropdownPreview
import com.rfambuena.mycustomcomponents.ui.components.radiobutton.CustomRadioGroupPreview
import com.rfambuena.mycustomcomponents.ui.components.radiobutton.PreviewCustomRadioButton
import com.rfambuena.mycustomcomponents.ui.components.textfield.CustomSingleLineTextFieldPreview
import com.rfambuena.mycustomcomponents.ui.components.textfield.CustomTextFieldPreview
import com.rfambuena.mycustomcomponents.ui.components.textfield.SearchCustomTextFieldPreview
import com.rfambuena.mycustomcomponents.ui.components.texts.TextPreview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CustomComponentsTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                ) { innerPadding ->
                    val verticalScroll = rememberScrollState()
                    MainScreen(innerPadding, verticalScroll)
                }
            }
        }
    }
}

@Composable
private fun MainScreen(
    innerPadding: PaddingValues,
    verticalScroll: ScrollState
) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .verticalScroll(verticalScroll)
    ) {
        Components()
    }
}

@Composable
private fun Components() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        TextPreview()
        CustomHorizontalDivider(verticalPadding = 24)
        PreviewCustomButton()
        CustomHorizontalDivider(verticalPadding = 24)
        PreviewCustomIconButton()
        CustomHorizontalDivider(verticalPadding = 24)
        CustomTextFieldPreview()
        CustomHorizontalDivider(verticalPadding = 24)
        CustomSingleLineTextFieldPreview()
        CustomHorizontalDivider(verticalPadding = 24)
        SearchCustomTextFieldPreview()
        CustomHorizontalDivider(verticalPadding = 24)
        CustomAutoCompleteTextFieldPreview()
        CustomHorizontalDivider(verticalPadding = 24)
        CustomDropdownPreview()
        CustomHorizontalDividerWithText(
            text = "Custom Radio Button",
            verticalPadding = 24
        )
        PreviewCustomRadioButton()
        CustomHorizontalDividerWithText(
            text = "Custom Radio Group",
            verticalPadding = 24
        )
        CustomRadioGroupPreview()
        CustomHorizontalDividerWithText(
            text = "Custom Checkbox",
            verticalPadding = 24
        )
        CustomCheckboxPreview()
    }
}
