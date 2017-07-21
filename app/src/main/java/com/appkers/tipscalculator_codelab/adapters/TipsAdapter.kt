package com.appkers.tipscalculator_codelab.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.appkers.tipscalculator_codelab.adapters.vh.TipsViewHolder
import com.appkers.tipscalculator_codelab.R

class TipsAdapter(context: Context) : RecyclerView.Adapter<TipsViewHolder>() {

    val layoutInflater = LayoutInflater.from(context)

    override fun getItemCount() = 1

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) : TipsViewHolder {
      return TipsViewHolder(layoutInflater.inflate(R.layout.tips_entry_item, parent, false))
    }

    override fun onBindViewHolder(holder: TipsViewHolder?, position: Int) {

    }
}