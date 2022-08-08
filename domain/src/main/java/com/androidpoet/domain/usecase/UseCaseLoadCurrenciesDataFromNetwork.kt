package com.androidpoet.domain.usecase

import com.androidpoet.domain.CurrenciesRepository

class UseCaseLoadCurrenciesDataFromNetwork(
    private val currencyRepository: CurrenciesRepository
) {
    suspend fun perform() {
        currencyRepository.preloadCurrencies()
    }
}