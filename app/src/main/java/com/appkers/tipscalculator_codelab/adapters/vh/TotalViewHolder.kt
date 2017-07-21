package com.appkers.tipscalculator_codelab.adapters.vh

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.appkers.tipscalculator_codelab.R

class TotalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val tvTotal = itemView.findViewById<TextView>(R.id.tvTotal)

    fun bind(total: Double) {
        tvTotal.text = "%.2f".format(total)
    }
}