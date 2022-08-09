package com.androidpoet.currencyconverter.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/androidpoet/currencyconverter/di/DataModule;", "", "()V", "provideCCDatabase", "Lcom/androidpoet/data/local/CCDatabase;", "context", "Landroid/content/Context;", "provideConnectivityManager", "Landroid/net/ConnectivityManager;", "provideCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "provideDataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "provideNetworkClient", "Lio/ktor/client/HttpClient;", "Companion", "app_debug"})
@dagger.Module()
public final class DataModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.androidpoet.currencyconverter.di.DataModule.Companion Companion = null;
    
    public DataModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final kotlin.coroutines.CoroutineContext provideCoroutineContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final io.ktor.client.HttpClient provideNetworkClient() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    @javax.inject.Singleton()
    @dagger.Provides()
    public final android.net.ConnectivityManager provideConnectivityManager(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final androidx.datastore.core.DataStore<androidx.datastore.preferences.core.Preferences> provideDataStore(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.androidpoet.data.local.CCDatabase provideCCDatabase(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lcom/androidpoet/currencyconverter/di/DataModule$Companion;", "", "()V", "providesNetworkJson", "Lkotlinx/serialization/json/Json;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @javax.inject.Singleton()
        @dagger.Provides()
        public final kotlinx.serialization.json.Json providesNetworkJson() {
            return null;
        }
    }
}