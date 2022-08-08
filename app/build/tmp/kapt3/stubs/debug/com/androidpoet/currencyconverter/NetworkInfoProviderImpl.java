package com.androidpoet.currencyconverter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/androidpoet/currencyconverter/NetworkInfoProviderImpl;", "Lcom/androidpoet/domain/NetworkInfoProvider;", "connectivityManager", "Landroid/net/ConnectivityManager;", "(Landroid/net/ConnectivityManager;)V", "hasNetwork", "", "listenToChanges", "Lkotlinx/coroutines/flow/Flow;", "app_debug"})
public final class NetworkInfoProviderImpl implements com.androidpoet.domain.NetworkInfoProvider {
    private final android.net.ConnectivityManager connectivityManager = null;
    
    @javax.inject.Inject()
    public NetworkInfoProviderImpl(@org.jetbrains.annotations.NotNull()
    android.net.ConnectivityManager connectivityManager) {
        super();
    }
    
    @java.lang.Override()
    public boolean hasNetwork() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<java.lang.Boolean> listenToChanges() {
        return null;
    }
}