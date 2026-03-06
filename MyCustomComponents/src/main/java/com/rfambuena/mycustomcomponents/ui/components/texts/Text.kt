package com.rfambuena.mycustomcomponents.ui.components.texts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rfambuena.mycustomcomponents.ui.theme.*

@Preview
@Composable
fun TextPreview() {
    Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
        Text(text = "Title 300", style = title300())
        Text(text = "Title 200", style = title200())
        Text(text = "Title 100", style = title100())
        Text(text = "Body 200", style = body200())
        Text(text = "Body 100", style = body100())
        Text(text = "Label 100", style = label100())
    }
}
