package com.kenkoro.jetsurvey.auth.route

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kenkoro.jetsurvey.auth.SignInViewModel
import com.kenkoro.jetsurvey.auth.SignInViewModelFactory
import com.kenkoro.jetsurvey.auth.screen.SignInScreen

@Composable
fun SignInRoute(
    email: String?,
    onSignInSubmitted: () -> Unit,
    onSignAsGuest: () -> Unit,
    onNavUp: () -> Unit
) {
    val signInViewModel: SignInViewModel = viewModel(factory = SignInViewModelFactory())

    SignInScreen(
        email = email,
        onSignInSubmitted = { mail, password ->
            signInViewModel.signIn(mail, password, onSignInSubmitted)
        },
        onSignInAsGuest = {
            signInViewModel.signInAsGuest(onSignAsGuest)
        },
        onNavUp = onNavUp
    )
}