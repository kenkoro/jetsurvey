package com.kenkoro.jetsurvey.auth.screen

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kenkoro.jetsurvey.auth.ui.Branding
import com.kenkoro.jetsurvey.auth.ui.SignInCreateAccount
import com.kenkoro.jetsurvey.ui.theme.JetSurveyTheme
import com.kenkoro.jetsurvey.util.supportWideScreen

@Composable
fun WelcomeScreen(
    onAuth: (email: String) -> Unit,
    onSignInAsGuest: () -> Unit
) {
    var showBranding by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .supportWideScreen()
            .fillMaxHeight()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(
                modifier = Modifier
                    .weight(1F, fill = showBranding)
                    .animateContentSize()
            )

            AnimatedVisibility(
                showBranding,
                Modifier.fillMaxWidth()
            ) {
                Branding()
            }

            Spacer(
                modifier = Modifier
                    .weight(1F, fill = showBranding)
                    .animateContentSize()
            )

            SignInCreateAccount(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                onAuth = onAuth,
                onSignInAsGuest = onSignInAsGuest,
                onFocusChange = { focused -> showBranding = !focused }
            )
        }
    }
}

@Preview(showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun WelcomeScreenPreview() {
    JetSurveyTheme {
        WelcomeScreen(
            onSignInAsGuest = {},
            onAuth = {}
        )
    }
}