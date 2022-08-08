package com.androidpoet.currencyconverter.di

import com.androidpoet.domain.CurrenciesRepository
import com.androidpoet.domain.LatestPricesRepository
import com.androidpoet.domain.usecase.UseCaseFetchCurrencies
import com.androidpoet.domain.usecase.UseCaseFetchLatestPrices
import com.androidpoet.domain.usecase.UseCaseLoadCurrenciesDataFromNetwork
import com.androidpoet.domain.usecase.UseCaseLoadLatestPricesFromNetwork
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    @Singleton
    fun provideUseCaseFetchCurrencies(currenciesRepository: CurrenciesRepository) =
        UseCaseFetchCurrencies(currenciesRepository)

    @Provides
    @Singleton
    fun provideUseCaseFetchLatestPrices(latestPricesRepository: LatestPricesRepository) =
        UseCaseFetchLatestPrices(latestPricesRepository)

    @Provides
    @Singleton
    fun provideUseCaseloadLatestPrices(latestPricesRepository: LatestPricesRepository) =
        UseCaseLoadLatestPricesFromNetwork(latestPricesRepository)

    @Provides
    @Singleton
    fun provideUseCaseLoadCurrenciesData(currenciesRepository: CurrenciesRepository) =
        UseCaseLoadCurrenciesDataFromNetwork(currenciesRepository)
}