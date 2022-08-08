package com.androidpoet.data.repo

import com.androidpoet.data.network.CurrencyAPI
import com.androidpoet.data.network.models.NetCurrency
import com.androidpoet.domain.CurrenciesLocalSource
import com.androidpoet.domain.CurrenciesRepository
import com.androidpoet.domain.models.DMCurrency
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class CurrenciesRepositoryImpl @Inject constructor(
    private val coroutineContext: CoroutineContext,
    private val currencyAPI: CurrencyAPI,
    private val currenciesLocalSource: CurrenciesLocalSource
) : CurrenciesRepository {

    override suspend fun preloadCurrencies() {
        withContext(coroutineContext) {
            if (currenciesLocalSource.canFetchCurrencies()) {
                val currencies = networkFetchCurrencies()
                currenciesLocalSource.saveCurrenciesLocally(currencies)
            }
        }
    }

    private suspend fun networkFetchCurrencies(): NetCurrency {
        return currencyAPI.networkFetchCurrencies()
    }

    override fun fetchCurrencies(
        searchKey: String?
    ): Flow<List<DMCurrency>> {
        return currenciesLocalSource.fetchLocalCurrencies(searchKey)
    }
}