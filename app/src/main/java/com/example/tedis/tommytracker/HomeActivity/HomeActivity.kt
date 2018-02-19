package com.example.tedis.tommytracker.HomeActivity

import android.app.AlertDialog
import android.app.TimePickerDialog
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.format.DateFormat
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.tedis.tommytracker.App
import com.example.tedis.tommytracker.HeaderFragment.HeaderFragment
import com.example.tedis.tommytracker.Needs.NeedModel
import com.example.tedis.tommytracker.Needs.NeedsContent
import com.example.tedis.tommytracker.Needs.NeedsFirebaseModel
import com.example.tedis.tommytracker.Needs.NeedsFragment
import com.example.tedis.tommytracker.R
import com.example.tedis.tommytracker.Utils.FEEDING_CODE
import com.example.tedis.tommytracker.Utils.POTTY_CODE
import com.example.tedis.tommytracker.Utils.SLEEP_CODE
import com.example.tedis.tommytracker.Utils.TimeConversion
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HomeActivityInterface, HeaderFragment.OnFragmentInteractionListener, NeedsFragment.OnListFragmentInteractionListener {



    override fun onListFragmentInteraction(item: NeedsContent.NeedsItem) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Inject lateinit var presenter: HomeActivityPresenter
    @Inject lateinit var firebaseModel: FirebaseModel

    override fun onCreate(savedInstanceState: Bundle?) {

        App.getAppComponent().inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        presenter.setView(this)
        presenter.setModel(firebaseModel)


        presenter.populateNeedsFromFirebase()

        home_fab_main.addOnMenuItemClickListener { miniFab, label, itemId ->
            when(itemId)
            {
                R.id.home_fab_potty ->createDialog(NeedModel(POTTY_CODE))
                R.id.home_fab_feeding ->createDialog(NeedModel(FEEDING_CODE))
                R.id.home_fab_sleeping ->createDialog(NeedModel(SLEEP_CODE))
            }
        }


    }

    private fun createDialog(needs:NeedModel)
    {
        val dialogView = layoutInflater.inflate(R.layout.fragment_dialog,null)

        val labelTime = dialogView.findViewById<View>(R.id.needs_dialog_txt_label_sTime) as TextView
        val labelExtra = dialogView.findViewById<View>(R.id.needs_dialog_txt_label_extra) as TextView
        val contentExtra = dialogView.findViewById<View>(R.id.needs_dialog_txt_content_extra) as EditText
        val contentTime = dialogView.findViewById<View>(R.id.needs_dialog_txt_content_sTime) as TextView
        val imageView = dialogView.findViewById<View>(R.id.dialog_imageView) as ImageView


        val addNeedsDialog = AlertDialog.Builder(this)
                .setView(dialogView)
                .setTitle("Add Event")


        labelTime.text = needs.labelTime
        labelExtra.text = needs.labelExtra

        if(labelExtra.text.equals(""))
            contentExtra.isEnabled = false

        imageView.setImageResource(needs.image)

        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

        contentTime.setOnClickListener { view ->
            val timePicker =  TimePickerDialog(this, TimePickerDialog.OnTimeSetListener(function =
            {
                timePicker, i, j ->
                c.set(c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DATE),timePicker.hour,timePicker.minute)
                contentTime.text = TimeConversion.getFormattedDate(c.timeInMillis)
            }

            ), hour, minute,
                    DateFormat.is24HourFormat(this))
            timePicker.show()
        }

        addNeedsDialog.setPositiveButton("ADD",
                {
                    dialogInterface, i ->
                        presenter.pushEventToFirebase(NeedsFirebaseModel(contentTime.text.toString(),contentExtra.text.toString(),needs.type))
                })
                .setNegativeButton("CANCEL",
                        {
                            dialogInterface, i ->
                            dialogInterface.cancel()
                        })

        val dialog = addNeedsDialog.create()
        dialog.show()

    }

    override fun populateNeedsList(need: NeedsFirebaseModel?) {
        val frag= fragment_needs as NeedsFragment
        frag.addNeedToList(NeedsContent.NeedsItem(need!!.type,need.stime,need.extra))
    }

    }

