package com.kenkoro.jetsurvey.auth

import java.util.regex.Pattern

/**
 * Consider an email valid if there's some text before and after a "@"
 */
private const val EMAIL_VALIDATION_REGEX = "^(.+)@(.+)\$"

class EmailState(private val email: String? = null) :
    TextFieldState(
        validator = ::isEmailValid,
        errorFor = ::emailValidationError
    ) {
    init {
        email?.let {
            text = it
        }
    }
}

private fun emailValidationError(email: String): String {
    val errorTag = "Invalid email:"
    return if (email.isBlank()) "$errorTag empty" else "$errorTag $email"
}

private fun isEmailValid(email: String): Boolean {
    return Pattern.matches(EMAIL_VALIDATION_REGEX, email)
}

val EmailStateSaver = textFieldStateSaver(EmailState())