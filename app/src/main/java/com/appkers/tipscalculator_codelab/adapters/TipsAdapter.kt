package com.appkers.tipscalculator_codelab.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.appkers.tipscalculator_codelab.R
import com.appkers.tipscalculator_codelab.adapters.vh.TipsViewHolder
import com.appkers.tipscalculator_codelab.entities.TipsEntry
import java.util.*

class TipsAdapter(context: Context) : RecyclerView.Adapter<TipsViewHolder>() {

    val layoutInflater = LayoutInflater.from(context)

    val list = ArrayList<TipsEntry>()

    override fun getItemCount() = list.size + 1

    override fun onCreateViewHolder(parent: ViewGroup?, type: Int) : TipsViewHolder {
        return TipsViewHolder(layoutInflater.inflate(R.layout.tips_entry_item, parent, false), this)
    }

    override fun onBindViewHolder(holder: TipsViewHolder, position: Int) {
        holder.bind(if (position < list.size) list[position] else TipsEntry())
    }

    fun setAmountFor(entry: TipsEntry, position: Int) {
        if (position < list.size) {
            list.removeAt(position)
        } else {
            notifyItemInserted(position + 1)
        }
        list.add(position, entry)
        notifyItemChanged(itemCount - 1)
    }

    fun removeAmountAt(adapterPosition: Int) {
        if (adapterPosition < list.size) {
            list.removeAt(adapterPosition)
            notifyItemRemoved(adapterPosition)
            notifyItemChanged(itemCount - 1)
        }
    }
}