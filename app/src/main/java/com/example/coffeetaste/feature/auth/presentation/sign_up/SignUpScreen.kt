package com.example.coffeetaste.feature.auth.presentation.sign_up

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.coffeetaste.R
import com.example.coffeetaste.core.designsystem.components.BrandHeader
import com.example.coffeetaste.core.designsystem.components.CoffeeTasteCtaButton
import com.example.coffeetaste.core.designsystem.components.CoffeeTasteTextField
import com.example.coffeetaste.core.designsystem.theme.CoffeeTasteExtraColors
import com.example.coffeetaste.core.designsystem.theme.CoffeeTasteTheme

@Composable
fun SignUpScreen(
    onSignUpClick: () -> Unit = {},
    onSignInClick: () -> Unit = {},
    onForgotPasswordClick: () -> Unit = {}
) {
    SignUpContent(
        isDarkTheme = CoffeeTasteTheme.isDark,
        extra = CoffeeTasteTheme.extra,
        onSignUpClick = onSignUpClick,
        onSignInClick = onSignInClick,
        onForgotPasswordClick = onForgotPasswordClick
    )
}

@Composable
private fun SignUpContent(
    isDarkTheme: Boolean,
    extra: CoffeeTasteExtraColors,
    onSignUpClick: () -> Unit,
    onSignInClick: () -> Unit,
    onForgotPasswordClick: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rePassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var rePasswordVisible by remember { mutableStateOf(false) }

    val scrollState = rememberScrollState()

    if (isDarkTheme) {
        // Dark theme: full-bleed background with brand header
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(R.drawable.get_started_bg),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(48.dp))

                BrandHeader(titleColor = extra.heroTitle)

                Spacer(modifier = Modifier.height(32.dp))

                // Title
                Text(
                    text = stringResource(R.string.sign_up_title),
                    style = MaterialTheme.typography.headlineLarge,
                    color = extra.heroHeadline,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Subtitle
                Text(
                    text = stringResource(R.string.sign_up_subtitle),
                    style = MaterialTheme.typography.bodyMedium,
                    color = extra.heroSubtitle,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Form fields
                SignUpFormFields(
                    email = email,
                    onEmailChange = { email = it },
                    password = password,
                    onPasswordChange = { password = it },
                    rePassword = rePassword,
                    onRePasswordChange = { rePassword = it },
                    passwordVisible = passwordVisible,
                    onPasswordVisibilityToggle = { passwordVisible = !passwordVisible },
                    rePasswordVisible = rePasswordVisible,
                    onRePasswordVisibilityToggle = { rePasswordVisible = !rePasswordVisible }
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Forgot Password Link
                Text(
                    text = stringResource(R.string.forgot_password),
                    style = MaterialTheme.typography.bodyMedium,
                    color = extra.heroAccent,
                    modifier = Modifier
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = onForgotPasswordClick
                        )
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Sign Up Button
                CoffeeTasteCtaButton(
                    text = stringResource(R.string.sign_up_cta),
                    onClick = onSignUpClick,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Already have an account
                SignUpFooter(
                    textColor = extra.heroSubtitle,
                    linkColor = extra.heroAccent,
                    onSignInClick = onSignInClick
                )

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    } else {
        // Light theme: illustration at top
        val colors = CoffeeTasteTheme.colors

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colors.background)
                .verticalScroll(scrollState)
        ) {
            // Top illustration
            Image(
                painter = painterResource(R.drawable.get_started_bg),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopCenter
            )

            // Content
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(32.dp))

                // Title
                Text(
                    text = stringResource(R.string.sign_up_title),
                    style = MaterialTheme.typography.headlineLarge,
                    color = colors.onBackground,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Subtitle
                Text(
                    text = stringResource(R.string.sign_up_subtitle),
                    style = MaterialTheme.typography.bodyMedium,
                    color = colors.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Form fields
                SignUpFormFields(
                    email = email,
                    onEmailChange = { email = it },
                    password = password,
                    onPasswordChange = { password = it },
                    rePassword = rePassword,
                    onRePasswordChange = { rePassword = it },
                    passwordVisible = passwordVisible,
                    onPasswordVisibilityToggle = { passwordVisible = !passwordVisible },
                    rePasswordVisible = rePasswordVisible,
                    onRePasswordVisibilityToggle = { rePasswordVisible = !rePasswordVisible }
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Forgot Password Link
                Text(
                    text = stringResource(R.string.forgot_password),
                    style = MaterialTheme.typography.bodyMedium,
                    color = colors.primary,
                    modifier = Modifier
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = onForgotPasswordClick
                        )
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Sign Up Button
                CoffeeTasteCtaButton(
                    text = stringResource(R.string.sign_up_cta),
                    onClick = onSignUpClick,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Already have an account
                SignUpFooter(
                    textColor = colors.onSurfaceVariant,
                    linkColor = colors.primary,
                    onSignInClick = onSignInClick
                )

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@Composable
private fun SignUpFormFields(
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    rePassword: String,
    onRePasswordChange: (String) -> Unit,
    passwordVisible: Boolean,
    onPasswordVisibilityToggle: () -> Unit,
    rePasswordVisible: Boolean,
    onRePasswordVisibilityToggle: () -> Unit
) {
    // Email Field
    CoffeeTasteTextField(
        value = email,
        onValueChange = onEmailChange,
        label = stringResource(R.string.label_email),
        placeholder = stringResource(R.string.hint_email),
        leadingIcon = painterResource(R.drawable.email),
        isRequired = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )

    Spacer(modifier = Modifier.height(16.dp))

    // Password Field
    CoffeeTasteTextField(
        value = password,
        onValueChange = onPasswordChange,
        label = stringResource(R.string.label_password),
        leadingIcon = painterResource(R.drawable.password_dot),
        trailingIcon = painterResource(
            if (passwordVisible) R.drawable.eye_open else R.drawable.eye_close
        ),
        onTrailingIconClick = onPasswordVisibilityToggle,
        isPassword = true,
        passwordVisible = passwordVisible,
        isRequired = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )

    Spacer(modifier = Modifier.height(16.dp))

    // Re-Password Field
    CoffeeTasteTextField(
        value = rePassword,
        onValueChange = onRePasswordChange,
        label = stringResource(R.string.label_re_password),
        leadingIcon = painterResource(R.drawable.password_dot),
        trailingIcon = painterResource(
            if (rePasswordVisible) R.drawable.eye_open else R.drawable.eye_close
        ),
        onTrailingIconClick = onRePasswordVisibilityToggle,
        isPassword = true,
        passwordVisible = rePasswordVisible,
        isRequired = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}

@Composable
private fun SignUpFooter(
    textColor: Color,
    linkColor: Color,
    onSignInClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.already_have_account),
            style = MaterialTheme.typography.bodyMedium,
            color = textColor
        )
        Text(
            text = "  ",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = stringResource(R.string.sign_in_link),
            style = MaterialTheme.typography.bodyMedium,
            color = linkColor,
            modifier = Modifier.clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onSignInClick
            )
        )
    }
}
