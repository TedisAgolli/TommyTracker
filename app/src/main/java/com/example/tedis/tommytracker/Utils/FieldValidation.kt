package com.example.tedis.tommytracker.Utils

/**
 * Created by Tedis on 1/28/2018.
 */
object FieldValidation  {


    fun isEmailValid(email: String): Boolean {
        return email.matches(EMAIL_REGEX.toRegex())
    }

    fun isPasswordValid(password: String): Boolean {
        return password.length > 7
    }


}