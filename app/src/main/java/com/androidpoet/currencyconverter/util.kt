package com.androidpoet.currencyconverter

import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*


fun String.removeThirdSpace(): String {
    val tempArray: List<String> = this.split(" ","-")

    return if (tempArray.size >=2) {
        tempArray[0] + " " + tempArray[1]
    } else {
        this
    }


}

fun BigDecimal.roundofDecimal(): Double {
    val df = DecimalFormat("#.#", DecimalFormatSymbols(Locale.ENGLISH))

    return df.format(this).toDouble()
}

