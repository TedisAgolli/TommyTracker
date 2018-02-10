package com.example.tedis.tommytracker.Needs

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.tedis.tommytracker.Needs.NeedsContent.NeedsItem
import com.example.tedis.tommytracker.Needs.NeedsFragment.OnListFragmentInteractionListener
import com.example.tedis.tommytracker.R
import kotlinx.android.synthetic.main.fragment_needs.view.*

/**
 * [RecyclerView.Adapter] that can display a [NeedsItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyNeedsRecyclerViewAdapter(private val mValues: List<NeedsItem>, private val mListener: OnListFragmentInteractionListener?) : RecyclerView.Adapter<MyNeedsRecyclerViewAdapter.ViewHolder>() {



    override fun getItemCount(): Int {
        return mValues.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_needs, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mItem = mValues[position]


        holder.needsView.setBackgroundResource(R.color.need_feeding)
        holder.imgView.setImageResource(R.drawable.potty)
        holder.txt_needs_label_sTime.text = "Start Time"
        holder.txt_needs_content_extra.text = "End Time"
        holder.txt_needs_content_sTime.text = mValues[position].sTime
        holder.txt_needs_content_extra.text = mValues[position].extraInfo


        holder.mView.setOnClickListener {
            mListener?.onListFragmentInteraction(holder.mItem!!)
        }
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val needsView = mView
        val imgView: ImageView
        val txt_needs_label_sTime: TextView
        val txt_needs_label_extra: TextView
        val txt_needs_content_sTime:TextView
        val txt_needs_content_extra:TextView



        var mItem: NeedsItem? = null


        init {
            imgView = mView.imageView
            txt_needs_label_sTime = mView.needs_txt_label_sTime
            txt_needs_label_extra = mView.needs_txt_label_sTime
            txt_needs_content_sTime = mView.needs_txt_content_sTime
            txt_needs_content_extra = mView.needs_txt_content_extra
        }

        override fun toString(): String {
            return super.toString() + " '" + txt_needs_label_extra.text + "'"
        }
    }
}
