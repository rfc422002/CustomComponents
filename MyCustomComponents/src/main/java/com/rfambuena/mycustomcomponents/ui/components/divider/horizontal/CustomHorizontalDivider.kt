package com.rfambuena.mycustomcomponents.ui.components.divider.horizontal

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomHorizontalDivider(
    verticalPadding: Int = 0,
    horizontalPadding: Int = 0
) {
    HorizontalDivider(
        modifier = Modifier
            .padding(vertical = verticalPadding.dp, horizontal = horizontalPadding.dp)
            .fillMaxWidth()
    )
}