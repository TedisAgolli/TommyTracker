package com.example.tedis.tommytracker.RegisterActivity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import com.example.tedis.tommytracker.App
import com.example.tedis.tommytracker.R
import com.example.tedis.tommytracker.Utils.ERROR_FIELD_REQUIRED
import com.example.tedis.tommytracker.Utils.ERROR_INVALID_EMAIL
import com.example.tedis.tommytracker.Utils.ERROR_INVALID_PASSWORD
import com.example.tedis.tommytracker.Utils.FieldValidation
import dagger.Module
import kotlinx.android.synthetic.main.activity_register.*
import javax.inject.Inject

@Module
class RegisterActivity : AppCompatActivity() {

    @Inject lateinit var registerPresenter:RegisterActivityPresenter
    @Inject lateinit var validation:FieldValidation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        App.getAppComponent().inject(this)

        btnRegister.setOnClickListener{

            val email = register_txt_email.text.toString()
            val password = register_txt_password.text.toString()

            if(validateEmailandPassword(email,password))
            {
                registerPresenter.attemptRegister(email,password)
            }

        }

    }


    /*Register activity should have more fields than register in the future

    */
    private fun validateEmailandPassword(email:String,password: String):Boolean
    {
        var cancel = false

        // Check for a valid password, if the user entered one.
        if(TextUtils.isEmpty(password))
        {
            register_txt_password.error= ERROR_FIELD_REQUIRED
            register_txt_password.requestFocus()
            cancel=true
        } else if (!validation.isPasswordValid(password)) {
            register_txt_password.error= ERROR_INVALID_PASSWORD
            register_txt_password.requestFocus()
            cancel = true
        }
        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {

            register_txt_email.error = ERROR_FIELD_REQUIRED
            register_txt_email.requestFocus()

            cancel = true
        } else if (!validation.isEmailValid(email)) {
            register_txt_email.error = ERROR_INVALID_EMAIL
            register_txt_email.requestFocus()
            cancel = true
        }
        if (!cancel) {
            Log.d("tag", "new userlogin")
            return true
        }
        return false
    }




}
