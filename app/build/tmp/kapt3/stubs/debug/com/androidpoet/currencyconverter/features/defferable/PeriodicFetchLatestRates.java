package com.androidpoet.currencyconverter.features.defferable;

import java.lang.System;

@androidx.hilt.work.HiltWorker()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B+\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0011\u0010\u000b\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/androidpoet/currencyconverter/features/defferable/PeriodicFetchLatestRates;", "Landroidx/work/CoroutineWorker;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "useCaseFetchLatestPrices", "Lcom/androidpoet/domain/usecase/UseCaseLoadLatestPricesFromNetwork;", "useCaseLoadCurrenciesDataFromNetwork", "Lcom/androidpoet/domain/usecase/UseCaseLoadCurrenciesDataFromNetwork;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;Lcom/androidpoet/domain/usecase/UseCaseLoadLatestPricesFromNetwork;Lcom/androidpoet/domain/usecase/UseCaseLoadCurrenciesDataFromNetwork;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class PeriodicFetchLatestRates extends androidx.work.CoroutineWorker {
    private final com.androidpoet.domain.usecase.UseCaseLoadLatestPricesFromNetwork useCaseFetchLatestPrices = null;
    private final com.androidpoet.domain.usecase.UseCaseLoadCurrenciesDataFromNetwork useCaseLoadCurrenciesDataFromNetwork = null;
    
    @dagger.assisted.AssistedInject()
    public PeriodicFetchLatestRates(@org.jetbrains.annotations.NotNull()
    @dagger.assisted.Assisted()
    android.content.Context appContext, @org.jetbrains.annotations.NotNull()
    @dagger.assisted.Assisted()
    androidx.work.WorkerParameters workerParams, @org.jetbrains.annotations.NotNull()
    com.androidpoet.domain.usecase.UseCaseLoadLatestPricesFromNetwork useCaseFetchLatestPrices, @org.jetbrains.annotations.NotNull()
    com.androidpoet.domain.usecase.UseCaseLoadCurrenciesDataFromNetwork useCaseLoadCurrenciesDataFromNetwork) {
        super(null, null);
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object doWork(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> continuation) {
        return null;
    }
}