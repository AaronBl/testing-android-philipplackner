package com.fintecimal.testandroidphilipplackner

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class RegistrationUtilsTest {
    lateinit var registrationUtils:RegistrationUtils

    @Before
    fun initUtils(){
        registrationUtils = RegistrationUtils
    }


    @Test
    fun emptyUsername_returnFalse() {

        val result = registrationUtils.validateRegistrationInput("","123","1234")

        assertThat(result).isFalse()

    }
    @Test
    fun validUserNameAndCarrectlyReapeatPassword_retuenTrue() {

        val result = registrationUtils.validateRegistrationInput("Aaron","123","123")

        assertThat(result).isTrue()

    }

    @Test
    fun userNameAlreadyExists_returnFalse() {

        val result = registrationUtils.validateRegistrationInput("Carl","123","123")

        assertThat(result).isFalse()
    }

    @Test
    fun passwordIsEmpty_returnFalse() {

        val result = registrationUtils.validateRegistrationInput("Carl","","123")

        assertThat(result).isFalse()
    }

    @Test
    fun passwordConfirmIsIncorrectly_returnFalse() {

        val result = registrationUtils.validateRegistrationInput("Carl","123","1234")

        assertThat(result).isFalse()
    }

    @Test
    fun passwordContainLessDigits_returnFalse() {

        val result = registrationUtils.validateRegistrationInput("Carl","1234","123")

        assertThat(result).isFalse()
    }


}