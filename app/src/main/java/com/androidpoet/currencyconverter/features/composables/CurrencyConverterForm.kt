package com.androidpoet.currencyconverter.features.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.androidpoet.currencyconverter.R
import com.androidpoet.currencyconverter.features.CurrencyConverterVM
import com.androidpoet.currencyconverter.features.composables.common.CurrencyAutoComplete
import com.androidpoet.currencyconverter.features.composables.common.CurrencyTextField

@OptIn(
    ExperimentalMaterialApi::class,
    ExperimentalLifecycleComposeApi::class
)
@Composable
fun CurrencyConverterForm(
    modifier: Modifier = Modifier,
    viewModel: CurrencyConverterVM
) {
    val amount by viewModel.amountForConversion.collectAsStateWithLifecycle()
    val selectedCurrency by viewModel.selectedCurrency.collectAsStateWithLifecycle()
    val dataState by viewModel.viewState.collectAsStateWithLifecycle()
    Box(modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            when (dataState) {
                is CurrencyConverterVM.ViewState.Loading -> {
                    Text(
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        text = "Refreshing Rates...", modifier = Modifier
                            .padding(12.dp)
                    )
                }
                is CurrencyConverterVM.ViewState.Exception -> {
                    Text(
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        text = "Failed: ${(dataState as CurrencyConverterVM.ViewState.Exception).throwable.localizedMessage}",
                        modifier = Modifier
                            .padding(12.dp)
                    )
                }
                CurrencyConverterVM.ViewState.Empty -> {
                    Text(
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        text = "Nothing to Show Here!", modifier = Modifier
                            .padding(12.dp)
                    )
                }
                is CurrencyConverterVM.ViewState.LoadComplete -> {
                    Text(
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Bold
                        ), modifier = Modifier
                            .padding(12.dp),
                        text = "Rates Updated on, ${(dataState as CurrencyConverterVM.ViewState.LoadComplete).date}"
                    )
                }
            }
            CurrenciesSelection(
                viewModel,
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            AnimatedVisibility(visible = selectedCurrency != null) {
                CurrencyTextField(
                    fieldValue = amount,
                    onChange = { newAmount ->
                        viewModel.amountForConversion.value = newAmount
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    symbol = selectedCurrency?.third.toString()
                )
            }
            RatesView(viewModel, selectedCurrency)

        }
    }
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalLifecycleComposeApi::class)
@ExperimentalMaterialApi
@Composable
fun CurrenciesSelection(viewModel: CurrencyConverterVM, modifier: Modifier = Modifier) {
    val controller = LocalSoftwareKeyboardController.current
    val currenciesStateFlow by viewModel.currenciesState.collectAsStateWithLifecycle()
    val currenciesState by currenciesStateFlow.collectAsStateWithLifecycle(initialValue = emptyList())

    val selectedCurrency by viewModel.selectedCurrency.collectAsStateWithLifecycle()
    val searchCurrency by viewModel.searchCurrency.collectAsStateWithLifecycle()




    Column(
        modifier = modifier
            .wrapContentSize(Alignment.TopStart)
    ) {
        selectedCurrency?.let { (_, _) ->

        } ?: run {
            CurrencyAutoComplete(
                query = searchCurrency,
                label = stringResource(R.string.converter_select_currency),
                isReadOnly = selectedCurrency != null,
                onQueryChanged = {
                    viewModel.searchCurrency.value = it
                }, onDoneActionClick = {
                    controller?.hide()
                }, onClearClick = {
                    viewModel.searchCurrency.value = ""
                    controller?.hide()
                })
            CurrencyList(
                currenciesState,
            ) { pair ->
                viewModel.updateCurrency(pair)

            }
        }
    }
}