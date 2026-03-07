package com.rfambuena.mycustomcomponents.ui.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rfambuena.mycustomcomponents.R
import com.rfambuena.mycustomcomponents.ui.theme.Disabled
import com.rfambuena.mycustomcomponents.ui.theme.E800
import com.rfambuena.mycustomcomponents.ui.theme.FontColor
import com.rfambuena.mycustomcomponents.ui.theme.Primary
import com.rfambuena.mycustomcomponents.ui.theme.label100

@Composable
fun CustomButton(
    type: CustomButtonType,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leftIcon: Painter? = null,
    rightIcon: Painter? = null
) {
    Button(
        modifier = modifier,
        onClick = { onClick() },
        enabled = enabled,
        shape = RoundedCornerShape(2.dp),
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = getContainerColor(type),
            contentColor = getContentColor(type),
            disabledContainerColor = getDisabledContainerColor(type),
            disabledContentColor = getDisabledContentColor(type)
        ),
        border = getBorder(type, enabled)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            leftIcon?.let {
                DrawIconButton(painter = it)
            }
            if (text.isNotBlank()) {
                Text(
                    text = text,
                    style = label100,
                    modifier = Modifier.padding(horizontal = 8.dp),
                    textAlign = TextAlign.Center
                )
            }
            rightIcon?.let {
                DrawIconButton(painter = it)
            }
        }
    }
}

@Composable
fun CustomIconButton(
    type: CustomButtonType,
    onClick: () -> Unit,
    icon: Painter,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    CustomButton(
        type = type,
        text = "",
        onClick = { onClick() },
        modifier = modifier,
        enabled = enabled,
        leftIcon = icon
    )
}

private fun getContainerColor(type: CustomButtonType): Color =
    when (type) {
        CustomButtonType.PRIMARY -> Primary
        CustomButtonType.DESTRUCTIVE -> E800
        CustomButtonType.SECONDARY,
        CustomButtonType.NEUTRAL,
        CustomButtonType.NEUTRAL_DESTRUCTIVE -> Color.Transparent
    }

private fun getContentColor(type: CustomButtonType): Color =
    when (type) {
        CustomButtonType.DESTRUCTIVE,
        CustomButtonType.PRIMARY -> Color.White

        CustomButtonType.SECONDARY,
        CustomButtonType.NEUTRAL -> Primary

        CustomButtonType.NEUTRAL_DESTRUCTIVE -> E800
    }

private fun getDisabledContainerColor(type: CustomButtonType): Color =
    when (type) {
        CustomButtonType.DESTRUCTIVE,
        CustomButtonType.PRIMARY -> Disabled

        CustomButtonType.SECONDARY,
        CustomButtonType.NEUTRAL,
        CustomButtonType.NEUTRAL_DESTRUCTIVE -> Color.Transparent
    }

private fun getDisabledContentColor(type: CustomButtonType): Color =
    when (type) {
        CustomButtonType.DESTRUCTIVE,
        CustomButtonType.PRIMARY -> FontColor

        CustomButtonType.SECONDARY,
        CustomButtonType.NEUTRAL,
        CustomButtonType.NEUTRAL_DESTRUCTIVE -> Disabled
    }

private fun getBorder(type: CustomButtonType, enabled: Boolean): BorderStroke? =
    when (type) {
        CustomButtonType.PRIMARY,
        CustomButtonType.SECONDARY -> BorderStroke(
            width = 1.dp,
            color = if (enabled) Primary else Disabled
        )

        CustomButtonType.DESTRUCTIVE -> BorderStroke(
            width = 1.dp,
            color = if (enabled) E800 else Disabled
        )

        CustomButtonType.NEUTRAL,
        CustomButtonType.NEUTRAL_DESTRUCTIVE -> null
    }

@Composable
private fun DrawIconButton(painter: Painter) {
    Icon(
        painter = painter,
        contentDescription = null,
        modifier = Modifier.size(24.dp)
    )
}

@Preview
@Composable
fun PreviewCustomButton() {
    Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
        CustomButton(
            type = CustomButtonType.PRIMARY,
            text = "Primary button",
            onClick = {}
        )
        CustomButton(
            type = CustomButtonType.PRIMARY,
            text = "Primary button disabled",
            onClick = {},
            enabled = false
        )
        CustomButton(
            type = CustomButtonType.PRIMARY,
            text = "Primary button (left icon)",
            onClick = {},
            leftIcon = painterResource(R.drawable.ic_chat)
        )
        CustomButton(
            type = CustomButtonType.PRIMARY,
            text = "Primary button disabled (left icon)",
            onClick = {},
            leftIcon = painterResource(R.drawable.ic_chat),
            enabled = false
        )
        CustomButton(
            type = CustomButtonType.PRIMARY,
            text = "Primary button (right icon)",
            onClick = {},
            rightIcon = painterResource(R.drawable.ic_chat)
        )
        CustomButton(
            type = CustomButtonType.SECONDARY,
            text = "Secondary button",
            onClick = {}
        )
        CustomButton(
            type = CustomButtonType.SECONDARY,
            text = "Secondary button disabled",
            onClick = {},
            enabled = false
        )
        CustomButton(
            type = CustomButtonType.NEUTRAL,
            text = "Neutral button",
            onClick = {}
        )
        CustomButton(
            type = CustomButtonType.NEUTRAL,
            text = "Neutral button disabled",
            onClick = {},
            enabled = false
        )
        CustomButton(
            type = CustomButtonType.DESTRUCTIVE,
            text = "Destructive button",
            onClick = {}
        )
        CustomButton(
            type = CustomButtonType.DESTRUCTIVE,
            text = "Destructive button disabled",
            onClick = {},
            enabled = false
        )
        CustomButton(
            type = CustomButtonType.NEUTRAL_DESTRUCTIVE,
            text = "Neutral destructive button",
            onClick = {}
        )
        CustomButton(
            type = CustomButtonType.NEUTRAL_DESTRUCTIVE,
            text = "Neutral destructive button disabled",
            onClick = {},
            enabled = false
        )
    }
}

@Preview
@Composable
fun PreviewCustomIconButton() {
    Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
        CustomIconButton(
            type = CustomButtonType.PRIMARY,
            onClick = {},
            icon = painterResource(R.drawable.ic_chat)
        )
        CustomIconButton(
            type = CustomButtonType.SECONDARY,
            onClick = {},
            icon = painterResource(R.drawable.ic_chat)
        )
        CustomIconButton(
            type = CustomButtonType.NEUTRAL,
            onClick = {},
            icon = painterResource(R.drawable.ic_chat)
        )
        CustomIconButton(
            type = CustomButtonType.DESTRUCTIVE,
            onClick = {},
            icon = painterResource(R.drawable.ic_chat)
        )
        CustomIconButton(
            type = CustomButtonType.NEUTRAL_DESTRUCTIVE,
            onClick = {},
            icon = painterResource(R.drawable.ic_chat)
        )
    }
}
