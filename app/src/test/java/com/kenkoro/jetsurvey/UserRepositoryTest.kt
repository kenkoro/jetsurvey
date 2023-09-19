package com.kenkoro.jetsurvey

import com.google.common.truth.Truth.assertThat
import com.kenkoro.jetsurvey.auth.User
import com.kenkoro.jetsurvey.auth.UserRepository
import org.junit.Test

class UserRepositoryTest {
    private val email = "user@user.com"

    @Test
    fun `should sign in the user`() {
        UserRepository.signIn(email, "user")

        assertThat(UserRepository.user).isEqualTo(User.LoggedInUser(email))
    }

    @Test
    fun `should sign up the user`() {
        UserRepository.signUp(email, "user")

        assertThat(UserRepository.user).isEqualTo(User.LoggedInUser(email))
    }

    @Test
    fun `should sign in as a guest`() {
        UserRepository.signInAsGuest()

        assertThat(UserRepository.user).isEqualTo(User.GuestUser)
    }

    /**
     * NOTE: The keyword = sign up
     */
    @Test
    fun `should be unknown when the email contains the keyword`() {
        val email = "signup@gmail.com"

        val result = UserRepository.isKnownUserEmail(email)

        assertThat(result).isFalse()
    }

    @Test
    fun `should be known when the email does not contain the keyword`() {
        val email = "user@gmail.com"

        val result = UserRepository.isKnownUserEmail(email)

        assertThat(result).isTrue()
    }
}