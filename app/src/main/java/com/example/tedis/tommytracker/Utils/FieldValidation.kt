package com.example.tedis.tommytracker.Utils

import javax.inject.Inject

/**
 * Created by Tedis on 1/28/2018.
 */
class FieldValidation @Inject constructor()  {





    fun isEmailValid(email: String): Boolean {
        return email.matches(EMAIL_REGEX.toRegex())
    }

    fun isPasswordValid(password: String): Boolean {
        return password.length > 7
    }


}