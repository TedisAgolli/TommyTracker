package com.example.tedis.tommytracker.LoginActivity

import com.example.tedis.tommytracker.AuthViewInterface
import com.example.tedis.tommytracker.HomeActivity.FirebaseModelInterface
import com.example.tedis.tommytracker.Presenter
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject


/**
 * Created by Tedis on 1/27/2018.
 */
class LoginActivityPresenter @Inject constructor(): Presenter<AuthViewInterface>{

    private val mAuth = FirebaseAuth.getInstance()
    private lateinit var loginView: AuthViewInterface
    private lateinit var firebaseModel:FirebaseModelInterface
    override fun setView(view: AuthViewInterface) {
        this.loginView = view
    }

    override fun setModel(firebaseModel:FirebaseModelInterface)
    {
        this.firebaseModel =firebaseModel
    }
    fun checkIfLoggedIn()
    {
        if(mAuth.currentUser != null)
            loginView.onAuthSuccess()
    }
    fun attemptLogin(email:String,password:String)
    {
        try {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            mAuth.currentUser?.reload()
                            loginView.onAuthSuccess()
                        }
                        else
                        {
                            loginView.onAuthFail()
                        }
                    }
            // Simulate network access.
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            //TODO Handle exception
        }

    }
}