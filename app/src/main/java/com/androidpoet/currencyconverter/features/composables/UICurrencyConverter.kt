package com.androidpoet.currencyconverter.features.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.androidpoet.currencyconverter.features.CurrencyConverterVM


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UICurrencyConverter(viewModel: CurrencyConverterVM) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Currency Converter",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { viewModel.clearCurrency() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "back"
                        )
                    }
                },

                )
        },
        content = { innerPadding ->
            CurrencyConverterForm(Modifier.padding(innerPadding), viewModel)
        }
    )
}