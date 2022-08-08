package com.androidpoet.currencyconverter.features.composables.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import com.androidpoet.currencyconverter.R

@Composable
fun CurrencyTextField(
    fieldValue: String,
    symbol: String,
    onChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = fieldValue,
        onValueChange = { newValue ->
            onChange(getValidatedNumber(newValue))
        },
        leadingIcon = {
            Text(
                text = symbol, color = Color(0xFFFFD700),
                fontWeight = FontWeight.Black,
            )
        },
        trailingIcon = {
            Text(
                text = "",
            )
        },
        placeholder = {
            Text(
                text = stringResource(R.string.enter_amount),
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
        },
        singleLine = true,
        maxLines = 1,
        modifier = modifier, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
    )
}


fun getValidatedNumber(text: String): String {
    // Start by filtering out unwanted characters like commas and multiple decimals
    val filteredChars = text.filterIndexed { index, c ->
        c in "0123456789" ||                      // Take all digits
                (c == '.' && text.indexOf('.') == index)  // Take only the first decimal
    }
    return filteredChars
}