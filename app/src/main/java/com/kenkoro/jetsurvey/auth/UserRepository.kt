package com.kenkoro.jetsurvey.auth

import androidx.compose.runtime.Immutable

sealed class User {
    @Immutable
    data class LoggedInUser(val email: String) : User()
    object GuestUser : User()
    object NoUserLoggedIn : User()
}

/**
 * Repository that holds the logged in user.
 *
 * In a production code, this class would also handle the communication with the backend for sign
 * in and sign up.
 */
object UserRepository {
    private var _user: User = User.NoUserLoggedIn
    val user: User
        get() = _user

    @Suppress("UNUSED_PARAMETER")
    fun signIn(email: String, password: String) {
        _user = User.LoggedInUser(email)
    }

    @Suppress("UNUSED_PARAMETER")
    fun signUp(email: String, password: String) {
        _user = User.LoggedInUser(email)
    }

    fun signInAsGuest() {
        _user = User.GuestUser
    }

    /**
     * If the email contains "sign up" we consider it unknown.
     */
    fun isKnownUserEmail(email: String): Boolean {
        return !email.contains("signup")
    }
}