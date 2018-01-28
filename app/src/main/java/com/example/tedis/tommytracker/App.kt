package com.example.tedis.tommytracker

import android.app.Application

/**
 * Created by Tedis on 1/27/2018.
 */
object App : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

    fun getAppComponent():AppComponent
    {
       return component

    }
}

