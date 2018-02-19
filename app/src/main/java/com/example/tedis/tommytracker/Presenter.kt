package com.example.tedis.tommytracker

import com.example.tedis.tommytracker.HomeActivity.FirebaseModelInterface

/**
 * Created by Tedis on 1/27/2018.
 */
interface Presenter<T> {
    fun setView(view:T)
    fun setModel(model:FirebaseModelInterface)
}
