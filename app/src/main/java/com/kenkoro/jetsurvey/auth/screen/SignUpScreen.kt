package com.kenkoro.jetsurvey.auth.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.kenkoro.jetsurvey.R
import com.kenkoro.jetsurvey.auth.AuthTopAppBar
import com.kenkoro.jetsurvey.auth.ui.AuthScreen
import com.kenkoro.jetsurvey.auth.ui.SignUpContent
import com.kenkoro.jetsurvey.util.supportWideScreen

@Composable
fun SignUpScreen(
    email: String?,
    onSignUpSubmitted: (email: String, password: String) -> Unit,
    onSignInAsGuest: () -> Unit,
    onNavUp: () -> Unit
) {
    Scaffold(
        topBar = {
            AuthTopAppBar(
                topAppBarText = stringResource(id = R.string.create_account),
                onNavUp = onNavUp
            )
        },
        content = { contentPadding ->
            AuthScreen(
                onSignInAsGuest = onSignInAsGuest,
                contentPadding = contentPadding,
                modifier = Modifier.supportWideScreen()
            ) {
                Column {
                    SignUpContent(
                        email = email,
                        onSignUpSubmitted = onSignUpSubmitted
                    )
                }
            }
        }
    )
}