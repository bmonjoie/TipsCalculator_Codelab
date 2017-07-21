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
import com.appkers.tipscalculator_codelab.entities.TipsEntry

class TipsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), AdapterView.OnItemSelectedListener, TextWatcher {

    val etAmount: EditText = itemView.findViewById<EditText>(R.id.etAmount)
    val tvTips: TextView = itemView.findViewById<TextView>(R.id.tvTips)
    val spPercent: Spinner = itemView.findViewById<Spinner>(R.id.spPercent)

    init {
        spPercent.adapter = PercentAdapter(itemView.context)
        spPercent.onItemSelectedListener = this
        etAmount.addTextChangedListener(this)
    }

    override fun afterTextChanged(p0: Editable?) {
        setTips()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        setTips()
    }

    private fun setTips() {
        if  (etAmount.text.toString().isNotEmpty()) {
            val percent = spPercent.selectedItemPosition + 1
            val amount = etAmount.text.toString().toFloat()
            tvTips.text = TipsEntry(amount, percent).tips.toString()
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }
}