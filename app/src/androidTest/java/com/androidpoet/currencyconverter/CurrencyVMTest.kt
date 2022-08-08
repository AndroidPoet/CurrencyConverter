package com.androidpoet.currencyconverter

import android.content.Context
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import app.cash.turbine.test
import com.androidpoet.currencyconverter.features.CurrencyConverterVM
import com.androidpoet.currencyconverter.features.exceptions.NetworkNotAvailableException
import com.androidpoet.data.local.CCDatabase
import com.androidpoet.data.local.CurrenciesLocalSourceImpl
import com.androidpoet.data.network.CurrencyAPI
import com.androidpoet.data.repo.CurrenciesRepositoryImpl
import com.androidpoet.data.repo.LatestPricesRepositoryImpl
import com.androidpoet.domain.usecase.UseCaseFetchCurrencies
import com.androidpoet.domain.usecase.UseCaseFetchLatestPrices
import com.androidpoet.domain.usecase.UseCaseLoadCurrenciesDataFromNetwork
import com.androidpoet.domain.usecase.UseCaseLoadLatestPricesFromNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CurrencyConverterVMShould {

    private var currencyAPI: CurrencyAPI = FakeCurrencyAPI()
    private val context = ApplicationProvider.getApplicationContext<Context>()

    private var networkInfoProvider = FakeNetworkInfoProvider()
    private val database = Room.inMemoryDatabaseBuilder(context, CCDatabase::class.java).build()

    val ds = PreferenceDataStoreFactory.create() {
        InstrumentationRegistry.getInstrumentation().targetContext.preferencesDataStoreFile(
            "test-preferences-file"
        )
    }

    private val currenciesLocalSource = CurrenciesLocalSourceImpl(
        database,Dispatchers.IO,ds
    )

    private val latestPricesRepository by lazy {
        LatestPricesRepositoryImpl(
            Dispatchers.Main,
            currencyAPI, currenciesLocalSource
        )
    }
    private val currenciesRepository by lazy {
        CurrenciesRepositoryImpl(
            Dispatchers.Main,
            currencyAPI, currenciesLocalSource
        )
    }

    private val useCaseFetchLatestPrices by lazy { UseCaseFetchLatestPrices(latestPricesRepository) }
    private val useCaseFetchCurrencies by lazy {
        UseCaseFetchCurrencies(currenciesRepository)
    }


    private val useCaseLoadCurrenciesDataFromNetwork by lazy {
        UseCaseLoadCurrenciesDataFromNetwork(
            currenciesRepository
        )
    }

    private val useCaseLoadLatestPricesFromNetwork by lazy {
        UseCaseLoadLatestPricesFromNetwork(latestPricesRepository)
    }

    private lateinit var currencyConverterVM: CurrencyConverterVM


    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(StandardTestDispatcher())
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun throwNetworkExceptionWhenNetworkNotAvailale() {
        runTest {
            launch {
                networkInfoProvider.networkSwitch(false)

                currencyConverterVM = CurrencyConverterVM(
                    useCaseLoadCurrenciesDataFromNetwork,
                    useCaseLoadLatestPricesFromNetwork,
                    useCaseFetchLatestPrices,
                    useCaseFetchCurrencies,
                    networkInfoProvider
                )

                currencyConverterVM.viewState.test {
                    val firstItem = awaitItem()
                    assert(firstItem is CurrencyConverterVM.ViewState.Exception && firstItem.throwable is NetworkNotAvailableException)
                    awaitComplete()
                }
            }
        }
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun returnCurrenciesWhenReceivedFromNetworkAndSavedIntoDatabase() {
        runTest {
            launch {
                networkInfoProvider.networkSwitch(true)

                currencyConverterVM = CurrencyConverterVM(
                    useCaseLoadCurrenciesDataFromNetwork,
                    useCaseLoadLatestPricesFromNetwork,
                    useCaseFetchLatestPrices,
                    useCaseFetchCurrencies,
                    networkInfoProvider
                )

                currencyConverterVM.viewState.test {
                    assert(awaitItem() is CurrencyConverterVM.ViewState.Empty)
                    assert(awaitItem() is CurrencyConverterVM.ViewState.Loading)
                    val lastComplete = awaitItem()
                    assert(lastComplete is CurrencyConverterVM.ViewState.LoadComplete)
                    val dataSet = database.currenciesDao().getAll()
                    assert(dataSet.isNotEmpty() && dataSet.size == 2)
                    awaitComplete()
                }
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testThatThenUserInputsTheCurrencyWeGeTheCalculatedAmount() {
        runTest {
            launch {
                val amountToConvert = 45.0

                networkInfoProvider.networkSwitch(true)

                currencyConverterVM = CurrencyConverterVM(
                    useCaseLoadCurrenciesDataFromNetwork,
                    useCaseLoadLatestPricesFromNetwork,
                    useCaseFetchLatestPrices,
                    useCaseFetchCurrencies,
                    networkInfoProvider
                )
                currencyConverterVM.amountForConversion.value = amountToConvert.toString()
                delay(10)
                currencyConverterVM.latestRatesState.value.test {
                    val pagingData = awaitItem()
                    assert(pagingData.size == 2)
                    assert(pagingData.first().calculatedRate(amountToConvert) == pagingData.first().rate.times(amountToConvert))
                    awaitComplete()
                }

            }
        }
    }
}