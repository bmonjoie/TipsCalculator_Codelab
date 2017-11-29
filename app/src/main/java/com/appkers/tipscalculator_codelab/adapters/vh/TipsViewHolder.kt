package com.appkers.tipscalculator_codelab.adapters.vh

import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import com.appkers.tipscalculator_codelab.adapters.PercentAdapter
import com.appkers.tipscalculator_codelab.R
import com.appkers.tipscalculator_codelab.adapters.TipsAdapter
import com.appkers.tipscalculator_codelab.common.empties.DefaultOnItemSelectedListener
import com.appkers.tipscalculator_codelab.common.empties.DefaultTextWatcher
import com.appkers.tipscalculator_codelab.entities.TipsEntry

class TipsViewHolder(itemView: View, val adapter: TipsAdapter) : RecyclerView.ViewHolder(itemView), AdapterView.OnItemSelectedListener by DefaultOnItemSelectedListener(), TextWatcher by DefaultTextWatcher() {

    val etAmount: EditText = itemView.findViewById<EditText>(R.id.etAmount)
    val tvTips: TextView = itemView.findViewById<TextView>(R.id.tvTips)
    val spPercent: Spinner = itemView.findViewById<Spinner>(R.id.spPercent)

    init {
        etAmount.addTextChangedListener(this)
        spPercent.adapter = PercentAdapter(itemView.context)
        spPercent.onItemSelectedListener = this
    }

    private lateinit var entry: TipsEntry

    fun bind(entry: TipsEntry) {
        this.entry = entry
        spPercent.setSelection(entry.percent - 1)
        etAmount.setText((if (entry.amount > 0) {
            entry.amount.toString()
        } else {
            ""
        }))
        setTips()
    }

    private fun setTips() {
        tvTips.text = if (entry.amount > 0) String.format("%.2f", entry.tips) else ""
    }

    override fun afterTextChanged(s: Editable?) {
        if (s != null && !s.isEmpty()) {
            entry.amount = s.toString().toFloat()
            adapter.setAmountFor(entry, adapterPosition)
            setTips()
        } else {
            adapter.removeAmountAt(adapterPosition)
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        entry.percent = position + 1
        setTips()
    }
}