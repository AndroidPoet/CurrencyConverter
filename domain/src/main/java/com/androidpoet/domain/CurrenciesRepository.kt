package com.androidpoet.domain

import com.androidpoet.domain.models.DMCurrency
import kotlinx.coroutines.flow.Flow

interface CurrenciesRepository {
    fun fetchCurrencies(searchKey: String?): Flow<List<DMCurrency>>
    suspend fun preloadCurrencies()
}