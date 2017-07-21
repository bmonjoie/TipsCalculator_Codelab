package com.appkers.tipscalculator_codelab.entities

data class TipsEntry(var amount: Float = 0F, var percent : Int = 18) {

    val tips : Float
        get() = amount / 100 * percent
    val total : Float
        get() = amount + tips

}