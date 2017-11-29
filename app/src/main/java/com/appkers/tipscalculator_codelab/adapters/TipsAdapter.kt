package com.appkers.tipscalculator_codelab.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.appkers.tipscalculator_codelab.R
import com.appkers.tipscalculator_codelab.adapters.vh.TipsViewHolder
import com.appkers.tipscalculator_codelab.adapters.vh.TotalViewHolder
import com.appkers.tipscalculator_codelab.entities.TipsEntry
import java.util.*

class TipsAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val layoutInflater = LayoutInflater.from(context)

    val list = ArrayList<TipsEntry>()

    override fun getItemCount() = list.size + 2

    override fun onCreateViewHolder(parent: ViewGroup?, type: Int) = when (type) {
        R.layout.tips_entry_item -> TipsViewHolder(layoutInflater.inflate(type, parent, false), this)
        else -> TotalViewHolder(layoutInflater.inflate(type, parent, false))
    }

    override fun getItemViewType(position: Int) = when (position) {
        list.size + 1 -> R.layout.tips_total_item
        else -> R.layout.tips_entry_item
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) = when (holder) {
        is TipsViewHolder -> holder.bind(if (position < list.size) list[position] else TipsEntry())
        is TotalViewHolder -> holder.bind(getTotal())
        else -> throw IllegalArgumentException("Unknown holder type")
    }

    fun getTotal() = list.sumByDouble { it.total.toDouble() }

    fun setAmountFor(entry: TipsEntry, position: Int) {
        if (position >= list.size) {
            list.add(position, entry)
            notifyItemInserted(position + 1)
        }
    }

    fun removeAmountAt(adapterPosition: Int) {
        if (adapterPosition < list.size) {
            list.removeAt(adapterPosition)
            notifyItemRemoved(adapterPosition)
        }
    }
}