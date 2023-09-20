package com.kenkoro.jetsurvey.auth.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kenkoro.jetsurvey.R
import com.kenkoro.jetsurvey.auth.EmailState
import com.kenkoro.jetsurvey.auth.EmailStateSaver
import com.kenkoro.jetsurvey.ui.theme.stronglyDeemphasizedAlpha

@Composable
fun SignInCreateAccount(
    onAuth: (email: String) -> Unit,
    onSignInAsGuest: () -> Unit,
    onFocusChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val emailState by rememberSaveable(stateSaver = EmailStateSaver) {
            mutableStateOf(EmailState())
        }

        Text(
            text = stringResource(id = R.string.sign_in_create_account),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = stronglyDeemphasizedAlpha),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 64.dp, bottom = 12.dp)
        )

        val onSubmit = {
            if (emailState.isValid) {
                onAuth(emailState.text)
            } else {
                emailState.enableShowErrors()
            }
        }

        onFocusChange(emailState.isFocused)
        Email(
            emailState = emailState,
            imeAction = ImeAction.Done,
            onImeAction = onSubmit
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 28.dp, bottom = 3.dp),
            onClick = onSubmit,
        ) {
            Text(
                text = stringResource(id = R.string.user_continue),
                style = MaterialTheme.typography.titleSmall
            )
        }
        OrSignInAsGuest(
            modifier = Modifier
                .fillMaxWidth(),
            onSignInAsGuest = onSignInAsGuest
        )
    }
}