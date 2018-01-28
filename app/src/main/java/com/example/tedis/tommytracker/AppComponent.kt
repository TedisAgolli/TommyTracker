package com.example.tedis.tommytracker

import com.example.tedis.tommytracker.HeaderFragment.HeaderFragment
import com.example.tedis.tommytracker.HomeActivity.HomeActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Tedis on 1/27/2018.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun inject(activity: HomeActivity): HomeActivity
    fun inject(fragmentHeader:HeaderFragment):HeaderFragment

}


