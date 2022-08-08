// Generated by Dagger (https://dagger.dev).
package com.androidpoet.currencyconverter.di;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DataModule_ProvideDataStoreFactory implements Factory<DataStore<Preferences>> {
  private final DataModule module;

  private final Provider<Context> contextProvider;

  public DataModule_ProvideDataStoreFactory(DataModule module, Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public DataStore<Preferences> get() {
    return provideDataStore(module, contextProvider.get());
  }

  public static DataModule_ProvideDataStoreFactory create(DataModule module,
      Provider<Context> contextProvider) {
    return new DataModule_ProvideDataStoreFactory(module, contextProvider);
  }

  public static DataStore<Preferences> provideDataStore(DataModule instance, Context context) {
    return Preconditions.checkNotNullFromProvides(instance.provideDataStore(context));
  }
}
