package com.androidpoet.currencyconverter.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidpoet.currencyconverter.features.exceptions.NetworkNotAvailableException
import com.androidpoet.domain.NetworkInfoProvider
import com.androidpoet.domain.models.DMCurrency
import com.androidpoet.domain.models.DMLatestRate
import com.androidpoet.domain.usecase.UseCaseFetchCurrencies
import com.androidpoet.domain.usecase.UseCaseFetchLatestPrices
import com.androidpoet.domain.usecase.UseCaseLoadCurrenciesDataFromNetwork
import com.androidpoet.domain.usecase.UseCaseLoadLatestPricesFromNetwork
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class CurrencyConverterVM @Inject constructor(
    private val useCaseLoadCurrenciesDataFromNetwork: UseCaseLoadCurrenciesDataFromNetwork,
    private val useCaseLoadLatestPricesFromNetwork: UseCaseLoadLatestPricesFromNetwork,
    private val useCaseFetchLatestPrices: UseCaseFetchLatestPrices,
    private val useCaseFetchCurrencies: UseCaseFetchCurrencies,
    private val networkInfoProvider: NetworkInfoProvider
) :
    ViewModel() {

    var viewState = MutableStateFlow<ViewState>(ViewState.Empty)
        private set

    var selectedCurrency = MutableStateFlow<Triple<String, String,String>?>(null)
    var searchCurrency = MutableStateFlow("")
    var amountForConversion = MutableStateFlow("")

    private val _currenciesState = MutableStateFlow<Flow<List<DMCurrency>>>(emptyFlow())
    val currenciesState = _currenciesState.asStateFlow()

    private var _latestRatesState = MutableStateFlow<Flow<List<DMLatestRate>>>(emptyFlow())
    val latestRatesState = _latestRatesState.asStateFlow()

    private val currenciesException = CoroutineExceptionHandler { _, throwable ->
        viewState.value = ViewState.Exception(throwable)
    }

    init {
        registerNetwork()
        forceFetchCurrenciesOnLaunch()
        registerOnSearchChangeFlow()
        registerOnAmountChangeFlow()
    }

    private fun registerNetwork() {
        networkInfoProvider.listenToChanges().onEach {
            onNetworkAvailable(it)
        }.launchIn(viewModelScope)
    }

    private fun onNetworkAvailable(available: Boolean?) {
        if (available == true) {
            // network is available now! Let's refresh the UI
            // with latest data if DataState.LoadComplete never encountered ?
            if (viewState.value !is ViewState.LoadComplete && viewState.value !is ViewState.Loading) {
                forceFetchCurrenciesOnLaunch()
            }
        }
    }

    private fun registerOnSearchChangeFlow() {
        searchCurrency.onEach { // on every search keystroke we update the flow
            _currenciesState.value = flowFetchCurrencies()
        }.launchIn(viewModelScope)
    }

    private fun registerOnAmountChangeFlow() {
        amountForConversion.onEach {
            _latestRatesState.value = flowFetchRates()
        }.launchIn(viewModelScope)
    }


    private fun forceFetchCurrenciesOnLaunch() {
        if (networkInfoProvider.hasNetwork()) {
            viewModelScope.launch(currenciesException) {
                // do this in launch
                viewState.value = ViewState.Loading
                useCaseLoadCurrenciesDataFromNetwork.perform()
                val completeDate = useCaseLoadLatestPricesFromNetwork.perform()
                viewState.value = ViewState.LoadComplete(completeDate)
            }
        } else {
            viewState.value =
                ViewState.Exception(NetworkNotAvailableException("No Network Available!"))
        }
    }

    private fun flowFetchCurrencies(): Flow<List<DMCurrency>> {
        return useCaseFetchCurrencies.perform(searchCurrency.value)
    }

    private fun flowFetchRates(): Flow<List<DMLatestRate>> {
        return useCaseFetchLatestPrices.perform(amountForConversion.value)

    }

    fun updateCurrency(key: Triple<String, String,String>) {
        amountForConversion.value = ""
        selectedCurrency.value = key
        searchCurrency.value = key.second
    }

    fun clearCurrency() {
        amountForConversion.value = ""
        selectedCurrency.value = null
        searchCurrency.value = ""
    }

    sealed class ViewState {
        object Empty : ViewState()
        object Loading : ViewState()
        data class LoadComplete(val date: Date) : ViewState()
        data class Exception(val throwable: Throwable) : ViewState()
    }

}