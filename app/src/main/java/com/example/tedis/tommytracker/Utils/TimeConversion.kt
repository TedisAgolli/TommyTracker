package com.example.tedis.tommytracker.Utils

import android.text.format.DateFormat

/**
 * Created by Tedis on 2/11/2018.
 */
object TimeConversion {

    fun getFormattedDate(timestamp: Long): String {
        return DateFormat.format("hh:mm:ss a", timestamp).toString()
    }
}