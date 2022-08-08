package com.androidpoet.currencyconverter.features;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001;B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0006\u0010-\u001a\u00020.J\u0014\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fH\u0002J\u0014\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00100\u000fH\u0002J\b\u00101\u001a\u00020.H\u0002J\u0017\u00102\u001a\u00020.2\b\u00103\u001a\u0004\u0018\u000104H\u0002\u00a2\u0006\u0002\u00105J\b\u00106\u001a\u00020.H\u0002J\b\u00107\u001a\u00020.H\u0002J\b\u00108\u001a\u00020.H\u0002J \u00109\u001a\u00020.2\u0018\u0010:\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150&R \u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00100\u000f0\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f0\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR#\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00100\u000f0\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00150\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0017\"\u0004\b$\u0010\u0019R4\u0010%\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010&0\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u0017\"\u0004\b(\u0010\u0019R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u000e2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u000e@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0017\u00a8\u0006<"}, d2 = {"Lcom/androidpoet/currencyconverter/features/CurrencyConverterVM;", "Landroidx/lifecycle/ViewModel;", "useCaseLoadCurrenciesDataFromNetwork", "Lcom/androidpoet/domain/usecase/UseCaseLoadCurrenciesDataFromNetwork;", "useCaseLoadLatestPricesFromNetwork", "Lcom/androidpoet/domain/usecase/UseCaseLoadLatestPricesFromNetwork;", "useCaseFetchLatestPrices", "Lcom/androidpoet/domain/usecase/UseCaseFetchLatestPrices;", "useCaseFetchCurrencies", "Lcom/androidpoet/domain/usecase/UseCaseFetchCurrencies;", "networkInfoProvider", "Lcom/androidpoet/domain/NetworkInfoProvider;", "(Lcom/androidpoet/domain/usecase/UseCaseLoadCurrenciesDataFromNetwork;Lcom/androidpoet/domain/usecase/UseCaseLoadLatestPricesFromNetwork;Lcom/androidpoet/domain/usecase/UseCaseFetchLatestPrices;Lcom/androidpoet/domain/usecase/UseCaseFetchCurrencies;Lcom/androidpoet/domain/NetworkInfoProvider;)V", "_currenciesState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/androidpoet/domain/models/DMCurrency;", "_latestRatesState", "Lcom/androidpoet/domain/models/DMLatestRate;", "amountForConversion", "", "getAmountForConversion", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "setAmountForConversion", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "currenciesException", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "currenciesState", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrenciesState", "()Lkotlinx/coroutines/flow/StateFlow;", "latestRatesState", "getLatestRatesState", "searchCurrency", "getSearchCurrency", "setSearchCurrency", "selectedCurrency", "Lkotlin/Triple;", "getSelectedCurrency", "setSelectedCurrency", "<set-?>", "Lcom/androidpoet/currencyconverter/features/CurrencyConverterVM$ViewState;", "viewState", "getViewState", "clearCurrency", "", "flowFetchCurrencies", "flowFetchRates", "forceFetchCurrenciesOnLaunch", "onNetworkAvailable", "available", "", "(Ljava/lang/Boolean;)V", "registerNetwork", "registerOnAmountChangeFlow", "registerOnSearchChangeFlow", "updateCurrency", "key", "ViewState", "app_debug"})
public final class CurrencyConverterVM extends androidx.lifecycle.ViewModel {
    private final com.androidpoet.domain.usecase.UseCaseLoadCurrenciesDataFromNetwork useCaseLoadCurrenciesDataFromNetwork = null;
    private final com.androidpoet.domain.usecase.UseCaseLoadLatestPricesFromNetwork useCaseLoadLatestPricesFromNetwork = null;
    private final com.androidpoet.domain.usecase.UseCaseFetchLatestPrices useCaseFetchLatestPrices = null;
    private final com.androidpoet.domain.usecase.UseCaseFetchCurrencies useCaseFetchCurrencies = null;
    private final com.androidpoet.domain.NetworkInfoProvider networkInfoProvider = null;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<com.androidpoet.currencyconverter.features.CurrencyConverterVM.ViewState> viewState;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<kotlin.Triple<java.lang.String, java.lang.String, java.lang.String>> selectedCurrency;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> searchCurrency;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> amountForConversion;
    private final kotlinx.coroutines.flow.MutableStateFlow<kotlinx.coroutines.flow.Flow<java.util.List<com.androidpoet.domain.models.DMCurrency>>> _currenciesState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<kotlinx.coroutines.flow.Flow<java.util.List<com.androidpoet.domain.models.DMCurrency>>> currenciesState = null;
    private kotlinx.coroutines.flow.MutableStateFlow<kotlinx.coroutines.flow.Flow<java.util.List<com.androidpoet.domain.models.DMLatestRate>>> _latestRatesState;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<kotlinx.coroutines.flow.Flow<java.util.List<com.androidpoet.domain.models.DMLatestRate>>> latestRatesState = null;
    private final kotlinx.coroutines.CoroutineExceptionHandler currenciesException = null;
    
    @javax.inject.Inject()
    public CurrencyConverterVM(@org.jetbrains.annotations.NotNull()
    com.androidpoet.domain.usecase.UseCaseLoadCurrenciesDataFromNetwork useCaseLoadCurrenciesDataFromNetwork, @org.jetbrains.annotations.NotNull()
    com.androidpoet.domain.usecase.UseCaseLoadLatestPricesFromNetwork useCaseLoadLatestPricesFromNetwork, @org.jetbrains.annotations.NotNull()
    com.androidpoet.domain.usecase.UseCaseFetchLatestPrices useCaseFetchLatestPrices, @org.jetbrains.annotations.NotNull()
    com.androidpoet.domain.usecase.UseCaseFetchCurrencies useCaseFetchCurrencies, @org.jetbrains.annotations.NotNull()
    com.androidpoet.domain.NetworkInfoProvider networkInfoProvider) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<com.androidpoet.currencyconverter.features.CurrencyConverterVM.ViewState> getViewState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<kotlin.Triple<java.lang.String, java.lang.String, java.lang.String>> getSelectedCurrency() {
        return null;
    }
    
