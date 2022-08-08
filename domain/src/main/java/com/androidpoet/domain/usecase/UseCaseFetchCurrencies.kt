package com.androidpoet.domain.usecase

import com.androidpoet.domain.CurrenciesRepository
import com.androidpoet.domain.models.DMCurrency
import kotlinx.coroutines.flow.Flow

class UseCaseFetchCurrencies(private val currenciesRepository: CurrenciesRepository) {
    fun perform(value: String): Flow<List<DMCurrency>> {
        return currenciesRepository.fetchCurrencies(value)
    }
}