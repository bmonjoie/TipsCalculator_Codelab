package com.appkers.tipscalculator_codelab.adapters

import android.content.Context
import android.widget.ArrayAdapter

class PercentAdapter(context: Context) : ArrayAdapter<String>(context, android.R.layout.simple_list_item_1) {

    override fun getCount() = 100

    override fun getItem(position: Int) = "${position + 1}%"
}