package com.example.tedis.tommytracker.LoginActivity

import android.util.Log
import com.example.tedis.tommytracker.Presenter
import javax.inject.Inject

/**
 * Created by Tedis on 1/27/2018.
 */
class LoginActivityPresenter @Inject constructor(): Presenter<LoginActivityView>{

    private lateinit var loginActivityView:LoginActivityView

    override fun setView(view: LoginActivityView) {
        this.loginActivityView = view
    }

    fun attemptLogin(email:String,password:String)
    {
        Log.d("LoginActivityPresenter","attemptLogin")
    }
}