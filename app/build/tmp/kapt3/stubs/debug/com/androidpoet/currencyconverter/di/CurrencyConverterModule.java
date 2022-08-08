package com.androidpoet.currencyconverter.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\'J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0011H\'J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\'\u00a8\u0006\u0016"}, d2 = {"Lcom/androidpoet/currencyconverter/di/CurrencyConverterModule;", "", "()V", "provideCurrenciesLocalSource", "Lcom/androidpoet/domain/CurrenciesLocalSource;", "currenciesLocalSource", "Lcom/androidpoet/data/local/CurrenciesLocalSourceImpl;", "provideCurrenciesRepository", "Lcom/androidpoet/domain/CurrenciesRepository;", "latestPricesRepo", "Lcom/androidpoet/data/repo/CurrenciesRepositoryImpl;", "provideCurrencyApi", "Lcom/androidpoet/data/network/CurrencyAPI;", "currencyAPIImpl", "Lcom/androidpoet/data/network/CurrencyAPIImpl;", "provideLatestPricesRepository", "Lcom/androidpoet/domain/LatestPricesRepository;", "Lcom/androidpoet/data/repo/LatestPricesRepositoryImpl;", "provideNetworkInfoProviderImpl", "Lcom/androidpoet/domain/NetworkInfoProvider;", "networkInfoProvider", "Lcom/androidpoet/currencyconverter/NetworkInfoProviderImpl;", "app_debug"})
@dagger.Module()
public abstract class CurrencyConverterModule {
    
    public CurrencyConverterModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Binds()
    public abstract com.androidpoet.domain.CurrenciesLocalSource provideCurrenciesLocalSource(@org.jetbrains.annotations.NotNull()
    com.androidpoet.data.local.CurrenciesLocalSourceImpl currenciesLocalSource);
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Binds()
    public abstract com.androidpoet.data.network.CurrencyAPI provideCurrencyApi(@org.jetbrains.annotations.NotNull()
    com.androidpoet.data.network.CurrencyAPIImpl currencyAPIImpl);
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Binds()
    public abstract com.androidpoet.domain.NetworkInfoProvider provideNetworkInfoProviderImpl(@org.jetbrains.annotations.NotNull()
    com.androidpoet.currencyconverter.NetworkInfoProviderImpl networkInfoProvider);
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Binds()
    public abstract com.androidpoet.domain.LatestPricesRepository provideLatestPricesRepository(@org.jetbrains.annotations.NotNull()
    com.androidpoet.data.repo.LatestPricesRepositoryImpl latestPricesRepo);
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Binds()
    public abstract com.androidpoet.domain.CurrenciesRepository provideCurrenciesRepository(@org.jetbrains.annotations.NotNull()
    com.androidpoet.data.repo.CurrenciesRepositoryImpl latestPricesRepo);
}