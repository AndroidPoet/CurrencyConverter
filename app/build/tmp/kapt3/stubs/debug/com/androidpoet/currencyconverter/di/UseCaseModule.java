package com.androidpoet.currencyconverter.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/androidpoet/currencyconverter/di/UseCaseModule;", "", "()V", "provideUseCaseFetchCurrencies", "Lcom/androidpoet/domain/usecase/UseCaseFetchCurrencies;", "currenciesRepository", "Lcom/androidpoet/domain/CurrenciesRepository;", "provideUseCaseFetchLatestPrices", "Lcom/androidpoet/domain/usecase/UseCaseFetchLatestPrices;", "latestPricesRepository", "Lcom/androidpoet/domain/LatestPricesRepository;", "provideUseCaseLoadCurrenciesData", "Lcom/androidpoet/domain/usecase/UseCaseLoadCurrenciesDataFromNetwork;", "provideUseCaseloadLatestPrices", "Lcom/androidpoet/domain/usecase/UseCaseLoadLatestPricesFromNetwork;", "app_debug"})
@dagger.Module()
public final class UseCaseModule {
    
    public UseCaseModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.androidpoet.domain.usecase.UseCaseFetchCurrencies provideUseCaseFetchCurrencies(@org.jetbrains.annotations.NotNull()
    com.androidpoet.domain.CurrenciesRepository currenciesRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.androidpoet.domain.usecase.UseCaseFetchLatestPrices provideUseCaseFetchLatestPrices(@org.jetbrains.annotations.NotNull()
    com.androidpoet.domain.LatestPricesRepository latestPricesRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.androidpoet.domain.usecase.UseCaseLoadLatestPricesFromNetwork provideUseCaseloadLatestPrices(@org.jetbrains.annotations.NotNull()
    com.androidpoet.domain.LatestPricesRepository latestPricesRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.androidpoet.domain.usecase.UseCaseLoadCurrenciesDataFromNetwork provideUseCaseLoadCurrenciesData(@org.jetbrains.annotations.NotNull()
    com.androidpoet.domain.CurrenciesRepository currenciesRepository) {
        return null;
    }
}