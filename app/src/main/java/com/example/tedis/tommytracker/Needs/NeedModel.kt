package com.example.tedis.tommytracker.Needs

import com.example.tedis.tommytracker.R
import com.example.tedis.tommytracker.Utils.FEEDING_CODE
import com.example.tedis.tommytracker.Utils.POTTY_CODE
import com.example.tedis.tommytracker.Utils.SLEEP_CODE

/**
 * Created by Tedis on 2/10/2018.
 */
class NeedModel (type:Int){

    var labelTime = "Time"
    lateinit var labelExtra:String
    var image:Int = 0
    val type:Int

    init {
        this.type = type
        when(type)
        {
            FEEDING_CODE ->
            {
                labelExtra = "Item"
                image = R.drawable.feeding
            }

            POTTY_CODE ->
            {
                labelExtra = ""
                image = R.drawable.potty
            }

            SLEEP_CODE ->
            {
                labelTime="From"
                labelExtra = "To"
                image = R.drawable.sleep
            }
        }
    }
}