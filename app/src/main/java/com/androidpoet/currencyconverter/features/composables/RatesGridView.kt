package com.androidpoet.currencyconverter.features.composables


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberAsyncImagePainter
import com.androidpoet.currencyconverter.R
import com.androidpoet.currencyconverter.features.CurrencyConverterVM
import com.androidpoet.currencyconverter.removeThirdSpace
import com.androidpoet.currencyconverter.roundofDecimal
import com.androidpoet.domain.models.DMLatestRate
import kotlin.math.roundToLong

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun RatesView(viewModel: CurrencyConverterVM, selectedCurrency: Triple<String, String, String>?) {
    val ratesFlow by viewModel.latestRatesState.collectAsStateWithLifecycle()
    val rates by ratesFlow.collectAsStateWithLifecycle(initialValue = emptyList())
    val amount by viewModel.amountForConversion.collectAsStateWithLifecycle()
    LazyColumn(content = {
        items(rates) { rate ->
            RateView(rate, amount.toString(), selectedCurrency)
        }
    })
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun RateView(
    dmLatestRate: DMLatestRate?,
    amount: String,
    selectedCurrency: Triple<String, String, String>?
) {
    dmLatestRate?.let { item ->


        val context = LocalContext.current
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .wrapContentSize()
                .clickable {
                },
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(3.dp),
            shape = RoundedCornerShape(2.dp)
        ) {

            val drawableId1 = remember(selectedCurrency?.first) {
                selectedCurrency?.let { (key, _) ->
                    context.resources.getIdentifier(
                        selectedCurrency.first.lowercase(),
                        "drawable",
                        context.packageName
                    )
                }

            }


            val drawableId2 = remember(item.currency) {
                context.resources.getIdentifier(
                    item.currency.lowercase(),
                    "drawable",
                    context.packageName
                )
            }






            ConstraintLayout(
                Modifier
                    .fillMaxSize()
                    .padding(20.dp)



            ) {



                val (
                    selectedCurrencyFirst, selectedCurrencySecond, Converted, OutlinedCard, itemCurrency,
                    itemName, Rate
                ) = createRefs()


                if (selectedCurrency != null) {
                    Text(
                        text = selectedCurrency.first,
                        fontWeight = FontWeight.Black,
                        modifier = Modifier
                            .padding()
                            .constrainAs(selectedCurrencyFirst) {
                                start.linkTo(parent.start)
                            }
                            .wrapContentSize()


                    )


                    Text(
                        text = selectedCurrency.second,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Gray,

                        fontSize = 12.sp,
                        modifier = Modifier
                            .padding()
                            .constrainAs(selectedCurrencySecond) {
                                top.linkTo(selectedCurrencyFirst.bottom)
                            }
                            .wrapContentSize()

                    )


                    Text(
//
                        text="${item.currency} = " + item.calculatedRate(amount.toDoubleOrNull() ?: 0.0).toString()+ " " + item.currency,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp,
                        modifier = Modifier
                            .fillMaxSize()
                            .constrainAs(Converted) {
                                bottom.linkTo(parent.bottom)
                                height = Dimension.fillToConstraints
                            }


                    )


                }
                OutlinedCard(

                    modifier = Modifier
                        .constrainAs(OutlinedCard)
                        {
                            centerHorizontallyTo(parent)
                        }
                        .wrapContentSize(),
                    shape = RoundedCornerShape(0.dp),
                    border = BorderStroke(1.dp, Color.LightGray),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(1.dp),

                    ) {
                    Row(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(5.dp),
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(drawableId1),
                            contentDescription = null,
                            modifier = Modifier
                                .size(25.dp)
                                .padding(5.dp)

                        )


                        Image(
                            painter = rememberAsyncImagePainter(R.drawable.transfer),
                            contentDescription = null,
                            modifier = Modifier
                                .size(20.dp)
                                .padding(5.dp)

                        )


                        Image(
                            painter = rememberAsyncImagePainter(drawableId2),
                            contentDescription = null,
                            modifier = Modifier
                                .size(25.dp)
                                .padding(5.dp)

                        )

                    }

                }
                Text(
                    text = item.currency,
                    fontWeight = FontWeight.Black,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .wrapContentSize()
                        .padding()
                        .constrainAs(itemCurrency) {
                            end.linkTo(parent.end)
                            top.linkTo(parent.top)
                        }

                )


                Text(

                    text =  item.name.removeThirdSpace(),
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Gray,
                    maxLines = 1,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .wrapContentSize()
                        .padding()
                        .constrainAs(itemName) {
                            end.linkTo(parent.end)
                            top.linkTo(itemCurrency.bottom)
                            height = Dimension.fillToConstraints
                        },

                    )


                Text(
                    text = "Rate: " + item.rate.toBigDecimal().roundofDecimal(),
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color(0xFF4CAF50),
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .wrapContentSize()
                        .constrainAs(Rate) {
                            end.linkTo(parent.end)
                            bottom.linkTo(parent.bottom)
                            top.linkTo(itemName.bottom)
                        }

                )

            }


        }

    }
}