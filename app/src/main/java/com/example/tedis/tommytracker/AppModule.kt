package com.example.tedis.tommytracker

import dagger.Module

/**
 * Created by Tedis on 1/27/2018.
 */

@Module
class AppModule (app:App){

    private var app:App

    init {
        this.app = app
    }

}

