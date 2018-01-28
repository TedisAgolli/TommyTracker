package com.example.tedis.tommytracker.HomeActivity

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.tedis.tommytracker.App
import com.example.tedis.tommytracker.HeaderFragment.HeaderFragment
import com.example.tedis.tommytracker.R
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HeaderFragment.OnFragmentInteractionListener {


    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    @Inject lateinit var presenter: HomeActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {

        App.getAppComponent().inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.test()

    }



}
