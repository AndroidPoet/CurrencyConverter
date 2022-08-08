package com.androidpoet.currencyconverter

import com.androidpoet.data.network.CurrencyAPI
import com.androidpoet.data.network.models.NetLatestRates


class FakeCurrencyAPI : CurrencyAPI {
    override suspend fun networkFetchCurrencies(): Map<String, String> {
        return hashMapOf<String, String>().apply {
            put("INR", "Indian Rupee")
            put("XYZ", "XYZ currency")
        }
    }

    override suspend fun networkFetchLatestRates(): NetLatestRates {
        return NetLatestRates(
            timestamp = System.currentTimeMillis() / 1000,
            rates = hashMapOf<String, Double>().apply {
                put("INR", 75.0)
                put("XYZ", 100.0)
            })

    }

}
