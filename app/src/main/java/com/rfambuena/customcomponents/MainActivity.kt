package com.rfambuena.customcomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
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
import com.rfambuena.customcomponents.ui.theme.Background
import com.rfambuena.customcomponents.ui.theme.CustomComponentsTheme
import com.rfambuena.mycustomcomponents.ui.components.button.PreviewCustomButton
import com.rfambuena.mycustomcomponents.ui.components.button.PreviewCustomIconButton
import com.rfambuena.mycustomcomponents.ui.components.divider.horizontal.CustomHorizontalDivider
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
                        .background(Background)
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
    }
}
