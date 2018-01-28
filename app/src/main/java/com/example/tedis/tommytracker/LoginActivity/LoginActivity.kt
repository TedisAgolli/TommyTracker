package com.example.tedis.tommytracker.LoginActivity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.tedis.tommytracker.HomeActivity.HomeActivity
import com.example.tedis.tommytracker.R
import com.example.tedis.tommytracker.Utils.EMAIL_REGEX
import com.example.tedis.tommytracker.Utils.ERROR_LOGIN_FAIL
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject


class LoginActivity : AppCompatActivity(), LoginActivityView {


    @Inject lateinit var presenter:LoginActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            validateFieldsforLogin()
        }
    }


    fun validateFieldsforLogin() {

        // Reset errors.
        
        login_txt_email.setError(null)
        login_txt_password.setError(null)
        

        // Store values at the time of the login attempt.
        val email = login_txt_email.getText().toString()
        val password = login_txt_password.getText().toString()

        var cancel = false
        var focusView: View? = null

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            login_txt_password.setError(getString(R.string.error_invalid_password))
            focusView = login_txt_password
            cancel = true
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            login_txt_email.setError(getString(R.string.error_field_required))
            focusView = login_txt_email
            cancel = true
        } else if (!isEmailValid(email)) {
            login_txt_email.setError(getString(R.string.error_invalid_email))
            focusView = login_txt_email
            cancel = true
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView!!.requestFocus()
        } else {

            Log.d("tag", "new userlogin")
            presenter.attemptLogin(email, password)

        }
    }

    private fun isEmailValid(email: String): Boolean {
        return email.matches(EMAIL_REGEX.toRegex())
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length > 7
    }

    override fun onLoginSuccess() {
        val intent = Intent(this,HomeActivity::class.java)
        startActivity(intent)

    }

    override fun onLoginFail() {
        Toast.makeText(this, ERROR_LOGIN_FAIL,
                Toast.LENGTH_SHORT).show()
    }
}