    public final void setSelectedCurrency(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.MutableStateFlow<kotlin.Triple<java.lang.String, java.lang.String, java.lang.String>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getSearchCurrency() {
        return null;
    }
    
    public final void setSearchCurrency(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getAmountForConversion() {
        return null;
    }
    
    public final void setAmountForConversion(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<kotlinx.coroutines.flow.Flow<java.util.List<com.androidpoet.domain.models.DMCurrency>>> getCurrenciesState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<kotlinx.coroutines.flow.Flow<java.util.List<com.androidpoet.domain.models.DMLatestRate>>> getLatestRatesState() {
        return null;
    }
    
    private final void registerNetwork() {
    }
    
    private final void onNetworkAvailable(java.lang.Boolean available) {
    }
    
    private final void registerOnSearchChangeFlow() {
    }
    
    private final void registerOnAmountChangeFlow() {
    }
    
    private final void forceFetchCurrenciesOnLaunch() {
    }
    
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.androidpoet.domain.models.DMCurrency>> flowFetchCurrencies() {
        return null;
    }
    
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.androidpoet.domain.models.DMLatestRate>> flowFetchRates() {
        return null;
    }
    
    public final void updateCurrency(@org.jetbrains.annotations.NotNull()
    kotlin.Triple<java.lang.String, java.lang.String, java.lang.String> key) {
    }
    
    public final void clearCurrency() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/androidpoet/currencyconverter/features/CurrencyConverterVM$ViewState;", "", "()V", "Empty", "Exception", "LoadComplete", "Loading", "Lcom/androidpoet/currencyconverter/features/CurrencyConverterVM$ViewState$Empty;", "Lcom/androidpoet/currencyconverter/features/CurrencyConverterVM$ViewState$Exception;", "Lcom/androidpoet/currencyconverter/features/CurrencyConverterVM$ViewState$LoadComplete;", "Lcom/androidpoet/currencyconverter/features/CurrencyConverterVM$ViewState$Loading;", "app_debug"})
    public static abstract class ViewState {
        
        private ViewState() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/androidpoet/currencyconverter/features/CurrencyConverterVM$ViewState$Empty;", "Lcom/androidpoet/currencyconverter/features/CurrencyConverterVM$ViewState;", "()V", "app_debug"})
        public static final class Empty extends com.androidpoet.currencyconverter.features.CurrencyConverterVM.ViewState {
            @org.jetbrains.annotations.NotNull()
            public static final com.androidpoet.currencyconverter.features.CurrencyConverterVM.ViewState.Empty INSTANCE = null;
            
            private Empty() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/androidpoet/currencyconverter/features/CurrencyConverterVM$ViewState$Loading;", "Lcom/androidpoet/currencyconverter/features/CurrencyConverterVM$ViewState;", "()V", "app_debug"})
        public static final class Loading extends com.androidpoet.currencyconverter.features.CurrencyConverterVM.ViewState {
            @org.jetbrains.annotations.NotNull()
            public static final com.androidpoet.currencyconverter.features.CurrencyConverterVM.ViewState.Loading INSTANCE = null;
            
            private Loading() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/androidpoet/currencyconverter/features/CurrencyConverterVM$ViewState$LoadComplete;", "Lcom/androidpoet/currencyconverter/features/CurrencyConverterVM$ViewState;", "date", "Ljava/util/Date;", "(Ljava/util/Date;)V", "getDate", "()Ljava/util/Date;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class LoadComplete extends com.androidpoet.currencyconverter.features.CurrencyConverterVM.ViewState {
            @org.jetbrains.annotations.NotNull()
            private final java.util.Date date = null;
            
            @org.jetbrains.annotations.NotNull()
            public final com.androidpoet.currencyconverter.features.CurrencyConverterVM.ViewState.LoadComplete copy(@org.jetbrains.annotations.NotNull()
            java.util.Date date) {
                return null;
            }
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public java.lang.String toString() {
                return null;
            }
            
            public LoadComplete(@org.jetbrains.annotations.NotNull()
            java.util.Date date) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.util.Date component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.util.Date getDate() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/androidpoet/currencyconverter/features/CurrencyConverterVM$ViewState$Exception;", "Lcom/androidpoet/currencyconverter/features/CurrencyConverterVM$ViewState;", "throwable", "", "(Ljava/lang/Throwable;)V", "getThrowable", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class Exception extends com.androidpoet.currencyconverter.features.CurrencyConverterVM.ViewState {
            @org.jetbrains.annotations.NotNull()
            private final java.lang.Throwable throwable = null;
            
            @org.jetbrains.annotations.NotNull()
            public final com.androidpoet.currencyconverter.features.CurrencyConverterVM.ViewState.Exception copy(@org.jetbrains.annotations.NotNull()
            java.lang.Throwable throwable) {
                return null;
            }
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public java.lang.String toString() {
                return null;
            }
            
            public Exception(@org.jetbrains.annotations.NotNull()
            java.lang.Throwable throwable) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.Throwable component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.Throwable getThrowable() {
                return null;
            }
        }
    }
}