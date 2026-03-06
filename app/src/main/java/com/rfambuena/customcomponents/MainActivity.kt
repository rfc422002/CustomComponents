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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.rfambuena.customcomponents.ui.theme.CustomComponentsTheme
import com.rfambuena.mycustomcomponents.ui.components.texts.TextPreview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CustomComponentsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val verticalScroll = rememberScrollState()
                    Components(innerPadding, verticalScroll)
                }
            }
        }
    }
}

@Composable
private fun Components(
    innerPadding: PaddingValues,
    verticalScroll: ScrollState
) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .verticalScroll(verticalScroll)
            .background(Color.White)
    ) {
        // implement previews here
        TextPreview()
        HorizontalDivider()
    }
}
