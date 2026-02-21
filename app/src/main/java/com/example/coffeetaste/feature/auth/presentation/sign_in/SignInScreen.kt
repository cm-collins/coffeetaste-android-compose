package com.example.coffeetaste.feature.auth.presentation.sign_in

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

/**
 * Sign In screen (View). Binds state to UI and sends events to ViewModel.
 */
@Composable
fun SignInScreen(
    state: SignInContract.State,
    onEvent: (SignInContract.Event) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Sign In",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(
            value = state.email,
            onValueChange = { onEvent(SignInContract.Event.EmailChanged(it)) },
            label = { Text("Email") },
            singleLine = true
        )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = state.password,
            onValueChange = { onEvent(SignInContract.Event.PasswordChanged(it)) },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true
        )
        state.errorMessage?.let { msg ->
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = msg,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { onEvent(SignInContract.Event.SignInClicked) },
            enabled = !state.isLoading
        ) {
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.height(24.dp))
            } else {
                Text("Sign In")
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = { onEvent(SignInContract.Event.SignUpClicked) }
        ) {
            Text("Go to Sign Up")
        }
    }
}
