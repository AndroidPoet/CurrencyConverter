package com.androidpoet.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import com.androidpoet.data.local.entities.LocalCurrency
import com.androidpoet.domain.CurrenciesLocalSource
import com.androidpoet.domain.CurrencyConverter
import com.androidpoet.domain.CurrencyConverter.CURRENCIES_KEY
import com.androidpoet.domain.models.DMCurrency
import com.androidpoet.domain.models.DMLatestRate
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class CurrenciesLocalSourceImpl @Inject constructor(
    private val ccDatabase: CCDatabase,
    private val coroutineContext: CoroutineContext,
    private val dataStore: DataStore<Preferences>,
    private val networkJson: Json
) : CurrenciesLocalSource {
    private val currenciesTime = longPreferencesKey(CURRENCIES_KEY)
    private val latestPricesKey = longPreferencesKey(CurrencyConverter.LATEST_PRICES_KEY)

    override suspend fun canFetchCurrencies(): Boolean {
        val time = dataStore.data.map { preferences ->
            preferences[currenciesTime]
        }.firstOrNull()
        return time?.let {
            val savedTime = TimeUnit.MILLISECONDS.toMinutes(it.times(1000))
            val nowTime = TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis())
            nowTime.minus(savedTime) > 30
        } ?: kotlin.run {
            true
        }
    }

    override suspend fun canFetchLatestRates(): Boolean {
        val time = dataStore.data.map { preferences ->
            preferences[latestPricesKey]
        }.firstOrNull()
        return time?.let {
            val savedTime = TimeUnit.MILLISECONDS.toMinutes(it.times(1000))
            val nowTime = TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis())
            nowTime.minus(savedTime) > 30
        } ?: kotlin.run {
            true
        }
    }

    override suspend fun latestRatesFetchLastTime(): Date? {
        val time = dataStore.data.map { preferences ->
            preferences[latestPricesKey]
        }.firstOrNull()
        return time?.let {
            Date(it.times(1000))
        } ?: kotlin.run {
            null
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun fetchLocalCurrencies(searchKey: String?): Flow<List<DMCurrency>> {
        val data = searchKey?.takeIf { it.isNotEmpty() }?.let {
            ccDatabase.currenciesDao().currenciesByKey("%${searchKey}%")
        } ?: run {
            ccDatabase.currenciesDao().currenciesPaginated()
        }

        val currencySymbol = networkJson.decodeFromString<Map<String, String>>(SymbolDataSource.SymbolList)

        return data.mapLatest { localCurrency ->
            localCurrency.map {
                DMCurrency(
                    it.currency,
                    it.name,
                    currencySymbol[it.currency].toString()
                )
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun fetchLocalRates(searchKey: String?, input: Double): Flow<List<DMLatestRate>> {
        val data = searchKey?.takeIf { it.isNotEmpty() }?.let {
            ccDatabase.currenciesDao().currenciesByKey("%${searchKey}%")
        } ?: run {
            ccDatabase.currenciesDao().currenciesPaginated()
        }


        return data.mapLatest {
            it.map {
                DMLatestRate(
                    it.currency,
                    it.rate ?: 0.0, name = it.name
                )
            }
        }
    }

    override suspend fun saveCurrenciesLocally(currencies: Map<String, String>) {
        withContext(coroutineContext) {
            ccDatabase.currenciesDao()
                .insertAll(currencies.map { LocalCurrency(it.key, it.value) })
            dataStore.edit { settings ->
                settings[currenciesTime] = System.currentTimeMillis() / 1000
            }
        }

    }

    override suspend fun saveLatestRates(rates: Map<String, Double>?) {
        withContext(coroutineContext) {
            rates?.entries?.forEach { (key, rate) ->
                ccDatabase.currenciesDao().updateCurrencyRates(key, rate)
            }
            dataStore.edit { settings ->
                settings[latestPricesKey] = System.currentTimeMillis() / 1000
            }
        }

    }
}