package com.example.tedis.tommytracker.HomeActivity

import android.app.AlertDialog
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.EditText
import com.example.tedis.tommytracker.App
import com.example.tedis.tommytracker.HeaderFragment.HeaderFragment
import com.example.tedis.tommytracker.Needs.NeedsContent
import com.example.tedis.tommytracker.Needs.NeedsFragment
import com.example.tedis.tommytracker.R
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HeaderFragment.OnFragmentInteractionListener, NeedsFragment.OnListFragmentInteractionListener {


    override fun onListFragmentInteraction(item: NeedsContent.NeedsItem) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    @Inject lateinit var presenter: HomeActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {

        App.getAppComponent().inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        presenter.test()

        home_fab_main.setOnClickListener {view ->

            val dialogView = layoutInflater.inflate(R.layout.fragment_dialog,null)
            val contentExtra = dialogView.findViewById<View>(R.id.needs_txt_content_extra) as EditText
            val contentTime = dialogView.findViewById<View>(R.id.needs_txt_content_sTime) as EditText

           val addNeedsDialog = AlertDialog.Builder(this)
                   .setView(dialogView)
                   .setTitle("Add Event")


                   addNeedsDialog.setPositiveButton("ADD",
                    {
                        dialogInterface, i ->

                            Log.d("DIALOG","ADD: " + contentTime.text )


                    })
            .setNegativeButton("CANCEL",
                    {
                        dialogInterface, i ->
                        dialogInterface.cancel()
                    })

            val dialog = addNeedsDialog.create()
            dialog.show()



        }
    }



}
