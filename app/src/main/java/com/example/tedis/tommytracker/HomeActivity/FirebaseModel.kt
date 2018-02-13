package com.example.tedis.tommytracker.HomeActivity

import com.example.tedis.tommytracker.Needs.NeedsFirebaseModel
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject

/**
 * Created by Tedis on 2/11/2018.
 */
class FirebaseModel @Inject constructor():FirebaseModelInterface {



    var firebaseAuth:FirebaseAuth
    var fireaseDatabase:FirebaseDatabase
    init {
         firebaseAuth = FirebaseAuth.getInstance()
         fireaseDatabase = FirebaseDatabase.getInstance()
    }

    override fun getsignInWithEmailandPaswordResult(email: String, password: String): Task<AuthResult> {
        return firebaseAuth.signInWithEmailAndPassword(email,password)
    }

    override fun getCurrentFirebaseUser(): FirebaseUser? {
        return firebaseAuth.currentUser
    }

    override fun signOut() {
        firebaseAuth.signOut()
    }

    override fun getCurrentUsername(): String? {
        return firebaseAuth.currentUser?.displayName
    }

    override fun checkLoginStatus(): Boolean {
        return (firebaseAuth.currentUser != null)
    }

    override fun addEvent(event: NeedsFirebaseModel) {
        fireaseDatabase.reference.child(getCurrentFirebaseUser()?.uid + "/Thomas/Needs" ).push().setValue(event)

    }
}