package com.example.tedis.tommytracker.RegisterActivity

import com.example.tedis.tommytracker.AuthViewInterface
import com.example.tedis.tommytracker.HomeActivity.FirebaseModelInterface
import com.example.tedis.tommytracker.Presenter
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

/**
 * Created by Tedis on 1/28/2018.
 */
class RegisterActivityPresenter @Inject constructor(): Presenter<AuthViewInterface> {


    private val mAuth = FirebaseAuth.getInstance()
    private lateinit var registerView: AuthViewInterface
    private lateinit var firebaseModel:FirebaseModelInterface

    override fun setView(view: AuthViewInterface) {
        this.registerView = view
    }

    override fun setModel(model: FirebaseModelInterface) {
        this.firebaseModel =firebaseModel
    }


    fun attemptRegister(email:String, password:String)
    {
        try {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->

                        if (task.isSuccessful) {
                            registerView.onAuthSuccess()
                        } else {
                            registerView.onAuthFail()
                        }

                    }

            Thread.sleep(2000)
        }
        catch (e:InterruptedException)
        {
            //TODO Handle exception
        }
    }


}