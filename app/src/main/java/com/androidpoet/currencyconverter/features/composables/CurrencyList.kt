package com.androidpoet.currencyconverter.features.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
import com.androidpoet.domain.models.DMCurrency

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrencyList(
    currencies: List<DMCurrency>,
    onCurrencySelected: (Triple<String, String, String>) -> Unit
) {
    val context = LocalContext.current

    LazyColumn(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        items(currencies) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(8.dp)
                    .clickable {
                        onCurrencySelected(Triple(item.currency, item.name, item.symbol))
                    },
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(3.dp),
                shape = RoundedCornerShape(2.dp)
            ) {
                Box(Modifier.fillMaxSize()) {

                    val drawableId by derivedStateOf {context.resources.getIdentifier(
                        item.currency.lowercase(),
                        "drawable",
                        context.packageName
                    ) }

                    ConstraintLayout {
                        val (image, currency, name, symbol) = createRefs()
                        Image(
                            painter = rememberAsyncImagePainter(drawableId),
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp)
                                .padding(top = 10.dp)
                                .constrainAs(image) {
                                    start.linkTo(parent.start, margin = 16.dp)
                                }
                        )

                        androidx.compose.material3.Text(
                            text = item.currency,
                            fontWeight = FontWeight.Black,
                            fontSize = 17.sp,
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(vertical = 10.dp)
                                .constrainAs(currency) {
                                    start.linkTo(image.end, margin = 8.dp)
                                }
                        )

                        androidx.compose.material3.Text(
                            text = item.name,
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Gray,

                            fontSize = 12.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .constrainAs(name) {
                                    top.linkTo(currency.bottom, margin = 0.dp)
                                    start.linkTo(currency.start)
                                }
                        )



                        androidx.compose.material3.Text(
                            text = item.symbol,
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color(0xFFFFD700),
                            fontWeight = FontWeight.Black,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(top = 10.dp)
                                .constrainAs(symbol) {
                                    end.linkTo(parent.end, margin = 15.dp)
                                }
                        )


                    }
                }
            }


        }
    }
}