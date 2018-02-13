package com.example.tedis.tommytracker.HomeActivity

import com.example.tedis.tommytracker.Needs.NeedsFirebaseModel
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser



/**
 * Created by Tedis on 2/11/2018.
 */
interface FirebaseModelInterface {

    fun checkLoginStatus(): Boolean
    fun getsignInWithEmailandPaswordResult(email: String, password: String): Task<AuthResult>
    fun getCurrentFirebaseUser(): FirebaseUser?
    fun signOut()
    fun getCurrentUsername(): String?
    fun addEvent(event:NeedsFirebaseModel)
}