package com.example.coffeetaste.core.designsystem.components.getstarted

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.coffeetaste.core.designsystem.theme.CoffeeTasteTheme

/**
 * Full-width CTA button for Get Started. Uses design system colors: dark theme = single block, light theme = two-tone (text area + gold icon area).
 */
@Composable
fun GetStartedCtaButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val extra = CoffeeTasteTheme.extra
    val shape = RoundedCornerShape(24.dp)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(shape)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .height(56.dp)
                .background(extra.ctaButtonBackground),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Get Started",
                style = MaterialTheme.typography.bodyLarge,
                color = extra.onCtaButton
            )
        }
        Box(
            modifier = Modifier
                .width(56.dp)
                .height(56.dp)
                .background(extra.ctaButtonIconSection),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowForward,
                contentDescription = "Arrow right",
                modifier = Modifier.size(24.dp),
                tint = extra.onCtaButton
            )
        }
    }
}
