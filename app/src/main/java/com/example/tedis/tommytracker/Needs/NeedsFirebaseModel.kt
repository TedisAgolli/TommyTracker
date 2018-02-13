package com.example.tedis.tommytracker.Needs

import android.os.Parcel
import android.os.Parcelable



/**
 * Created by Tedis on 2/12/2018.
 */
class NeedsFirebaseModel : Parcelable {

    lateinit var stime: String
    lateinit var extra: String
    var type: Int= 0


    constructor() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    constructor(sTime: String, extra: String, type: Int) {
        this.stime = sTime
        this.extra = extra
        this.type = type
    }


    protected constructor(`in`: Parcel) {
        stime = `in`.readString()
        extra = `in`.readString()
        type = `in`.readInt()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(stime)
        dest.writeString(extra)
        dest.writeInt(type)
    }

    companion object {

        val CREATOR: Parcelable.Creator<NeedsFirebaseModel> = object : Parcelable.Creator<NeedsFirebaseModel> {
            override fun createFromParcel(`in`: Parcel): NeedsFirebaseModel {
                return NeedsFirebaseModel(`in`)
            }

            override fun newArray(size: Int): Array<NeedsFirebaseModel?> {
                return arrayOfNulls(size)
            }
        }
    }
}