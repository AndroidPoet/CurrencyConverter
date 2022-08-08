package com.androidpoet.currencyconverter.di

import com.androidpoet.currencyconverter.NetworkInfoProviderImpl
import com.androidpoet.data.local.CurrenciesLocalSourceImpl
import com.androidpoet.data.network.CurrencyAPI
import com.androidpoet.data.network.CurrencyAPIImpl
import com.androidpoet.data.repo.CurrenciesRepositoryImpl
import com.androidpoet.data.repo.LatestPricesRepositoryImpl
import com.androidpoet.domain.CurrenciesLocalSource
import com.androidpoet.domain.CurrenciesRepository
import com.androidpoet.domain.LatestPricesRepository
import com.androidpoet.domain.NetworkInfoProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CurrencyConverterModule {

    @Binds
    @Singleton
    abstract fun provideCurrenciesLocalSource(currenciesLocalSource: CurrenciesLocalSourceImpl): CurrenciesLocalSource

    @Binds
    @Singleton
    abstract fun provideCurrencyApi(currencyAPIImpl: CurrencyAPIImpl): CurrencyAPI

    @Binds
    @Singleton
    abstract fun provideNetworkInfoProviderImpl(networkInfoProvider: NetworkInfoProviderImpl): NetworkInfoProvider

    @Binds
    @Singleton
    abstract fun provideLatestPricesRepository(latestPricesRepo: LatestPricesRepositoryImpl): LatestPricesRepository

    @Binds
    @Singleton
    abstract fun provideCurrenciesRepository(latestPricesRepo: CurrenciesRepositoryImpl): CurrenciesRepository
}