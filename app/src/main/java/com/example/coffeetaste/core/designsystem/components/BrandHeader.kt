package com.example.coffeetaste.core.designsystem.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeetaste.R

@Composable
fun BrandHeader(
    titleColor: Color,
    modifier: Modifier = Modifier
) {
    // `modifier` is here so screens can position the header as a unit.
    androidx.compose.foundation.layout.Column(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.coffee_cup),
            contentDescription = stringResource(R.string.cd_coffee_taste_logo),
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = stringResource(R.string.brand_title_upper),
            style = MaterialTheme.typography.labelLarge,
            color = titleColor,
            letterSpacing = 3.sp
        )
    }
}

