package com.example.coffeetaste.core.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.coffeetaste.core.designsystem.theme.CoffeeTasteTheme

@Composable
fun CoffeeTasteTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    leadingIcon: Painter? = null,
    trailingIcon: Painter? = null,
    onTrailingIconClick: (() -> Unit)? = null,
    isPassword: Boolean = false,
    passwordVisible: Boolean = false,
    placeholder: String = "",
    isRequired: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    val colors = CoffeeTasteTheme.colors
    val isDark = CoffeeTasteTheme.isDark
    val shape = RoundedCornerShape(12.dp)

    // Adaptive colors based on theme
    val backgroundColor = if (isDark) {
        Color.White.copy(alpha = 0.08f)
    } else {
        colors.surface
    }
    val borderColor = if (isDark) {
        Color.White.copy(alpha = 0.2f)
    } else {
        colors.outline
    }
    val labelColor = if (isDark) {
        Color.White.copy(alpha = 0.7f)
    } else {
        colors.onSurfaceVariant
    }
    val textColor = if (isDark) {
        Color.White
    } else {
        colors.onSurface
    }
    val placeholderColor = if (isDark) {
        Color.White.copy(alpha = 0.4f)
    } else {
        colors.onSurfaceVariant.copy(alpha = 0.6f)
    }
    val iconTint = if (isDark) {
        Color.White.copy(alpha = 0.7f)
    } else {
        colors.onSurfaceVariant
    }

    Column(modifier = modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                color = labelColor
            )
            if (isRequired) {
                Text(
                    text = " *",
                    style = MaterialTheme.typography.labelMedium,
                    color = Color(0xFFE53935)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(shape)
                .border(1.dp, borderColor, shape)
                .background(backgroundColor)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (leadingIcon != null) {
                    Icon(
                        painter = leadingIcon,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        tint = iconTint
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                }

                Box(modifier = Modifier.weight(1f)) {
                    if (value.isEmpty() && placeholder.isNotEmpty()) {
                        Text(
                            text = placeholder,
                            style = MaterialTheme.typography.bodyLarge,
                            color = placeholderColor
                        )
                    }
                    BasicTextField(
                        value = value,
                        onValueChange = onValueChange,
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = MaterialTheme.typography.bodyLarge.copy(
                            color = textColor
                        ),
                        singleLine = true,
                        keyboardOptions = keyboardOptions,
                        visualTransformation = if (isPassword && !passwordVisible) {
                            PasswordVisualTransformation()
                        } else {
                            VisualTransformation.None
                        },
                        cursorBrush = SolidColor(if (isDark) Color.White else colors.primary)
                    )
                }

                if (trailingIcon != null) {
                    Spacer(modifier = Modifier.width(12.dp))
                    Icon(
                        painter = trailingIcon,
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                            .then(
                                if (onTrailingIconClick != null) {
                                    Modifier.clickable(
                                        interactionSource = remember { MutableInteractionSource() },
                                        indication = null,
                                        onClick = onTrailingIconClick
                                    )
                                } else {
                                    Modifier
                                }
                            ),
                        tint = iconTint
                    )
                }
            }
        }
    }
}
