package com.example.tedis.tommytracker.HeaderFragment

import com.example.tedis.tommytracker.HomeActivity.FirebaseModelInterface
import com.example.tedis.tommytracker.Presenter
import javax.inject.Inject

/**
 * Created by Tedis on 1/27/2018.
 */
class HeaderPresenter @Inject constructor(): Presenter<HeaderView>{


    private lateinit var headerView: HeaderView
    private lateinit var firebaseModel:FirebaseModelInterface

    override fun setView(view: HeaderView) {
        this.headerView = view

    }

    override fun setModel(model: FirebaseModelInterface) {
        this.firebaseModel = firebaseModel
    }


    fun populateFields()
    {
        headerView.setAge("9 m")
        headerView.setHeight("70 cm")
        headerView.setWeight("9 kg")
    }
}