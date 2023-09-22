package com.kenkoro.jetsurvey.auth.route

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kenkoro.jetsurvey.auth.SignUpViewModel
import com.kenkoro.jetsurvey.auth.SignUpViewModelFactory
import com.kenkoro.jetsurvey.auth.screen.SignUpScreen

@Composable
fun SignUpRoute(
    email: String?,
    onSignUpSubmitted: () -> Unit,
    onSignInAsGuest: () -> Unit,
    onNavUp: () -> Unit
) {
    val signUpViewModel: SignUpViewModel = viewModel(factory = SignUpViewModelFactory())

    SignUpScreen(
        email = email,
        onSignUpSubmitted = { mail, password ->
            signUpViewModel.signUp(mail, password, onSignUpSubmitted)
        },
        onSignInAsGuest = {
            signUpViewModel.signInAsGuest(onSignInAsGuest)
        },
        onNavUp = onNavUp
    )
}