package com.androidpoet.data.network

import com.androidpoet.data.network.models.NetCurrency
import com.androidpoet.data.network.models.NetLatestRates


interface CurrencyAPI {
    suspend fun networkFetchCurrencies(): NetCurrency
    suspend fun networkFetchLatestRates(): NetLatestRates
}