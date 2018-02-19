package com.example.tedis.tommytracker.HomeActivity

import android.util.Log
import com.example.tedis.tommytracker.Needs.NeedsFirebaseModel
import com.example.tedis.tommytracker.Presenter
import com.google.firebase.database.DataSnapshot
import javax.inject.Inject

/**
 * Created by Tedis on 1/27/2018.
 */
class HomeActivityPresenter @Inject constructor():Presenter<HomeActivityInterface>{

    lateinit var homeView:HomeActivityInterface
    lateinit var firebaseModel:FirebaseModelInterface

    override fun setView(view: HomeActivityInterface) {
        homeView =  view
    }

    override fun setModel(model: FirebaseModelInterface) {
        firebaseModel = model
    }

    fun pushEventToFirebase(event:NeedsFirebaseModel)
    {
        firebaseModel.addEvent(event)
        homeView.populateNeedsList(event)
    }

    fun populateNeedsFromFirebase()
    {
        firebaseModel.getFirebaseNeeds().subscribe(
                {
                    t:DataSnapshot ->
                    kotlin.run {

                        t.children.forEach {
                            homeView.populateNeedsList(it.getValue(NeedsFirebaseModel::class.java))
                        }

                    }

                },
                {
                    t: Throwable? -> Log.d("HomePresenter",t?.message)
                }
        )
    }


}