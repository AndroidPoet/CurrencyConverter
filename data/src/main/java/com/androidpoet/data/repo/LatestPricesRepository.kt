package com.androidpoet.data.repo

import com.androidpoet.data.network.CurrencyAPI
import com.androidpoet.domain.CurrenciesLocalSource
import com.androidpoet.domain.LatestPricesRepository
import com.androidpoet.domain.models.DMLatestRate
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class LatestPricesRepositoryImpl @Inject constructor(
    private val coroutineContext: CoroutineContext,
    private val currencyAPI: CurrencyAPI,
    private val currenciesLocalSource: CurrenciesLocalSource
) : LatestPricesRepository {

    override fun fetchRates(searchKey: String?, input: Double): Flow<List<DMLatestRate>> {
        return currenciesLocalSource.fetchLocalRates(searchKey, input)
    }

    override suspend fun preloadLatestRates(): Date {
        return withContext(coroutineContext) {
            if (currenciesLocalSource.canFetchLatestRates()) {
                val rates = currencyAPI.networkFetchLatestRates()
                currenciesLocalSource.saveLatestRates(rates.rates)
                currenciesLocalSource.latestRatesFetchLastTime()!!
            } else {
                currenciesLocalSource.latestRatesFetchLastTime()!!
                // ð this will never be null if currenciesLocalSource.canFetchLatestRates() is tru
            }
        }
    }

}