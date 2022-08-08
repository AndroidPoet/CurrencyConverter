package com.androidpoet.domain.models

data class DMCurrency(val currency: String, val name: String, val symbol: String)
data class DMLatestRate(val currency: String, val rate: Double, val name: String) {
    fun calculatedRate(input: Double) = rate.times(input)
}