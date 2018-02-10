package com.example.tedis.tommytracker.LoginActivity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.example.tedis.tommytracker.App
import com.example.tedis.tommytracker.AuthViewInterface
import com.example.tedis.tommytracker.HomeActivity.HomeActivity
import com.example.tedis.tommytracker.R
import com.example.tedis.tommytracker.RegisterActivity.RegisterActivity
import com.example.tedis.tommytracker.Utils.*
import dagger.Module
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject


@Module
class LoginActivity : AppCompatActivity(), AuthViewInterface {

    @Inject lateinit var loginPresenter:LoginActivityPresenter
    @Inject lateinit var validation: FieldValidation


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        App.getAppComponent().inject(this)

        loginPresenter.setView(this)
        loginPresenter.checkIfLoggedIn()



        btnLogin.setOnClickListener {

            login_txt_email.error = null
            login_txt_password.error = null

            // Store values at the time of the login attempt.
            val email = login_txt_email.text.toString()
            val password = login_txt_password.text.toString()

            if(validateEmailandPassword(email,password))
                loginPresenter.attemptLogin(email, password)
        }

        btngoToRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }


    override fun onAuthSuccess() {
        val intent = Intent(this,HomeActivity::class.java)
        startActivity(intent)
    }

    override fun onAuthFail() {
        Toast.makeText(this, ERROR_LOGIN_FAIL,
                Toast.LENGTH_SHORT).show()
    }



    private fun validateEmailandPassword(email:String,password: String):Boolean
    {
        var cancel = false

        // Check for a valid password, if the user entered one.
        if(TextUtils.isEmpty(password))
        {
            login_txt_password.error= ERROR_FIELD_REQUIRED
            login_txt_password.requestFocus()
            cancel=true
        } else if (!validation.isPasswordValid(password)) {
            login_txt_password.error= ERROR_INVALID_PASSWORD
            login_txt_password.requestFocus()
            cancel = true
        }
        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {

            login_txt_email.error = ERROR_FIELD_REQUIRED
            login_txt_email.requestFocus()

            cancel = true
        } else if (!validation.isEmailValid(email)) {
            login_txt_email.error = ERROR_INVALID_EMAIL
            login_txt_email.requestFocus()
            cancel = true
        }
        if (!cancel) {
            Log.d("tag", "new userlogin")
            return true
        }
        return false
    }
}
